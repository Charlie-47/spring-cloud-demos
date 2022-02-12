package top.charlie.cloud.order.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") String id) {
        String serviceUrl = "http://" + serviceUrl() + "/user/id";
        LOGGER.info("remote address -> " + serviceUrl);

        return restTemplate.getForObject(serviceUrl, String.class);
    }

    public String serviceUrl() {
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("USER-SERVICE", false);
        return instanceInfo.getIPAddr() + ":" + instanceInfo.getPort();
    }

}

package top.charlie.cloud.user.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") String id) {
        return "user id is: " + id;
    }

    @GetMapping("/service")
    public String serviceUrl() {
        InstanceInfo instanceInfo = discoveryClient.getNextServerFromEureka("ORDER-SERVICE", false);
        return instanceInfo.getIPAddr() + ":" + instanceInfo.getPort();
    }

}

package lt.vilniustech.dgrigorovic.LoadBalancer.controller; // Adjust the package path as necessary

import lt.vilniustech.dgrigorovic.LoadBalancer.client.MicroserviceFeignClient; // Import the Feign client
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoadBalancerController {

    private final MicroserviceFeignClient feignClient;

    @Autowired
    public LoadBalancerController(MicroserviceFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @GetMapping("/load-balanced-port")
    public String getPortFromMicroservice() {
        // Feign Client will automatically balance the load between instances of "pirmas-darbas"
        String response = feignClient.getPort();

        // Log the response
        System.out.println("Response from microservice: " + response);

        return response;
    }

    @GetMapping("/orders")
    public String filterOrders(@RequestParam String orderDate) {
        // Delegate request to microservice
        String response = feignClient.filterOrders(orderDate);
        System.out.println("Response from microservice: " + response);
        return response;
    }

}
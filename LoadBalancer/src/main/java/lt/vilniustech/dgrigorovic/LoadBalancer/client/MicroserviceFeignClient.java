package lt.vilniustech.dgrigorovic.LoadBalancer.client; // Adjust the package path as necessary

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "pirmas-darbas")  // The name of the service you want to call
public interface MicroserviceFeignClient {

    @GetMapping("/port")  // The endpoint to call on the microservice
    String getPort();

    @GetMapping("/orders")
    String filterOrders(@RequestParam String orderDate);


}
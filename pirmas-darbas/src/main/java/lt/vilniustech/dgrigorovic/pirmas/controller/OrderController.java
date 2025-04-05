package lt.vilniustech.dgrigorovic.pirmas.controller;

import lt.vilniustech.dgrigorovic.pirmas.config.TestConfig;
import lt.vilniustech.dgrigorovic.pirmas.model.Order;
import lt.vilniustech.dgrigorovic.pirmas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TestConfig testConfig;

    @Value("${server.port}")
    private String port;

    @GetMapping("/orders")
    public String getFilteredorders(@RequestParam String orderDate) {
        try {
            return orderService.filterAndSaveOrders(orderDate);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
    @GetMapping("/port")
    public String getPort() {
        System.out.println(port);
        return "Responding from port: " + port;
    }

    @GetMapping("/orders/list")
    public List<Order> getAllOrders() {
        try {
            // Assuming orderService has a method to fetch all orders
            return orderService.getAllOrders();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();  // Or return an appropriate error message
        }
    }

    @GetMapping("/config-check")
    public String checkConfig() {
        return "Config foo value: " + testConfig.getFoo();
    }

}

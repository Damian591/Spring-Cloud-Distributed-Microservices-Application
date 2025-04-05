package lt.vilniustech.dgrigorovic.pirmas.service;

import lt.vilniustech.dgrigorovic.pirmas.config.TestConfig;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lt.vilniustech.dgrigorovic.pirmas.db.OrderRepository;
import lt.vilniustech.dgrigorovic.pirmas.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll(); // This would return a list of all orders
    }

    @Value("${server.port}")
    private String port;
    public String filterAndSaveOrders(String orderDate) throws Exception{
        List<Order> orders = orderRepository.findByOrderDateContaining(orderDate);

        // Wrap the list in the wrapper class
        OrderListWrapper wrapper = new OrderListWrapper();
        wrapper.setOrders(orders);

        // Convert to XML
        JAXBContext context = JAXBContext.newInstance(OrderListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Save to local directory
        File file = new File("orders.xml");
        marshaller.marshal(wrapper, file);

        // Return the file path
        System.out.println("Responding from port: " + port);

        // Return the file path and port information
        return "File saved to: " + file.getAbsolutePath() + "\nResponding from port: " + port;
    }
}

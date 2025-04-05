package lt.vilniustech.dgrigorovic.pirmas;

import lt.vilniustech.dgrigorovic.pirmas.db.CustomerRepository;
import lt.vilniustech.dgrigorovic.pirmas.db.OrderRepository;
import lt.vilniustech.dgrigorovic.pirmas.model.Customer;
import lt.vilniustech.dgrigorovic.pirmas.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception{
        for(Order order : orderRepository.findAll())
        System.out.println(order);
    }
}

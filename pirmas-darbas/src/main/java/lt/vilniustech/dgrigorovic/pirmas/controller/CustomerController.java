package lt.vilniustech.dgrigorovic.pirmas.controller;

import lt.vilniustech.dgrigorovic.pirmas.db.CustomerRepository;
import lt.vilniustech.dgrigorovic.pirmas.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lt.vilniustech.dgrigorovic.pirmas.service.XMLTransformationService;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private XMLTransformationService transformationService;

    @GetMapping(produces = "application/json")
    List<Customer> getAllCustomers(){
        List<Customer> customers = customerRepository.findAll();
        for(Customer customer : customers) {
            //transformationService.transformToXML(customer);
        }
        return customers;
    }
}

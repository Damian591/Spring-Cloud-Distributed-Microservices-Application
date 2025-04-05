package lt.vilniustech.dgrigorovic.pirmas.service;

import lt.vilniustech.dgrigorovic.pirmas.db.OrderRepository;
import lt.vilniustech.dgrigorovic.pirmas.model.Order;
import org.springframework.stereotype.Service;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@Service
public class XMLTransformationService {
    
    private OrderRepository orderRepository;
    public void transformToXML (Order order) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance( Order.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(order, System.out);
        } catch (JAXBException e){
            System.out.println(e.getMessage());
        }
    }
}

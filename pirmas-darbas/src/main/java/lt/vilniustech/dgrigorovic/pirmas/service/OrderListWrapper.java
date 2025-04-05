package lt.vilniustech.dgrigorovic.pirmas.service;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lt.vilniustech.dgrigorovic.pirmas.model.Order;

import java.util.List;

@XmlRootElement(name = "orders")
public class OrderListWrapper {

    private List<Order> orders;
    @XmlElement(name = "order")
    public List<Order> getOrders(){ return orders;}

    public void setOrders(List<Order> orders) {this.orders = orders;}
}

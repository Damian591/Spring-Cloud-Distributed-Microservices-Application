package lt.vilniustech.dgrigorovic.pirmas.db;

import lt.vilniustech.dgrigorovic.pirmas.model.Customer;
import lt.vilniustech.dgrigorovic.pirmas.model.Order;
import lt.vilniustech.dgrigorovic.pirmas.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByOrderDateContaining(String orderDate);
}
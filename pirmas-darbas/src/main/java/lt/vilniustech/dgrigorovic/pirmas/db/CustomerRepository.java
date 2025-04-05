package lt.vilniustech.dgrigorovic.pirmas.db;

import lt.vilniustech.dgrigorovic.pirmas.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

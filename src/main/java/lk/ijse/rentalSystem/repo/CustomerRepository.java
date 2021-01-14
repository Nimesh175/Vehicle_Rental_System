package lk.ijse.rentalSystem.repo;

import lk.ijse.rentalSystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findCustomersByUsername(String username);
}

package lk.ijse.rentalSystem.repo;

import lk.ijse.rentalSystem.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,String> {
}

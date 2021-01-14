package lk.ijse.rentalSystem.repo;

import lk.ijse.rentalSystem.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,String> {
    Driver findDriverByUsername(String username);
}

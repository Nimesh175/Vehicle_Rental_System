package lk.ijse.rentalSystem.repo;

import lk.ijse.rentalSystem.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory,String> {
}

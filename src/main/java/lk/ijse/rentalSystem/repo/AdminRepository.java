package lk.ijse.rentalSystem.repo;

import lk.ijse.rentalSystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Admin findAdminByUsername(String username);
}

package lk.ijse.rentalSystem.repo;

import lk.ijse.rentalSystem.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,String> {
}


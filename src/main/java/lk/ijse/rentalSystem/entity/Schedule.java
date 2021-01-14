package lk.ijse.rentalSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Schedule {
    @Id
    private String schedule_id;
    private java.sql.Timestamp  start_date;
    private java.sql.Timestamp  end_date;


    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    @JoinColumn(name = "driver_id")
    private Driver driver_id;

    @OneToOne(mappedBy = "os_id")
    private OrderDetails list;

    public Schedule(String schedule_id, Timestamp start_date, Timestamp end_date, Driver driver_id) {
        this.schedule_id = schedule_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.driver_id = driver_id;
    }
}

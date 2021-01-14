package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderDetails {

    @Id
    private String ov_id;

    private String type_of_rate;
    private int day_month_count;
    private String cus_bank_slip;
    private double meter_on;
    private double meter_off;
    private boolean driver_request;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name = "order_id")
    private Orders order_id;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle_id;

    @OneToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name = "os_id")
    private Schedule os_id;


    @OneToMany(mappedBy = "ov_id")
    private List<Payment> list;

    public OrderDetails(String ov_id, String type_of_rate, int day_month_count, String cus_bank_slip, double meter_on, double meter_off, boolean driver_request, Orders order_id, Vehicle vehicle_id, Schedule os_id) {
        this.ov_id = ov_id;
        this.type_of_rate = type_of_rate;
        this.day_month_count = day_month_count;
        this.cus_bank_slip = cus_bank_slip;
        this.meter_on = meter_on;
        this.meter_off = meter_off;
        this.driver_request = driver_request;
        this.order_id = order_id;
        this.vehicle_id = vehicle_id;
        this.os_id = os_id;
    }
}

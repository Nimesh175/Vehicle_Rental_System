package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    private String vehicle_id;
    private String register_number;
    private String color;
    private String brand;
    private String type;
    private String fuel_type;
    private String transmission_type;
    private int passenger_count;

    private double free_km_daily;
    private double free_km_monthly;

    private double daily_rent;
    private double monthly_rent;

    private double extra_km_rent;

    private boolean available_status;

    private boolean maintain_status;
    private double start_meter;
    private double last_meter;

    private String front_pic;
    private String back_pic;
    private String side_pic;
    private String interior_pic;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name = "category_id")
    private VehicleCategory category_id;

    @OneToMany(mappedBy = "vehicle_id")
    private List<OrderDetails> list;

    public Vehicle(String vehicle_id, String register_number, String color, String brand, String type, String fuel_type, String transmission_type, int passenger_count, double free_km_daily, double free_km_monthly, double daily_rent, double monthly_rent, double extra_km_rent, boolean available_status, boolean maintain_status, double start_meter, double last_meter, String front_pic, String back_pic, String side_pic, String interior_pic, VehicleCategory category_id) {
        this.vehicle_id = vehicle_id;
        this.register_number = register_number;
        this.color = color;
        this.brand = brand;
        this.type = type;
        this.fuel_type = fuel_type;
        this.transmission_type = transmission_type;
        this.passenger_count = passenger_count;
        this.free_km_daily = free_km_daily;
        this.free_km_monthly = free_km_monthly;
        this.daily_rent = daily_rent;
        this.monthly_rent = monthly_rent;
        this.extra_km_rent = extra_km_rent;
        this.available_status = available_status;
        this.maintain_status = maintain_status;
        this.start_meter = start_meter;
        this.last_meter = last_meter;
        this.front_pic = front_pic;
        this.back_pic = back_pic;
        this.side_pic = side_pic;
        this.interior_pic = interior_pic;
        this.category_id = category_id;
    }

}

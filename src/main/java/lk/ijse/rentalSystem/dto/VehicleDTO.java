package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {

    /**
     * - vehicle_id :String
     * - category_id :String
     * - image_id :String       //last
     * - reg_number :String
     * - color :String
     * - brand :String
     * - type :String
     * - fuel_type :String
     * - transmission_type :String
     * - passenger_count :Integer
     * - free_km_daily :Double
     * - free_km_monthly :Double
     * - daily_rent :Double
     * - monthly_rent :Double
     * - extra_km_rent :Double
     * - available_status :boolean
     * - maintain_status :boolean
     * - start_meter :Double
     * - last_meter :Double
     *
     * - front_pic :String
     * - back_pic :String
     * - side_pic :String
     * - interior :String**/


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

    private String category_id;


}

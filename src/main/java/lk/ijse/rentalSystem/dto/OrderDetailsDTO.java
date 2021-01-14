package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO {

    private String ov_id;

    private String type_of_rate;
    private int day_month_count;
    private String cus_bank_slip;
    private double meter_on;
    private double meter_off;
    private boolean driver_request;

    private String order_id;
    private String vehicle_id;
    private String os_id;



}

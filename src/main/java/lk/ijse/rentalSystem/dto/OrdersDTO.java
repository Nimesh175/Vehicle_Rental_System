package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private String order_id;
    private String status;
    private String order_date;
    private String customer_id;
}

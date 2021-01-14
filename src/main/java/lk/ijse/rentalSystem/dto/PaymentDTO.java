package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private String payment_id;
    private String payment_type;
    private double loss_damage_fee;
    private double deducted_amount;
    private double return_fee;
    private double net_fee;
    private double extra_fee;
    private double total_fee;

    private String ov_id;


}

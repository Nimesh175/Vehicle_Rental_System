package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String payment_id;
    private String payment_type;
    private double loss_damage_fee;
    private double deducted_amount;
    private double return_fee;
    private double net_fee;
    private double extra_fee;
    private double total_fee;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name = "ov_id")
    private OrderDetails ov_id;

}

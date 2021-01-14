package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleCategoryDTO {
    private String category_id;
    private String category_name;
    private Double loss_damage_amount;

}

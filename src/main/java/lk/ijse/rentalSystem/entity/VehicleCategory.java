package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class VehicleCategory {
    @Id
    private String category_id;
    private String category_name;
    private Double loss_damage_amount;

    @OneToMany(mappedBy = "category_id")
    private List<Vehicle> list;
}

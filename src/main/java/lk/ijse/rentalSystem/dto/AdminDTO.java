package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    private Integer id;
    private String full_name;
    private String nic;
    private String email;
    private Integer contact;
    private String username;
    private String password;
}

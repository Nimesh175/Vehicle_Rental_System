package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private String driver_id;
    private String first_name;
    private String last_name;
    private String nic;
    private String email;
    private Integer contact;
    private String address;
    private String licence_pic;
    private boolean available_status;
    private String username;
    private String password;
}

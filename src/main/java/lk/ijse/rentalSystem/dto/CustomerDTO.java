package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String customer_id;
    private String first_name;
    private String last_name;
    private String nic;
    private String email;
    private Integer contact;
    private String address;
//    private MultipartFile nic_pic;
    private String nic_pic;
    private String username;
    private String password;
}

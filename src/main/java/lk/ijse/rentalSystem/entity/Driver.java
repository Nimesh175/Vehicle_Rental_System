package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {

    @Id
    @Column(nullable = false ,unique = true)
    private String driver_id;
    private String first_name;
    private String last_name;
    @Column(unique = true)
    private String nic;
    private String email;
    private Integer contact;
    private String address;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String licence_pic;
    private boolean available_status;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "driver_id")
    private List<Schedule> list;

}

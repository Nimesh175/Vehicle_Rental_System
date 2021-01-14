package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String full_name;
    @Column(unique = true ,nullable = false)
    private String nic;
    @Column(unique = true ,nullable = false)
    private String email;
    @Column(unique = true ,nullable = false)
    private Integer contact;

    @Column(unique = true ,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
}

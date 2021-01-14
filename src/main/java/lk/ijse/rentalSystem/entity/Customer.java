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
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) -->  private Integer customer_id;
    @Column(nullable = false ,unique = true)
    private String customer_id;
    private String first_name;
    private String last_name;
    @Column(unique = true)
    private String nic;
    private String email;
    private Integer contact;
    private String address;
//    @Lob
//    @Column(columnDefinition = "MEDIUMBLOB")
//    private byte[] nic_pic;
    private String nic_pic;
    @Column(nullable = false ,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;


    @OneToMany(mappedBy = "customer_id")
    private List<Orders> list;

    public Customer(String customer_id, String first_name, String last_name, String nic, String email, Integer contact, String address, String nic_pic, String username, String password) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nic = nic;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.nic_pic = nic_pic;
        this.username = username;
        this.password = password;
    }
}

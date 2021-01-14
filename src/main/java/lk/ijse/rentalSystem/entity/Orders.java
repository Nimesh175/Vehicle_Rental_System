package lk.ijse.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    private String order_id;
    private String status;
    private java.sql.Timestamp order_date;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name = "customer_id")
    private Customer customer_id;

    @OneToMany(mappedBy = "order_id")
    private List<OrderDetails> list;

    public Orders(String order_id, String status, Timestamp order_date, Customer customer_id) {
        this.order_id = order_id;
        this.status = status;
        this.order_date = order_date;
        this.customer_id = customer_id;
    }
}

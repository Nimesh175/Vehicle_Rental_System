package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.OrdersDTO;
import lk.ijse.rentalSystem.entity.Customer;
import lk.ijse.rentalSystem.entity.Orders;
import lk.ijse.rentalSystem.repo.CustomerRepository;
import lk.ijse.rentalSystem.repo.OrdersRepository;
import lk.ijse.rentalSystem.service.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customer_repo;


    @Override
    public void saveOrder(OrdersDTO dto) {
        if (! repo.existsById(dto.getOrder_id()) ) {

            updateAndSave(dto,dto.getCustomer_id());

        }else{
            throw new RuntimeException("This Order ID is already Exist !");
        }
    }

    @Override
    public void updateOrder(OrdersDTO dto) {
        if ( repo.existsById(dto.getOrder_id() )) {

            updateAndSave(dto,dto.getCustomer_id());

        }else{
            throw new RuntimeException("This Order ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteOrder(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Order ID is Does'nt Exist !");
        }
    }

    @Override
    public OrdersDTO getOrder(String id) {
       if (repo.existsById(id)) {
           Orders orders = repo.getOne(id);
          return new OrdersDTO(orders.getOrder_id(),
                  orders.getStatus()+"",
                  orders.getOrder_date()+"",
                  orders.getCustomer_id().getCustomer_id());

        }else{
            throw new RuntimeException("This Order ID is'nt Exist !");
        }
    }

    @Override
    public List<OrdersDTO> getAllOrder() {
        List<Orders> all = repo.findAll();

        List<OrdersDTO> list =new ArrayList<>();
        for (Orders ss: all ) {
            list.add( new OrdersDTO(ss.getOrder_id(),
                    ss.getStatus()+"",
                    ss.getOrder_date()+"",
                    ss.getCustomer_id().getCustomer_id()));
        }
        return list;
    }


    private void updateAndSave(OrdersDTO dto, String id) {
        if (customer_repo.existsById(dto.getCustomer_id())) {
            Customer one = customer_repo.getOne(dto.getCustomer_id());
            Orders order = new Orders(
                    dto.getOrder_id(),
                    dto.getStatus(),
                    Timestamp.valueOf(dto.getOrder_date()),
                    one);

            repo.save(order);
        } else {
            throw new RuntimeException("This Customer ID isn't Exist !");

        }

    }
}

package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.OrderDetailsDTO;
import lk.ijse.rentalSystem.entity.*;
import lk.ijse.rentalSystem.repo.OrderDetailsRepository;
import lk.ijse.rentalSystem.repo.OrdersRepository;
import lk.ijse.rentalSystem.repo.ScheduleRepository;
import lk.ijse.rentalSystem.repo.VehicleRepository;
import lk.ijse.rentalSystem.service.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ScheduleRepository schedule_repo;

    @Autowired
    private VehicleRepository vehicle_repo;

    @Autowired
    private OrdersRepository order_repo;



    @Override
    public void saveOrderDetails(OrderDetailsDTO dto) {
        if (! repo.existsById(dto.getOrder_id()) ) {
            updateAndSave(dto);
        }else{
            throw new RuntimeException("This OrderDetails ID is already Exist !");
        }
    }

    @Override
    public void updateOrderDetails(OrderDetailsDTO dto) {
        if (! repo.existsById(dto.getOrder_id()) ) {
            updateAndSave(dto);
        }else{
            throw new RuntimeException("This OrderDetails ID is already Exist !");
        }
    }

    @Override
    public void deleteOrderDetails(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This OrderDetails ID is Does'nt Exist !");
        }
    }

    @Override
    public OrderDetailsDTO getOrderDetails(String id) {
        if (repo.existsById(id)) {

            OrderDetails orderDetails = repo.getOne(id);

            return new OrderDetailsDTO(
                    orderDetails.getOv_id(),
                    orderDetails.getType_of_rate(),
                    orderDetails.getDay_month_count(),
                    orderDetails.getCus_bank_slip(),
                    orderDetails.getMeter_on(),
                    orderDetails.getMeter_off(),
                    orderDetails.isDriver_request(),
                    orderDetails.getOrder_id().getOrder_id(),
                    orderDetails.getVehicle_id().getVehicle_id(),
                    orderDetails.getOs_id().getSchedule_id()
            );

        }else{
            throw new RuntimeException("This OrderDetails ID is'nt Exist !");
        }
    }

    @Override
    public List<OrderDetailsDTO> getAllOrderDetails() {
        List<OrderDetails> all = repo.findAll();

        List<OrderDetailsDTO> list =new ArrayList<>();
        for (OrderDetails orderDetails: all ) {
            list.add( new OrderDetailsDTO(
                    orderDetails.getOv_id(),
                    orderDetails.getType_of_rate(),
                    orderDetails.getDay_month_count(),
                    orderDetails.getCus_bank_slip(),
                    orderDetails.getMeter_on(),
                    orderDetails.getMeter_off(),
                    orderDetails.isDriver_request(),
                    orderDetails.getOrder_id().getOrder_id(),
                    orderDetails.getVehicle_id().getVehicle_id(),
                    orderDetails.getOs_id().getSchedule_id()
            ));
        }
        return list;
    }

    private void updateAndSave(OrderDetailsDTO dto) {
        if (schedule_repo.existsById(dto.getOs_id())
             && vehicle_repo.existsById(dto.getVehicle_id())
                && order_repo.existsById(dto.getOrder_id())  ) {


            Schedule schedule = schedule_repo.getOne(dto.getOs_id());
            Vehicle vehicle = vehicle_repo.getOne(dto.getVehicle_id());
            Orders orders = order_repo.getOne(dto.getOrder_id());


           OrderDetails orderDetails =new OrderDetails(
                   dto.getOv_id(),
                   dto.getType_of_rate(),
                   dto.getDay_month_count(),
                   dto.getCus_bank_slip(),
                   dto.getMeter_on(),
                   dto.getMeter_off(),
                   dto.isDriver_request(),
                   orders,
                   vehicle,
                   schedule
           );

            repo.save(orderDetails);

        } else {
            throw new RuntimeException("This Driver ID | Vehicle ID | Schedule ID aren't Exist !");

        }
    }


}

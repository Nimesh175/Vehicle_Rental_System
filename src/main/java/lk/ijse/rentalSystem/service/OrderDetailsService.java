package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.OrderDetailsDTO;

import java.util.List;

public interface OrderDetailsService {
    public void saveOrderDetails(OrderDetailsDTO dto);
    public void updateOrderDetails(OrderDetailsDTO dto);
    public void deleteOrderDetails(String id);
    public OrderDetailsDTO getOrderDetails(String id);
    public List<OrderDetailsDTO> getAllOrderDetails();
}

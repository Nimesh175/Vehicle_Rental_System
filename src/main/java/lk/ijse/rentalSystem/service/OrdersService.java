package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.OrdersDTO;

import java.util.List;

public interface OrdersService {
    public void saveOrder(OrdersDTO dto);
    public void updateOrder(OrdersDTO dto);
    public void deleteOrder(String id);
    public OrdersDTO getOrder(String id);
    public List<OrdersDTO> getAllOrder();
}

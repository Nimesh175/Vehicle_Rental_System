package lk.ijse.rentalSystem.service;


import lk.ijse.rentalSystem.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO dto);
    public void updateCustomer(CustomerDTO dto);
    public void deleteCustomer(String id);
    public CustomerDTO getCustomer(String id);
    public List<CustomerDTO> getAllCustomers();
    public CustomerDTO findCustomerByUsername(String username);
}

package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.CustomerDTO;
import lk.ijse.rentalSystem.entity.Customer;
import lk.ijse.rentalSystem.repo.CustomerRepository;
import lk.ijse.rentalSystem.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (! repo.existsById(dto.getCustomer_id())) {
//
//            String nic_image = null;
//            try {
//                //
//                nic_image = Base64.getEncoder().encodeToString(dto.getNic_pic().getBytes());
//
//                Customer customer = new Customer(dto.getCustomer_id(), dto.getFirst_name(), dto.getLast_name(), dto.getNic(), dto.getEmail()
//                        , dto.getContact(), dto.getAddress(), nic_image, dto.getUsername(), dto.getPassword());
//
//                repo.save(customer);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            repo.save(modelMapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("This Customer ID is already Exist !");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if ( repo.existsById(dto.getCustomer_id())) {
            repo.save(modelMapper.map(dto, Customer.class));
        }else{
            throw new RuntimeException("This Customer ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Customer ID is Does'nt Exist !");
        }
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        if (repo.existsById(id)) {
            Customer customer = repo.getOne(id);
            return modelMapper.map(customer,CustomerDTO.class);
        }else{
            throw new RuntimeException("This Customer ID is Does'nt Exist !");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll();
        return modelMapper.map(all,new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO findCustomerByUsername(String username) {
        if (repo.findCustomersByUsername(username)!=null) {
            Customer customer = repo.findCustomersByUsername(username);
            return modelMapper.map(customer, CustomerDTO.class);
        }else{
            throw new RuntimeException("This Customer username is Does'nt Exist !");
        }
    }
}

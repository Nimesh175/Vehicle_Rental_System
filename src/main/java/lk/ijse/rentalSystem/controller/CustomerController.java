package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.CustomerDTO;
import lk.ijse.rentalSystem.service.CustomerService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto){
        System.out.println(dto.toString());
        service.saveCustomer(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto){
        service.updateCustomer(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam("id") String id){
        service.deleteCustomer(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") String id){
        CustomerDTO customer = service.getCustomer(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",customer),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllCustomer(){
        List<CustomerDTO> allCustomers = service.getAllCustomers();
        return new ResponseEntity(new StandardRespond(200,"Perfect",allCustomers),HttpStatus.OK);
    }

    @GetMapping(path = "/usn/{id}")
    public ResponseEntity findCustomerByUsername(@PathVariable("id") String username){
        CustomerDTO dto = service.findCustomerByUsername(username);
        return new ResponseEntity(new StandardRespond(200,"Good",dto),HttpStatus.OK);
    }
}

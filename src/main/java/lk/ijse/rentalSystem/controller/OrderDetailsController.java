package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.OrderDetailsDTO;
import lk.ijse.rentalSystem.service.OrderDetailsService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orderdetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveOrderDetails(@RequestBody OrderDetailsDTO dto){
        service.saveOrderDetails(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateOrderDetails(@RequestBody OrderDetailsDTO dto){
        service.updateOrderDetails(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteOrderDetails(@RequestParam("id") String id){
        service.deleteOrderDetails(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getOrderDetails(@PathVariable("id") String id){
        OrderDetailsDTO orderDetailsDTO = service.getOrderDetails(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",orderDetailsDTO),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllOrderDetails(){
        List<OrderDetailsDTO> all = service.getAllOrderDetails();
        return new ResponseEntity(new StandardRespond(200,"Perfect",all),HttpStatus.OK);
    }
}

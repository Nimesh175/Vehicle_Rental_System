package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.OrdersDTO;
import lk.ijse.rentalSystem.service.OrdersService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class MainOrderController {

    @Autowired
    private OrdersService service;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveOrder(@RequestBody OrdersDTO dto){
        service.saveOrder(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody OrdersDTO dto){
        service.updateOrder(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteOrder(@RequestParam("id") String id){
        service.deleteOrder(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getOrder(@PathVariable("id") String id){
        OrdersDTO order = service.getOrder(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",order),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllOrder(){
        List<OrdersDTO> allOrder = service.getAllOrder();
        return new ResponseEntity(new StandardRespond(200,"Perfect",allOrder),HttpStatus.OK);
    }
}

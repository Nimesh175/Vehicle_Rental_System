package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.PaymentDTO;
import lk.ijse.rentalSystem.service.PaymentService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/vi/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity savePayment(@RequestBody PaymentDTO dto){
        service.savePayment(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updatePayment(@RequestBody PaymentDTO dto){
        service.updatePayment(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deletePayment(@RequestParam("id") String id){
        service.deletePayment(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getPayment(@PathVariable("id") String id){
        PaymentDTO paymentDTO = service.getPayment(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",paymentDTO),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllPayment(){
        List<PaymentDTO> all = service.getAllPayment();
        return new ResponseEntity(new StandardRespond(200,"Perfect",all),HttpStatus.OK);
    }
}

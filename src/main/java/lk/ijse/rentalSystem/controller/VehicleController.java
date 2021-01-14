package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.VehicleDTO;
import lk.ijse.rentalSystem.service.VehicleService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService service;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveVehicle(@RequestBody VehicleDTO dto){
        service.saveVehicle(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO dto){
        service.updateVehicle(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicle(@RequestParam("id") String id){
        service.deleteVehicle(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getVehicle(@PathVariable("id") String id){
        VehicleDTO vehicleDTO = service.getVehicle(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",vehicleDTO),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllVehicle(){
        List<VehicleDTO> allVehicle = service.getAllVehicle();
        return new ResponseEntity(new StandardRespond(200,"Perfect",allVehicle),HttpStatus.OK);
    }
}

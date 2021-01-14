package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.VehicleCategoryDTO;
import lk.ijse.rentalSystem.service.VehicleCategoryService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/vcategory")
public class VehicleCategoryController {

    @Autowired
    private VehicleCategoryService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveVehicleCategory(@RequestBody VehicleCategoryDTO dto){
        service.saveVehicleCategory(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateVehicleCategory(@RequestBody VehicleCategoryDTO dto){
        service.updateVehicleCategory(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicleCategory(@RequestParam("id") String id){
        service.deleteVehicleCategory(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getVehicleCategory(@PathVariable("id") String id){
        VehicleCategoryDTO driver = service.getVehicleCategory(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",driver),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllVehicleCategory(){
        List<VehicleCategoryDTO> allDrivers = service.getAllVehicleCategory();
        return new ResponseEntity(new StandardRespond(200,"Perfect",allDrivers),HttpStatus.OK);
    }
}

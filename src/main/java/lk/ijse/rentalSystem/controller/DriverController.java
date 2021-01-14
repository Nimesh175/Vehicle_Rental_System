package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.DriverDTO;
import lk.ijse.rentalSystem.service.DriverService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto) {
        service.saveDriver(dto);
        return new ResponseEntity(new StandardRespond(200, "Saved", null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody DriverDTO dto) {
        service.updateDriver(dto);
        return new ResponseEntity(new StandardRespond(200, "Updated", null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteDriver(@RequestParam("id") String id) {
        service.deleteDriver(id);
        return new ResponseEntity(new StandardRespond(200, "Deleted", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getDriver(@PathVariable("id") String id) {
        DriverDTO driver = service.getDriver(id);
        return new ResponseEntity(new StandardRespond(200, "Perfect", driver), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllDrivers() {
        List<DriverDTO> allDrivers = service.getAllDrivers();
        return new ResponseEntity(new StandardRespond(200, "Perfect", allDrivers), HttpStatus.OK);
    }


    @GetMapping(path = "/usn/{id}")
    public ResponseEntity findDriverByUsername(@PathVariable("id") String username) {
        DriverDTO dto = service.findDriverByUsername(username);
        return new ResponseEntity(new StandardRespond(200, "Good", dto), HttpStatus.OK);
    }
}

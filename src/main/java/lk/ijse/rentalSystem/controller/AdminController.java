package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.AdminDTO;
import lk.ijse.rentalSystem.service.AdminService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveAdmin(@RequestBody AdminDTO dto){
        service.saveAdmin(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateAdmin(@RequestBody AdminDTO dto){
        service.updateAdmin(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteAdmin(@RequestParam("id") int id){
        service.deleteAdmin(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getAdmin(@PathVariable("id") int id){
        AdminDTO admin = service.getAdmin(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",admin),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllAdmins(){
        List<AdminDTO> allAdmins = service.getAllAdmins();
        return new ResponseEntity(new StandardRespond(200,"Perfect",allAdmins),HttpStatus.OK);
    }

    @GetMapping(path = "/usn/{id}")
    public ResponseEntity getAdminByUserName(@PathVariable("id") String username){
        AdminDTO admin = service.findAdminByUsername(username);
        return new ResponseEntity(new StandardRespond(200,"Good",admin),HttpStatus.OK);
    }
}

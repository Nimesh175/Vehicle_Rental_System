package lk.ijse.rentalSystem.controller;

import lk.ijse.rentalSystem.dto.ScheduleDTO;
import lk.ijse.rentalSystem.service.ScheduleService;
import lk.ijse.rentalSystem.util.StandardRespond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/schedule")
public class OrderScheduleController {

    @Autowired
    private ScheduleService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveSchedule(@RequestBody ScheduleDTO dto){
        service.saveSchedule(dto);
        return new ResponseEntity(new StandardRespond(200,"Saved",null), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateDSchedule(@RequestBody ScheduleDTO dto){
        service.updateSchedule(dto);
        return new ResponseEntity(new StandardRespond(200,"Updated",null),HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity v(@RequestParam("id") String id){
        service.deleteSchedule(id);
        return new ResponseEntity(new StandardRespond(200,"Deleted",null),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getSchedule(@PathVariable("id") String id){
        ScheduleDTO scheduleDTO = service.getSchedule(id);
        return new ResponseEntity(new StandardRespond(200,"Perfect",scheduleDTO),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getAllSchedule(){
        List<ScheduleDTO>  allSchedule= service.getAllSchedule();
        return new ResponseEntity(new StandardRespond(200,"Perfect",allSchedule),HttpStatus.OK);
    }
}

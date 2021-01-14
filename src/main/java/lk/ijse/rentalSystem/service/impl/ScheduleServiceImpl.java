package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.ScheduleDTO;
import lk.ijse.rentalSystem.entity.Driver;
import lk.ijse.rentalSystem.entity.Schedule;
import lk.ijse.rentalSystem.repo.DriverRepository;
import lk.ijse.rentalSystem.repo.ScheduleRepository;
import lk.ijse.rentalSystem.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DriverRepository driver_repo;



    @Override
    public void saveSchedule(ScheduleDTO dto) {
        if (! repo.existsById(dto.getSchedule_id() ) ) {

            updateAndSave(dto);

        }else{
            throw new RuntimeException("This Schedule ID is already Exist !");
        }
    }

    @Override
    public void updateSchedule(ScheduleDTO dto) {
        if ( repo.existsById(dto.getSchedule_id())) {

            updateAndSave(dto);

        }else{
            throw new RuntimeException("This Schedule ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteSchedule(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Schedule ID is Does'nt Exist !");
        }
    }

    @Override
    public ScheduleDTO getSchedule(String id) {
        if (repo.existsById(id)) {

            Schedule schedule = repo.getOne(id);
//            return modelMapper.map(schedule, ScheduleDTO.class);

           return new ScheduleDTO(schedule.getSchedule_id(),
                   schedule.getStart_date()+"",
                   schedule.getEnd_date()+"",
                   schedule.getDriver_id().getDriver_id());

        }else{
            throw new RuntimeException("This Schedule ID is'nt Exist !");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedule() {
        List<Schedule> all = repo.findAll();
//        return modelMapper.map(all,new TypeToken<List<ScheduleDTO>>(){}.getType());

        List<ScheduleDTO> list =new ArrayList<>();
        for (Schedule ss: all ) {
            list.add( new ScheduleDTO(ss.getSchedule_id(),
                    ss.getStart_date()+"",
                    ss.getEnd_date()+"",
                    ss.getDriver_id().getDriver_id()));
        }
        return list;
    }


    private void updateAndSave(ScheduleDTO dto) {
        if (driver_repo.existsById(dto.getDriver_id())) {
            Driver one = driver_repo.getOne(dto.getDriver_id());
            Schedule schedule = new Schedule(dto.getSchedule_id(),
                    Timestamp.valueOf(dto.getStart_date()),
                    Timestamp.valueOf(dto.getEnd_date()),
                    one);

            repo.save(schedule);
        } else {
            throw new RuntimeException("This Driver ID isn't Exist !");

        }
    }
}

package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    public void saveSchedule(ScheduleDTO dto);
    public void updateSchedule(ScheduleDTO dto);
    public void deleteSchedule(String id);
    public ScheduleDTO getSchedule(String id);
    public List<ScheduleDTO> getAllSchedule();
}

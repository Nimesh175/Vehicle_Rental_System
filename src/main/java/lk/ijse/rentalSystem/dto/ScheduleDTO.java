package lk.ijse.rentalSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScheduleDTO {
    private String schedule_id;
    private String start_date;
    private String end_date;
    private String driver_id;

}

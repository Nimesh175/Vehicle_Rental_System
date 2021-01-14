package lk.ijse.rentalSystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardRespond {
    private int code;
    private String message;
    private Object data;
}

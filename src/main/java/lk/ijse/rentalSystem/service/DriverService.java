package lk.ijse.rentalSystem.service;


import lk.ijse.rentalSystem.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    public void saveDriver(DriverDTO dto);
    public void updateDriver(DriverDTO dto);
    public void deleteDriver(String id);
    public DriverDTO getDriver(String id);
    public List<DriverDTO> getAllDrivers();
    public DriverDTO findDriverByUsername(String username);
}

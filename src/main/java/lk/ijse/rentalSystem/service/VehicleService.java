package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    public void saveVehicle(VehicleDTO dto);
    public void updateVehicle(VehicleDTO dto);
    public void deleteVehicle(String id);
    public VehicleDTO getVehicle(String id);
    public List<VehicleDTO> getAllVehicle();
}

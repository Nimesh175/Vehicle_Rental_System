package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.VehicleCategoryDTO;

import java.util.List;

public interface VehicleCategoryService {
    public void saveVehicleCategory(VehicleCategoryDTO dto);
    public void updateVehicleCategory(VehicleCategoryDTO dto);
    public void deleteVehicleCategory(String id);
    public VehicleCategoryDTO getVehicleCategory(String id);
    public List<VehicleCategoryDTO> getAllVehicleCategory();
}

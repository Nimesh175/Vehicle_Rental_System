package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.VehicleDTO;
import lk.ijse.rentalSystem.entity.Vehicle;
import lk.ijse.rentalSystem.entity.VehicleCategory;
import lk.ijse.rentalSystem.repo.VehicleCategoryRepository;
import lk.ijse.rentalSystem.repo.VehicleRepository;
import lk.ijse.rentalSystem.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository repo;

    @Autowired
    private VehicleCategoryRepository vehicle_repo;


    @Override
    public void saveVehicle(VehicleDTO dto) {
        if (! repo.existsById(dto.getVehicle_id() ) ) {
            updateAndSave(dto,dto.getCategory_id());
        }else{
            throw new RuntimeException("This Vehicle ID is already Exist !");
        }
    }

    @Override
    public void updateVehicle(VehicleDTO dto) {
        if ( repo.existsById(dto.getVehicle_id())) {
            updateAndSave(dto,dto.getCategory_id());
        }else{
            throw new RuntimeException("This Vehicle ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Vehicle ID is Does'nt Exist !");
        }
    }

    @Override
    public VehicleDTO getVehicle(String id) {
        if (repo.existsById(id)) {
            Vehicle vehicle = repo.getOne(id);
            return  getVehicleDtoInstance(vehicle);
        }else{
            throw new RuntimeException("This Vehicle ID is'nt Exist !");
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        List<Vehicle> all = repo.findAll();
        List<VehicleDTO> list =new ArrayList<>();

        for (Vehicle vehicle: all )
            list.add( getVehicleDtoInstance(vehicle));

        return list;
    }



    private void updateAndSave(VehicleDTO dto, String id) {
        if (vehicle_repo.existsById(dto.getCategory_id())) {
            VehicleCategory one = vehicle_repo.getOne(dto.getCategory_id());

            Vehicle vehicle = new Vehicle(
                    dto.getVehicle_id(),
                    dto.getRegister_number(),
                    dto.getColor(),
                    dto.getBrand(),
                    dto.getType(),
                    dto.getFuel_type(),
                    dto.getTransmission_type(),
                    dto.getPassenger_count(),
                    dto.getFree_km_daily(),
                    dto.getFree_km_monthly(),
                    dto.getDaily_rent(),
                    dto.getMonthly_rent(),
                    dto.getExtra_km_rent(),
                    dto.isAvailable_status(),
                    dto.isMaintain_status(),
                    dto.getStart_meter(),
                    dto.getLast_meter(),
                    dto.getFront_pic(),
                    dto.getBack_pic(),
                    dto.getSide_pic(),
                    dto.getInterior_pic(),
                    one
            );

            repo.save(vehicle);
        } else {
            throw new RuntimeException("This Vehicle_Category ID isn't Exist !");

        }
    }


    public VehicleDTO getVehicleDtoInstance(Vehicle vehicle){

        return new VehicleDTO(
                vehicle.getVehicle_id(),
                vehicle.getRegister_number(),
                vehicle.getColor(),
                vehicle.getBrand(),
                vehicle.getType(),
                vehicle.getFuel_type(),
                vehicle.getTransmission_type(),
                vehicle.getPassenger_count(),
                vehicle.getFree_km_daily(),
                vehicle.getFree_km_monthly(),
                vehicle.getDaily_rent(),
                vehicle.getMonthly_rent(),
                vehicle.getExtra_km_rent(),
                vehicle.isAvailable_status(),
                vehicle.isMaintain_status(),
                vehicle.getStart_meter(),
                vehicle.getLast_meter(),
                vehicle.getFront_pic(),
                vehicle.getBack_pic(),
                vehicle.getSide_pic(),
                vehicle.getInterior_pic(),
                vehicle.getCategory_id().getCategory_id()
        );
    }

}

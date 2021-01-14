package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.VehicleCategoryDTO;
import lk.ijse.rentalSystem.entity.VehicleCategory;
import lk.ijse.rentalSystem.repo.VehicleCategoryRepository;
import lk.ijse.rentalSystem.service.VehicleCategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleCategoryServiceImpl implements VehicleCategoryService {

    @Autowired
    private VehicleCategoryRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveVehicleCategory(VehicleCategoryDTO dto) {
        if (! repo.existsById(dto.getCategory_id())) {
            repo.save(modelMapper.map(dto, VehicleCategory.class));
        }else{
            throw new RuntimeException("This Vehicle Category ID is already Exist !");
        }
    }

    @Override
    public void updateVehicleCategory(VehicleCategoryDTO dto) {
        if ( repo.existsById(dto.getCategory_id())) {
            repo.save(modelMapper.map(dto, VehicleCategory.class));
        }else{
            throw new RuntimeException("This Vehicle Category ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteVehicleCategory(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Vehicle Category ID is Does'nt Exist !");
        }
    }

    @Override
    public VehicleCategoryDTO getVehicleCategory(String id) {
        if (repo.existsById(id)) {
            VehicleCategory vehicalCategory = repo.getOne(id);
            return modelMapper.map(vehicalCategory, VehicleCategoryDTO.class);
        }else{
            throw new RuntimeException("This Vehicle Category ID is Does'nt Exist !");
        }
    }

    @Override
    public List<VehicleCategoryDTO> getAllVehicleCategory() {
        List<VehicleCategory> all = repo.findAll();
        return modelMapper.map(all,new TypeToken<List<VehicleCategoryDTO>>(){}.getType());
    }

}

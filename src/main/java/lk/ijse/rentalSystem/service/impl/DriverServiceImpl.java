package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.DriverDTO;
import lk.ijse.rentalSystem.entity.Driver;
import lk.ijse.rentalSystem.repo.DriverRepository;
import lk.ijse.rentalSystem.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (! repo.existsById(dto.getDriver_id())) {
            repo.save(modelMapper.map(dto, Driver.class));
        }else{
            throw new RuntimeException("This Driver ID is already Exist !");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if ( repo.existsById(dto.getDriver_id())) {
            repo.save(modelMapper.map(dto, Driver.class));
        }else{
            throw new RuntimeException("This Driver ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Driver ID is Does'nt Exist !");
        }
    }

    @Override
    public DriverDTO getDriver(String id) {
        if (repo.existsById(id)) {
            Driver driver = repo.getOne(id);
            return modelMapper.map(driver, DriverDTO.class);
        }else{
            throw new RuntimeException("This Driver ID is Does'nt Exist !");
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = repo.findAll();
        return modelMapper.map(all,new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public DriverDTO findDriverByUsername(String username) {
        if (repo.findDriverByUsername(username)!=null) {
            Driver driver = repo.findDriverByUsername(username);
            return modelMapper.map(driver, DriverDTO.class);
        }else{
            throw new RuntimeException("This Driver username is Does'nt Exist !");
        }
    }
}

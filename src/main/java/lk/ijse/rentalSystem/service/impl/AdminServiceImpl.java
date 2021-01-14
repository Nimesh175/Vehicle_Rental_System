package lk.ijse.rentalSystem.service.impl;

import lk.ijse.rentalSystem.dto.AdminDTO;
import lk.ijse.rentalSystem.entity.Admin;
import lk.ijse.rentalSystem.repo.AdminRepository;
import lk.ijse.rentalSystem.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (! repo.existsById(dto.getId())) {
            repo.save(modelMapper.map(dto, Admin.class));
        }else{
            throw new RuntimeException("This Admin ID is already Exist !");
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if ( repo.existsById(dto.getId())) {
            repo.save(modelMapper.map(dto, Admin.class));
        }else{
            throw new RuntimeException("This Admin ID is Does'nt Exist !");
        }
    }

    @Override
    public void deleteAdmin(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }else{
            throw new RuntimeException("This Admin ID is Does'nt Exist !");
        }
    }

    @Override
    public AdminDTO getAdmin(Integer id) {
        if (repo.existsById(id)) {
            Admin admin = repo.getOne(id);
            return modelMapper.map(admin, AdminDTO.class);
        }else{
            throw new RuntimeException("This Admin ID is Does'nt Exist !");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> all = repo.findAll();
        return modelMapper.map(all,new TypeToken<List<AdminDTO>>(){}.getType());
    }

    @Override
    public AdminDTO findAdminByUsername(String username) {

        if (repo.findAdminByUsername(username)!=null) {
            Admin admin = repo.findAdminByUsername(username);
            return modelMapper.map(admin, AdminDTO.class);
        }else{
            throw new RuntimeException("This Admin username is Does'nt Exist !");
        }
    }
}

package lk.ijse.rentalSystem.service;

import lk.ijse.rentalSystem.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    public void saveAdmin(AdminDTO dto);
    public void updateAdmin(AdminDTO dto);
    public void deleteAdmin(Integer id);
    public AdminDTO getAdmin(Integer id);
    public List<AdminDTO> getAllAdmins();
    public AdminDTO findAdminByUsername(String username);
}

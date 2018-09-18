package com.xyz.portal.service;

import com.xyz.portal.domain.entity.Admin;
import com.xyz.portal.domain.dto.AdminDTO;
import com.xyz.portal.exception.AdminNotFoundException;
import com.xyz.portal.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final ModelMapper modelMapper;
    private final AdminRepository adminRepository;


    @Autowired
    public AdminService(ModelMapper modelMapper, AdminRepository adminRepository) {
        this.modelMapper = modelMapper;
        this.adminRepository = adminRepository;
    }



    public Admin getAdmin(long adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new AdminNotFoundException("given admin is not found"));
    }


    public Admin createAdmin(AdminDTO adminDTO) {
//        Admin admin = modelMapper.map(, Admin.class);

        Admin admin = new Admin();

        admin.setLoginId(adminDTO.getLoginId());
        admin.setEncryptedPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());

        return adminRepository.save(admin);
    }


}

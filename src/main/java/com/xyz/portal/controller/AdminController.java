package com.xyz.portal.controller;

import com.xyz.portal.domain.dto.AdminDTO;
import com.xyz.portal.domain.entity.Admin;
import com.xyz.portal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    /**
     *
     * @param adminId
     * @return
     */
    @GetMapping("/{adminId}")
    @Transactional
    public ResponseEntity<Admin> getAdmin(@PathVariable("adminId") long adminId) {
        Admin admin = adminService.getAdmin(adminId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(admin);
    }


    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@Validated @RequestBody AdminDTO adminDTO) {
        Admin admin = adminService.createAdmin(adminDTO);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(admin);
    }
}

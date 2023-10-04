package com.example.bookstagram.bookstagram.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstagram.bookstagram.Models.Admin;
import com.example.bookstagram.bookstagram.Repositories.AdminRepo;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public Admin validateAdminLogin(Admin admin) 
    {
        
        Optional<Admin> getAdmin = adminRepo.findByAdminemailAndAdminpassword(admin.getAdminemail(),admin.getAdminpassword());

        if(getAdmin.isPresent()) 
        {
            return getAdmin.get();
        }    
        else 
        {
            return null;
        }    
    }

    public boolean createAdmin(Admin admin)
    {
            if(adminRepo.findByAdminemail(admin.getAdminemail()).isPresent())
            {
                return false;
            }    
            else
            {
                adminRepo.save(admin);
                return true; 
            }    
    }

    public Admin getAdminDetails(Admin admin)
    {
        Optional<Admin> getAdmin = adminRepo.findById(admin.getId());

        return getAdmin.get();
    }

    public Admin updateAdminDetails(Admin newAdmin, int id) 
    {
		Admin updateAdmin = adminRepo.findById(id).get();
		
		if(updateAdmin == null)
		{
			return updateAdmin;
		}
		else
		{
			updateAdmin.setAdminname(updateAdmin.getAdminname());
			updateAdmin.setAdminemail(updateAdmin.getAdminemail());
			updateAdmin.setAdminpassword(updateAdmin.getAdminpassword());
		}
		
		return adminRepo.save(updateAdmin);
    }

    public void deleteAdminDetails(int id) 
    {
        adminRepo.deleteById(id);
    }
    
}

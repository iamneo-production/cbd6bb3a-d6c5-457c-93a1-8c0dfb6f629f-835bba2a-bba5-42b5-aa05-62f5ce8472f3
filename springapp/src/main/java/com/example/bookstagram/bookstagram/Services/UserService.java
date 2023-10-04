package com.example.bookstagram.bookstagram.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstagram.bookstagram.Models.User;
import com.example.bookstagram.bookstagram.Repositories.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public String validateUserLogin(User user)
    {
        Optional<User> getUser = userRepo.findByUseremailAndUserpassword(user.getUseremail(), user.getUserpassword());

        if(getUser.isPresent()) return "Valid";
        else return "Invalid";
    }

    public boolean createUser(User user) 
    {
            if(userRepo.findByUseremail(user.getUseremail()).isPresent())
            {
                return false;
            }    
            else
            {
                userRepo.save(user);
                return true; 
            }    
    }

    public User getUserDetails(int id)
    {
        Optional<User> getUser = userRepo.findById(id);

        return getUser.get();
    }

    public String updateUserDetails(User newUser, int id) 
    {
		User updateUser = userRepo.findById(id).get();
		
		if(updateUser == null)
		{
            return "Unsuccessful";
		}
		else
		{
			updateUser.setUsername(newUser.getUsername());
			updateUser.setUseremail(newUser.getUseremail());
			updateUser.setUserpassword(newUser.getUserpassword());

            userRepo.save(updateUser);
            return "Successful";
		}
		
    }

    public void deleteUserDetails(int id) 
    {
        userRepo.deleteById(id);
    }
}

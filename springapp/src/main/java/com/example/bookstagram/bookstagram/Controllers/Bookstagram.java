package com.example.bookstagram.bookstagram.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstagram.bookstagram.Models.Admin;
import com.example.bookstagram.bookstagram.Models.Book;
import com.example.bookstagram.bookstagram.Models.User;
import com.example.bookstagram.bookstagram.Services.AdminService;
import com.example.bookstagram.bookstagram.Services.BookService;
import com.example.bookstagram.bookstagram.Services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/bookstagram")
public class Bookstagram {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BookService bookService;

    //User_Login

    @PostMapping(value = "/userLogin", consumes = "application/json", produces = "application/json")
    public String validateUserLogin(@RequestBody User user)
    {
        return userService.validateUserLogin(user);
    }

    //Admin_Login

    @PostMapping(value = "/adminLogin", consumes = "application/json", produces = "application/json")
    public Admin validateAdminLogin(@RequestBody Admin admin)
    {
        return adminService.validateAdminLogin(admin);
    }

    //User_CRUD

    @PostMapping(value = "/createUser", produces = "application/json")
    public boolean createUser(@RequestBody User user){
        System.out.println(user);
       return userService.createUser(user);
    }

    @GetMapping(value = "/getUser/{id}")
    public User getUserDetails(@PathVariable("id") int id)
    {
        return userService.getUserDetails(id);
    }

    @PutMapping(value = "/updateUser/{id}", produces = "application/json")
    public String updateUserDetails(final @RequestBody User newUser, @PathVariable("id") int id)
    {
        return userService.updateUserDetails(newUser, id);
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUserDetails(@PathVariable("id") int id)
    {
        userService.deleteUserDetails(id);
    }

    //Admin_CRUD

     @PostMapping(value = "/createAdmin", produces = "application/json")
    public boolean createAdmin(@RequestBody Admin admin)
    {
        System.out.println(admin);
       return adminService.createAdmin(admin);
    }

    @GetMapping(value = "/getAdmin", consumes = "application/json", produces = "application/json")
    public Admin getAdminDetails(@RequestBody Admin admin)
    {
        return adminService.getAdminDetails(admin);
    }

    @PutMapping(value = "/updateAdmin/{id}", produces = "application/json")
    public void updateAdminDetails(final @RequestBody Admin newAdmin, @PathVariable("id") int id)
    {
        adminService.updateAdminDetails(newAdmin, id);
    }

    @DeleteMapping(value = "/deleteAdmin/{id}", produces = "application/json")
    public void deleteAdminDetails(@PathVariable("id") int id)
    {
        adminService.deleteAdminDetails(id);
    }

    //Books_CRUD

    @PostMapping(value = "/createBook", produces = "application/json")
    public String createBook(@RequestBody Book book)
    {
       return bookService.createBook(book);
    }

    // @GetMapping(value = "/getUser/{id}")
    // public User getUserDetails(@PathVariable("id") int id)
    // {
    //     return userService.getUserDetails(id);
    // }

    // @PutMapping(value = "/updateUser/{id}", produces = "application/json")
    // public String updateUserDetails(final @RequestBody User newUser, @PathVariable("id") int id)
    // {
    //     return userService.updateUserDetails(newUser, id);
    // }

    // @DeleteMapping(value = "/deleteUser/{id}")
    // public void deleteUserDetails(@PathVariable("id") int id)
    // {
    //     userService.deleteUserDetails(id);
    // }

}

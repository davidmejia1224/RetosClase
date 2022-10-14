package com.doctors.controller;

import com.doctors.model.UserAdministratorModel;
import com.doctors.service.UserAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserAdministratorController {

    @Autowired
    private UserAdministratorService userAdministratorService;

    @GetMapping("/all")
    public List<UserAdministratorModel> getAllUserAdministrators() {
        return (List<UserAdministratorModel>) userAdministratorService.getAllUserAdministrators();
    }

    //@GetMapping("/all")
    //public List<UserAdministratorModel> getAllUserAdministrators2() {
    //    return (List<UserAdministratorModel>) userAdministratorService.getAllUserAdministrators();
    //}

    @GetMapping("{id}")
    public Optional<UserAdministratorModel> getUserAdministrator(@PathVariable Integer id) {
        return userAdministratorService.getUserAdministrator(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UserAdministratorModel saveUserAdministrator(@RequestBody UserAdministratorModel userAdministratorModel) {
        return userAdministratorService.saveUserAdministrator(userAdministratorModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUserAdministratorModel(@PathVariable Integer id) {
        userAdministratorService.deleteUserAdministrator(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UserAdministratorModel updateUserAdministrator(@RequestBody UserAdministratorModel userAdministratorModel) {
        return userAdministratorService.updateUserAdministrator(userAdministratorModel);
    }
}

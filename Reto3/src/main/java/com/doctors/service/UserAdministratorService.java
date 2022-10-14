package com.doctors.service;

import com.doctors.model.UserAdministratorModel;
import com.doctors.repository.UserAdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserAdministratorService {

    @Autowired
    private UserAdministratorRepository userAdministratorRepository;

    public List<UserAdministratorModel> getAllUserAdministrators() {
        return (List<UserAdministratorModel>) userAdministratorRepository.getAllUserAdministrators();
    }

    public Optional<UserAdministratorModel> getUserAdministrator(Integer id) {
        return userAdministratorRepository.getUserAdministrator(id);
    }

    public UserAdministratorModel saveUserAdministrator(UserAdministratorModel userAdministratorModel) {
        return userAdministratorRepository.saveUserAdministrator(userAdministratorModel);
    }

    public boolean deleteUserAdministrator(Integer id) {
        userAdministratorRepository.deleteUserAdministrator(id);
        return true;
    }

    public UserAdministratorModel updateUserAdministrator(UserAdministratorModel userAdministratorModel) {
        return userAdministratorRepository.updateUserAdministrator(userAdministratorModel);
    }
}

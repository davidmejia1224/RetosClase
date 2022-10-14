package com.doctors.repository;

import com.doctors.model.SpecialtyModel;
import com.doctors.model.UserAdministratorModel;
import com.doctors.repository.crudrepository.UserAdministratorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserAdministratorRepository {

    @Autowired
    private UserAdministratorCrudRepository userAdministratorCrudRepository;

    public List<UserAdministratorModel> getAllUserAdministrators() {
        return (List<UserAdministratorModel>) userAdministratorCrudRepository.findAll();
    }

    public Optional<UserAdministratorModel> getUserAdministrator(Integer id) {
        return userAdministratorCrudRepository.findById(id);
    }

    public UserAdministratorModel saveUserAdministrator(UserAdministratorModel userAdministratorModel) {
        return userAdministratorCrudRepository.save(userAdministratorModel);
    }

    public boolean deleteUserAdministrator(Integer id) {
        try {
            userAdministratorCrudRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public UserAdministratorModel updateUserAdministrator(UserAdministratorModel userAdministratorModel) {
        if (userAdministratorModel.getId() != null) {
            Optional<UserAdministratorModel> admin = userAdministratorCrudRepository.findById(userAdministratorModel.getId());
            if (!admin.isEmpty()) {
                if (userAdministratorModel.getName() != null) {
                    admin.get().setName(userAdministratorModel.getName());
                }
                if (userAdministratorModel.getEmail() != null) {
                    admin.get().setEmail(userAdministratorModel.getEmail());
                }
                if (userAdministratorModel.getPassword() != null) {
                    admin.get().setPassword(userAdministratorModel.getPassword());
                }
                userAdministratorCrudRepository.save(admin.get());
                return admin.get();
            } else {
                return userAdministratorModel;
            }
        } else {
            return userAdministratorModel;
        }
    }
}

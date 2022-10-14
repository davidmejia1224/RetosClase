package com.doctors.repository.crudrepository;

import com.doctors.model.UserAdministratorModel;
import org.springframework.data.repository.CrudRepository;

public interface UserAdministratorCrudRepository extends CrudRepository<UserAdministratorModel, Integer> {
}

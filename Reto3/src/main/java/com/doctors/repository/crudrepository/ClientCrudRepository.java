package com.doctors.repository.crudrepository;

import com.doctors.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel, Integer> {

}

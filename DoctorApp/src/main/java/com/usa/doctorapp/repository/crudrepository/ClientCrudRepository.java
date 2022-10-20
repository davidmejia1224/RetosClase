package com.usa.doctorapp.repository.crudrepository;

import com.usa.doctorapp.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer> {
}

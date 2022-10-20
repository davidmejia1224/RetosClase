package com.usa.doctorapp.repository.crudrepository;

import com.usa.doctorapp.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}

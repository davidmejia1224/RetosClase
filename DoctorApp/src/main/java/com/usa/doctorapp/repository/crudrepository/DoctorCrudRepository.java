package com.usa.doctorapp.repository.crudrepository;

import com.usa.doctorapp.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository extends CrudRepository<Doctor, Integer> {
}

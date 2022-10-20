package com.usa.doctorapp.repository.crudrepository;

import com.usa.doctorapp.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}

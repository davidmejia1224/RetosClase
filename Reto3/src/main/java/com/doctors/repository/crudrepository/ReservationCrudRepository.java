package com.doctors.repository.crudrepository;

import com.doctors.model.ReservationModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {


   public List<ReservationModel> findAllByStatus(String status);
   public List<ReservationModel> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne, Date dateTwo);
   @Query("SELECT c.client, COUNT(c.client) FROM ReservationModel AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")

   public List<Object[]> countTotalReservationsByClient();


}

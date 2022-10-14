package com.doctors.service;

import com.doctors.model.DTOs.CountClient;
import com.doctors.model.DTOs.CountStatus;
import com.doctors.model.ReservationModel;
import com.doctors.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel) {
        return reservationRepository.saveReservation(reservationModel);
    }

    public boolean deleteReservation(Integer idReservation) {
        reservationRepository.deleteReservation(idReservation);
        return true;
    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        return reservationRepository.updateReservation(reservationModel);
    }

    //Reto5

    public CountStatus getReservationsStatus(){
        List<ReservationModel> completed = reservationRepository.getReservationsByStatus("completed");
        List<ReservationModel> canceled = reservationRepository.getReservationsByStatus("canceled");

        return new CountStatus((long) completed.size(), (long) canceled.size());
    }

    public List<ReservationModel> getReservationsBetweenDates(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);

        }catch (ParseException error){
            error.printStackTrace();
        }
        if (a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a, b);
        }else {
            return new ArrayList<>();
        }

    }

    public List<CountClient> getClientTop(){
        return reservationRepository.getClientTop();
    }




}

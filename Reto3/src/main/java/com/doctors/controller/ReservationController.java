package com.doctors.controller;

import com.doctors.model.DTOs.CountClient;
import com.doctors.model.DTOs.CountStatus;
import com.doctors.model.ReservationModel;
import com.doctors.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("all")
    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationService.getAllReservations();
    }

    //@GetMapping("/all")
    //public List<ReservationModel> getAllReservations2() {
    //    return (List<ReservationModel>) reservationService.getAllReservations();
    //}

    @GetMapping("{idReservation}")
    public Optional<ReservationModel> getReservation(@PathVariable Integer idReservation) {
        return reservationService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel) {
        return reservationService.saveReservation(reservationModel);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable Integer idReservation) {
        reservationService.deleteReservation(idReservation);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel updateReservation(@RequestBody ReservationModel reservationModel) {
        return reservationService.updateReservation(reservationModel);
    }

    //Reto5
    @GetMapping("/report-status")
    public CountStatus getReportStatus(){
        return reservationService.getReservationsStatus();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<ReservationModel> getReportReservationsBetweenDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsBetweenDates(dateOne, dateTwo);
    }
    @GetMapping("/report-clients")
    public List<CountClient> getClientsTop(){
        return reservationService.getClientTop();
    }


    




}

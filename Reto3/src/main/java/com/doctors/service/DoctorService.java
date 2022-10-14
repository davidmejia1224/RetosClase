package com.doctors.service;

import com.doctors.model.DoctorModel;
import com.doctors.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors() {
        return (List<DoctorModel>) doctorRepository.getAllDoctors();
    }

    public Optional<DoctorModel> getDoctor(Integer id) {
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel) {
        return doctorRepository.saveDoctor(doctorModel);
    }

    public boolean deleteDoctor(Integer id) {
        doctorRepository.deleteDoctor(id);
        return true;
    }

    public DoctorModel updateDoctors(DoctorModel doctorModel) {
        return doctorRepository.updateDoctor(doctorModel);
    }
}


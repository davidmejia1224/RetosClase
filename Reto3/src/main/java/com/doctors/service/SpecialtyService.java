package com.doctors.service;

import com.doctors.model.SpecialtyModel;
import com.doctors.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyModel> getAllSpecialty() {
        return specialtyRepository.getAllSpecialty();
    }

    public Optional<SpecialtyModel> getSpecialty(Integer id) {
        return specialtyRepository.getSpecialty(id);
    }

    public SpecialtyModel saveSpecialty(SpecialtyModel specialtyModel) {
        return specialtyRepository.saveSpecialty(specialtyModel);
    }

    public boolean deleteSpecialty(Integer id) {
        return specialtyRepository.deleteSpecialty(id);
    }

    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel) {
        return specialtyRepository.updateSpecialty(specialtyModel);
    }
}

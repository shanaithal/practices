package com.dreamspace.explorecali.services;

import com.dreamspace.explorecali.domain.TourPackage;
import com.dreamspace.explorecali.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    public TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {

        if (!this.tourPackageRepository.existsById(code)) {

            return tourPackageRepository.save(new TourPackage(code, name));
        }

        return tourPackageRepository.findById(code).get();
    }

    public Iterable<TourPackage> lookup() {

        return tourPackageRepository.findAll();
    }

    public long total() {

        return tourPackageRepository.count();
    }
}

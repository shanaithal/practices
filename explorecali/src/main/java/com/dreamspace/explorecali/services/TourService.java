package com.dreamspace.explorecali.services;

import com.dreamspace.explorecali.domain.Tour;
import com.dreamspace.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {

    TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String code, String name) {

        return null;
    }

    public Iterable<Tour> lookup() {

        return tourRepository.findAll();
    }

    public long total() {

        return tourRepository.count();
    }

}

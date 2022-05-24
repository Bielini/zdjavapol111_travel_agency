package pl.sda.zdjavapol111_travel_agency.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.zdjavapol111_travel_agency.model.Country;
import pl.sda.zdjavapol111_travel_agency.repository.CountryRepository;
import pl.sda.zdjavapol111_travel_agency.service.CountryService;

public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country getById(Integer id) {
        return countryRepository.getById(id);
    }

    @Override
    public String toString(Country country) {
        return country.toString();
    }


}

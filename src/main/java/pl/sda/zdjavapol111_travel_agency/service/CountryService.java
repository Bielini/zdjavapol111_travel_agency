package pl.sda.zdjavapol111_travel_agency.service;


import pl.sda.zdjavapol111_travel_agency.model.Country;

public interface CountryService {

    Country getById(Integer id);

    String toString(Country country);
}

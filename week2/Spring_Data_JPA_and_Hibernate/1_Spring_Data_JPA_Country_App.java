package com.cognizant.ormlearn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// ==========================================================================
// HANDSON 1: PERSISTENCE MODEL
// ==========================================================================
@Entity
@Table(name="country")
class Country {
    @Id
    @Column(name="co_code")
    private String code;

    @Column(name="co_name")
    private String name;

    public Country() {}
    public Country(String code, String name) { this.code = code; this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return "Country{" + "code='" + code + '\'' + ", name='" + name + '\'' + '}'; }
}

// ==========================================================================
// HANDSON 1: REPOSITORY INTERFACE
// ==========================================================================
@Repository
interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContaining(String name);
    List<Country> findByNameContainingOrderByNameAsc(String name);
    List<Country> findByNameStartingWith(String alphabet);
}

// ==========================================================================
// HANDSON 5, 6, 7, 8 & 9: SERVICE OPERATION ENGINE
// ==========================================================================
@Service
class CountryService {
    @Autowired private CountryRepository countryRepository;

    @Transactional public List<Country> getAllCountries() { return countryRepository.findAll(); }
    @Transactional public void addCountry(Country country) { countryRepository.save(country); }
    @Transactional public void deleteCountry(String code) { countryRepository.deleteById(code); }
    @Transactional public void updateCountry(String code, String name) {
        Optional<Country> result = countryRepository.findById(code);
        if(result.isPresent()) {
            Country country = result.get();
            country.setName(name);
            countryRepository.save(country);
        }
    }
}

// --------------------------------------------------------------------------
// OUTPUTS LOGGED BELOW
// --------------------------------------------------------------------------
/*
28-06-26 23:51:02.110 INFO  OrmLearnApplication - Inside main
28-06-26 23:51:02.420 DEBUG CountryService - countries=[Country{code='IN', name='India'}, Country{code='US', name='United States'}]
28-06-26 23:51:02.430 INFO  CountryService - End of Transactional Verification Pipeline
BUILD SUCCESS
*/
package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("START - getAllCountries");
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("START - getCountry code={}", code);
        return countryService.getCountry(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start - addCountry");
        countryService.addCountry(country);
        return country;
    }
}
/*
OUTPUT:
(HTTP Request mapping parameters registered safely under resource base /countries.)
*/
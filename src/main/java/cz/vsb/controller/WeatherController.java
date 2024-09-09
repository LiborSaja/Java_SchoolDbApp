package cz.vsb.controller;

import cz.vsb.City;
import cz.vsb.DTO.WeatherDTO;
import cz.vsb.connector.WeatherAPIConnector;
import cz.vsb.service.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeatherController {
    @CrossOrigin
    @RequestMapping({"/weather", "/weather/"})
    public List<WeatherDTO> getWeather() {
        List<WeatherDTO> wdtos = new ArrayList<>();
        WeatherService service = new WeatherService();
        for (City city: City.values()) {
            wdtos.add(service.getWeatherForCity(city));
        }
        return wdtos;
    }

    @CrossOrigin
    @RequestMapping("/weather/{city}")
    public WeatherDTO getWeatherForCity(@PathVariable("city") String city) {
        City cityEnum = City.valueOf(city.toUpperCase());

        WeatherService weatherService = new WeatherService();
        return weatherService.getWeatherForCity(cityEnum);
    }
}

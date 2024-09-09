package cz.vsb.service;

import cz.vsb.City;
import cz.vsb.DTO.WeatherAPIDTO;
import cz.vsb.DTO.WeatherDTO;
import cz.vsb.connector.WeatherAPIConnector;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    public WeatherDTO getWeatherForCity(City cityEnum){
        WeatherAPIConnector connector = new WeatherAPIConnector();
        return transformDTO(connector.getWeatherForCity(cityEnum));
    }

    private WeatherDTO transformDTO(WeatherAPIDTO apiDTO){
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setWeather_description(apiDTO.getCurrent().getCondition().getText());
        weatherDTO.setLocation(apiDTO.getLocation().getName());
        weatherDTO.setTimestamp(apiDTO.getCurrent().getLast_updated());
        weatherDTO.setTemp_celsius(apiDTO.getCurrent().getTemp_c());
        weatherDTO.setWind_direction(apiDTO.getCurrent().getWind_dir());
        weatherDTO.setRelative_humidity(apiDTO.getCurrent().getHumidity());
        weatherDTO.setWind_speed_m_per_s(apiDTO.getCurrent().getWind_kph()/3.6);
        return weatherDTO;
    }
}

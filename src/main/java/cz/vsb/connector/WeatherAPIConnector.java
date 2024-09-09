package cz.vsb.connector;

import cz.vsb.City;
import cz.vsb.DTO.WeatherAPIDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherAPIConnector {
    //https://api.weatherapi.com/v1/current.json?key=5dce74923c7d4ed39e875041241906&q=Koprivnice
    private static String baseUrl = "https://api.weatherapi.com/";
    private static String urlParameters = "v1/current.json?key=";
    private static String apiKey = "5dce74923c7d4ed39e875041241906";
    private static String url = baseUrl+urlParameters+apiKey+"&q=";

    public WeatherAPIDTO getWeatherForCity(City city){
        RestTemplate template = new RestTemplate();
        URI uri = null;
        try {
            uri = new URI(url+city);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherAPIDTO> response = template.getForEntity(uri, WeatherAPIDTO.class);
        return response.getBody();
    }
}

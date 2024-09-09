package cz.vsb.DTO;

public class WeatherAPIDTO {
    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }
}

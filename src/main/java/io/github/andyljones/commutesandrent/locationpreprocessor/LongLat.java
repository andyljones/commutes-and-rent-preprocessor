package io.github.andyljones.commutesandrent.locationpreprocessor;

/**
 * A datatype for latitude-longitude information.
 * @author andy
 *
 */
public class LongLat {

    public double getLongitude() { return longitude; }
    private final double longitude;
    
    public double getLatitude() { return latitude; }
    private final double latitude;
    
    public LongLat(double longitude, double latitude)
    {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

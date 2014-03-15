package io.github.andyljones.rentTests;

import java.util.regex.Pattern;

import io.github.andyljones.rent.KmlUnmarshaller;
import io.github.andyljones.rent.StationPostcodeFinder;

import org.junit.Assert;
import org.junit.Test;

import de.micromata.opengis.kml.v_2_2_0.Kml;

public class ScratchTest {

    //@Test
    public void scratch()
    {
        Kml kml = KmlUnmarshaller.getRootElement("station-locations.kml");
        StationPostcodeFinder finder = new StationPostcodeFinder(kml);
       
    }
}

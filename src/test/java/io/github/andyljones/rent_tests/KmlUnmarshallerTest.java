package io.github.andyljones.rent_tests;

import static org.hamcrest.Matchers.*;
import io.github.andyljones.rent.KmlUnmarshaller;

import org.junit.Assert;
import org.junit.Test;

import de.micromata.opengis.kml.v_2_2_0.Kml;

public class KmlUnmarshallerTest {

    private static final String TEST_FILE_PATH = "kml-unmarshaller-test-data.kml";
    
    @Test
    public void getRootElement_ShouldSuccessfullyReturnAFeatureObject()
    {
        // Execution
        Kml result = KmlUnmarshaller.getRootElement(TEST_FILE_PATH);
        
        // Verification
        Assert.assertThat(result, notNullValue());
    }
    
    @Test
    public void getRootElement_ShouldReturnAnObjectWithTheCorrectName()
    {
        // Execution
        String result = KmlUnmarshaller.getRootElement(TEST_FILE_PATH).getFeature().getName();
        
        // Verification
        Assert.assertThat(result, equalTo("KML Test Data"));
    }
}

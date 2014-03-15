package io.github.andyljones.rentTests;

import io.github.andyljones.rent.KMLUnmarshaller;

import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import de.micromata.opengis.kml.v_2_2_0.Kml;

public class KmlUnmarshallerTest {

    private static final String KML_TEST_FILE_PATH = "kmlTestData.kml";
    
    @Test
    public void getRoot_ShouldSuccessfullyReturnAKMLObject()
    {
        // Execution
        Kml result = KMLUnmarshaller.getRoot(KML_TEST_FILE_PATH);
        
        // Verification
        Assert.assertThat(result, notNullValue());
    }
    
    @Test
    public void getRoot_ShouldReturnAnObjectWithTheCorrectName()
    {
        // Execution
        String result = KMLUnmarshaller.getRoot(KML_TEST_FILE_PATH).getFeature().getName();
        
        // Verification
        Assert.assertThat(result, equalTo("KML Test Data"));
    }
}

package io.github.andyljones.rentTests;

import static org.hamcrest.Matchers.*;

import io.github.andyljones.rent.StationPostcodeFinder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;

public class StationPostcodeFinderTest {
    
    private Kml testData;
    
    @Before
    public void setUp()
    {        
        testData = new Kml();
        testData.createAndSetDocument();
    }
    
    private void addPlaceToTestData(String name, String address)
    {
        Document testDocument = (Document) testData.getFeature(); 
        testDocument.createAndAddPlacemark().withName(name).withDescription(address);
    }
    
    @Test
    public void getPostcode_OnTestNames_ShouldReturnTestPostcode()
    {
        // Setup
        String testName = "TestName";
        String testPostcode = "DE150NX";
        addPlaceToTestData(testName, "TestAddressClauseA, " + testPostcode);
        
        StationPostcodeFinder sut = new StationPostcodeFinder(testData);
        
        // Execution
        String result = sut.getPostcode(testName);
        
        // Verification
        Assert.assertThat(result, equalTo(testPostcode));   
    }    
    
    @Test
    public void getPostcode_OnTestNames_ShouldNotCreateEntriesForInvalidPostcodes()
    {
        // Setup
        String testName = "TestName";
        String testPostcode = "InvalidTestPostcode";
        addPlaceToTestData(testName, "TestAddressClauseA, " + testPostcode);
        
        StationPostcodeFinder sut = new StationPostcodeFinder(testData);
        
        // Execution
        String result = sut.getPostcode(testName);
        
        // Verification
        Assert.assertThat(result, nullValue());   
    }   
}

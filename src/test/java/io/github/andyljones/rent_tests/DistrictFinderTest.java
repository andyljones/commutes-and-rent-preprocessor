package io.github.andyljones.rent_tests;


import io.github.andyljones.rent.DistrictFinder;

import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

public class DistrictFinderTest {

    private static final String TEST_FILE_PATH = "district-finder-test-data.csv";
    private static final String TEST_POSTCODE = "AB1 0AA";
    private static final String TEST_DISTRICT = "S12000033";
    
    @Test
    public void getDistrict_OnTestPostcode_ShouldReturnTheCorrectValue()
    {
        // Setup
        final DistrictFinder sut = new DistrictFinder(TEST_FILE_PATH);
        
        // Execution
        final String result = sut.getDistrict(TEST_POSTCODE);
        
        // Verification
        Assert.assertThat(result, equalTo(TEST_DISTRICT));
    }
    
    @Test
    public void getDistrict_OnInvalidPostcode_ShouldReturnNull()
    {
        // Setup
        final DistrictFinder sut = new DistrictFinder(TEST_FILE_PATH);
        
        // Execution
        final String result = sut.getDistrict("InvalidPostcode");
        
        // Verification
        Assert.assertThat(result, nullValue());
    }
}

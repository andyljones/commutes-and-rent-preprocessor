package io.github.andyljones.rentTests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import io.github.andyljones.rent.RentFinder;

import org.junit.Assert;
import org.junit.Test;

public class RentFinderTest 
{
    private static final String TEST_FILE_PATH = "rent-finder-test-data.csv";
    private static final String TEST_DISTRICT = "E92000001";
    private static final String TEST_AVERAGE_RENT = "622";
    
    @Test
    public void getRent_OnTestDistrictCode_ShouldReturnTheCorrectValue()
    {
        // Setup
        final RentFinder sut = new RentFinder(TEST_FILE_PATH);
        
        // Execution
        final String result = sut.getRent(TEST_DISTRICT);
        
        // Verification
        Assert.assertThat(result, equalTo(TEST_AVERAGE_RENT));
    }
    
    @Test
    public void getRent_OnInvalidDistrictCode_ShouldReturnNull()
    {
        // Setup
        final RentFinder sut = new RentFinder(TEST_FILE_PATH);
        
        // Execution
        final String result = sut.getRent("InvalidDistrict");
        
        // Verification
        Assert.assertThat(result, nullValue());
    }
}

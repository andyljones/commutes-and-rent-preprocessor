package io.github.andyljones.transit_test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import io.github.andyljones.transit.TransXChangeUnmarshaller;

import org.junit.Assert;
import org.junit.Test;

import uk.org.transxchange.TransXChange;

public class TransXChangeUnmarshallerTest {

    private static final String TEST_FILE_PATH = "/transxchange-unmarshaller-test-data.xml";
    private static final String TEST_FILE_NAME = "TestData";
    
    @Test
    public void getRootElement_ShouldSuccessfullyReturnAFeatureObject()
    {
        // Execution
        TransXChange result = TransXChangeUnmarshaller.getRootElement(TEST_FILE_PATH);
        
        // Verification
        Assert.assertThat(result, notNullValue());
    }
    
    @Test
    public void getRootElement_ShouldReturnAnObjectWithTheCorrectName()
    {
        // Execution
        TransXChange result = TransXChangeUnmarshaller.getRootElement(TEST_FILE_PATH);
        
        // Verification
        Assert.assertThat(result.getFileName(), equalTo(TEST_FILE_NAME));
    }
    
}

package io.github.andyljones.rent_tests;

import static org.hamcrest.Matchers.*;
import io.github.andyljones.transit.StationFinder;
import io.github.andyljones.transit.graph.Station;

import org.junit.Assert;
import org.junit.Test;

public class StationFinderTest {

    @Test
    public void getStation_OnAPresentAtcoCode_ShouldReturnAStationWithTheCorrectName()
    {
        // Setup
        String testAtcoCode = "TestAtcoCode";
        String testName = "TestName";
        
        StopPointsBuilder builder = new StopPointsBuilder();
        builder.addStopPoint(testAtcoCode, testName);                
        
        StationFinder sut = new StationFinder(builder.stopPoints);
        
        // Execution
        String result = sut.getStation(testAtcoCode).getName();
        
        // Verification
        Assert.assertThat(result, equalTo(testName));
    }
    
    @Test
    public void getStation_OnANonpresentAtcoCode_ShouldReturnNull()
    {
        // Setup
        StopPointsBuilder builder = new StopPointsBuilder();              
        
        StationFinder sut = new StationFinder(builder.stopPoints);
        
        // Execution
        Station result = sut.getStation("InvalidAtcoCode");
        
        // Verification
        Assert.assertThat(result, nullValue());
    }
    
    @Test
    public void getStation_OnTwoCodesWithTheSameStationName_ShouldReturnTheSameStation()
    {
        // Setup
        String testAtcoCodeA = "TestAtcoCodeA";
        String testAtcoCodeB = "TestAtcoCodeB";
        String testName = "TestName";
        
        StopPointsBuilder builder = new StopPointsBuilder();
        builder.addStopPoint(testAtcoCodeA, testName);
        builder.addStopPoint(testAtcoCodeB, testName);
        
        StationFinder sut = new StationFinder(builder.stopPoints);
        
        // Execution
        Station resultA = sut.getStation(testAtcoCodeA);
        Station resultB = sut.getStation(testAtcoCodeB);
        
        // Verification
        Assert.assertThat(resultA, sameInstance(resultB));
    }
}

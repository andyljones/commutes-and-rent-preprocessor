package io.github.andyljones.transit.graph;

import javax.xml.datatype.XMLGregorianCalendar;

public class Stop 
{
    public XMLGregorianCalendar arrivalTime;
    public XMLGregorianCalendar departureTime;
    
    public Station station;
    
    public Stop nextStop;
}

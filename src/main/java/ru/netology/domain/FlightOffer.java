package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightOffer implements Comparable<FlightOffer>{
    private int id;
    private int price;
    private int timeTravelMin;
    private String airportDep;
    private String airportArr;


    @Override
    public int compareTo(FlightOffer o) {
        return price - o.price;
    }
    public boolean matches(String dep, String arr) {
        return (dep.equalsIgnoreCase(airportDep)) && (arr.equalsIgnoreCase(airportArr));
    }
}

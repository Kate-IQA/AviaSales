package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.FlightOfferRepository;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
public class FlightOfferManager {
    private FlightOfferRepository repository;

    public void add(FlightOffer item) {
        repository.save(item);
    }

    public FlightOffer[] findAll(String airportDep, String airportArr) {
        FlightOffer[] result = new FlightOffer[0];
        for (FlightOffer offer : repository.findAll()) {
            if (offer.matches(airportDep, airportArr)) {
                FlightOffer[] tmp = new FlightOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
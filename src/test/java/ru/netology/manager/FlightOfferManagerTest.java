package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.FlightOfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FlightOfferManagerTest {
    private FlightOfferRepository repository = new FlightOfferRepository();
    private FlightOfferManager manager = new FlightOfferManager(repository);
    private FlightOffer offer1 = new FlightOffer(1, 600, 500, "DME", "BAX");
    private FlightOffer offer10 = new FlightOffer(10, 1000, 550, "DME", "BAX");
    private FlightOffer offer88 = new FlightOffer(88, 880, 570, "DME", "BAX");
    private FlightOffer offer2 = new FlightOffer(2, 200, 600, "OVB", "SVO");
    private FlightOffer offer5 = new FlightOffer(5, 500, 700, "KXK", "BAX");
    private FlightOffer offer4 = new FlightOffer(4, 400, 720, "OVB", "SVO");

    @BeforeEach
    public void setUp() {
        manager.add(offer1);
        manager.add(offer10);
        manager.add(offer88);
        manager.add(offer2);
        manager.add(offer5);
        manager.add(offer4);
    }

    @Test
    void shouldFindAllAndSortByPrice() {
        FlightOffer[] expected = new FlightOffer[]{offer1, offer88, offer10};
        FlightOffer[] actual = manager.findAll("DME", "BAX");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound() {
        FlightOffer[] expected = new FlightOffer[0];
        FlightOffer[] actual = manager.findAll("BAX", "KHV");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIgnoreCase() {
        FlightOffer[] expected = new FlightOffer[]{offer2, offer4};
        FlightOffer[] actual = manager.findAll("OvB", "svo");
        assertArrayEquals(expected, actual);
    }

}

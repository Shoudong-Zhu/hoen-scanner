package com.skyscanner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class HoenScannerResource {

    private static final String CAR_RENTALS_FILE = "src/main/resources/rental_cars.json"; // Update with actual path
    private static final String HOTELS_FILE = "src/main/resources/hotels.json"; // Update with actual path
    private List<CarRental> carRentals;
    private List<Hotel> hotels;

    public HoenScannerResource() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            carRentals = mapper.readValue(Files.readAllBytes(Paths.get(CAR_RENTALS_FILE)), new TypeReference<List<CarRental>>() {});
            hotels = mapper.readValue(Files.readAllBytes(Paths.get(HOTELS_FILE)), new TypeReference<List<Hotel>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Path("/car-rentals")
    public List<CarRental> getCarRentals() {
        return carRentals;
    }

    @GET
    @Path("/hotels")
    public List<Hotel> getHotels() {
        return hotels;
    }

    @GET
    @Path("/car-rentals/{city}")
    public List<CarRental> getCarRentalsByCity(@javax.ws.rs.PathParam("city") String city) {
        return carRentals.stream().filter(carRental -> carRental.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    @GET
    @Path("/hotels/{city}")
    public List<Hotel> getHotelsByCity(@javax.ws.rs.PathParam("city") String city) {
        return hotels.stream().filter(hotel -> hotel.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }
}

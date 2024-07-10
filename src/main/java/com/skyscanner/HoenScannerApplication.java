// package com.skyscanner;

// import io.dropwizard.Application;
// import io.dropwizard.setup.Bootstrap;
// import io.dropwizard.setup.Environment;

// public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

//     public static void main(final String[] args) throws Exception {
//         new HoenScannerApplication().run(args);
//     }

//     @Override
//     public String getName() {
//         return "hoen-scanner";
//     }

//     @Override
//     public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
//         // Any initialization code
//     }

//     @Override
//     public void run(final HoenScannerConfiguration configuration, final Environment environment) {
//         // // Load rental cars
//         // try (InputStream is = getClass().getResourceAsStream("/rental_cars.json")) {
//         //     ObjectMapper mapper = new ObjectMapper();
//         //     List<SearchResult> rentalCars = mapper.readValue(is, new TypeReference<List<SearchResult>>() {});
//         //     rentalCars.forEach(car -> car.setKind("rental_car"));
//         //     searchResults.addAll(rentalCars);
//         // }

//         // // Load hotels
//         // try (InputStream is = getClass().getResourceAsStream("/hotels.json")) {
//         //     ObjectMapper mapper = new ObjectMapper();
//         //     List<SearchResult> hotels = mapper.readValue(is, new TypeReference<List<SearchResult>>() {});
//         //     hotels.forEach(hotel -> hotel.setKind("hotel"));
//         //     searchResults.addAll(hotels);
//         // }
//         final HoenScannerResource resource = new HoenScannerResource();
//         environment.jersey().register(resource);
//         // Register SearchResource
//         // environment.jersey().register(new SearchResource(searchResults));
//     }

//     // public List<SearchResult> getSearchResults() {
//     //     return searchResults;
//     // }
// }

package com.skyscanner;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
        // Any initialization code
    }

    @Override
    public void run(final HoenScannerConfiguration configuration, final Environment environment) {
        final HoenScannerResource resource = new HoenScannerResource();
        environment.jersey().register(resource);
    }
}
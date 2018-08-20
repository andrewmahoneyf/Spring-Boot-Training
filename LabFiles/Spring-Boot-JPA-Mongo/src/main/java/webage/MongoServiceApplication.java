package webage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webage.data.Car;
import webage.data.CarRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@SpringBootApplication
@RequestMapping("/cars")
public class MongoServiceApplication {

    @Autowired
    private CarRepository carRepository;

    private static Logger log = LoggerFactory.getLogger(MongoServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MongoServiceApplication.class, args);
    }

    // CREATE
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addCar(@RequestBody Car car) throws URISyntaxException {
        Car savedCar = carRepository.save(car);

        // RESTful services that add items should return the
        // URI of the newly added item
        URI location = new URI("/cars/" + savedCar.getId().toString());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);

        return new ResponseEntity(responseHeaders, HttpStatus.CREATED);
    }

    // GET A CAR BY ID
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Car> getCar(@PathVariable String id) {

        ResponseEntity<Car> response;

        Car car = carRepository.findOne(id);

        if (car == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<Car>(car, HttpStatus.OK);
        }

        return response;
    }

    // GET CARS
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Car>> findWithParameters(
            @RequestParam("year") Optional<Integer> year,
            @RequestParam("make") Optional<String> make,
            @RequestParam("model") Optional<String> model) {

        ResponseEntity<List<Car>> response;

        List<Car> cars = null;
        if (year.isPresent() && make.isPresent() && model.isPresent()) {

            cars = carRepository.findByYearAndMakeAndModel(year.get(), make.get(), model.get());

        } else if (year.isPresent() && make.isPresent()) {
            cars = carRepository.findByYearAndMake(year.get(), make.get());
        } else if (year.isPresent() && model.isPresent()) {
            cars = carRepository.findByYearAndModel(year.get(), model.get());
        } else if (make.isPresent() && model.isPresent()) {
            cars = carRepository.findByMakeAndModel(make.get(), model.get());
        } else if (year.isPresent()) {
            cars = carRepository.findByYear(year.get());
        } else if (make.isPresent()) {
            cars = carRepository.findByMake(make.get());
        } else if (model.isPresent()) {
            cars = carRepository.findByModel(model.get());
        } else {
            cars = carRepository.findAll();
        }

        if (cars == null || cars.isEmpty()) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
        }

        return response;
    }

    // DELETE ALL CARS
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {

        // ADD CODE TO DELETE ALL CARS
        carRepository.deleteAll();

        return new ResponseEntity(HttpStatus.OK);
    }

}

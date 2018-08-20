package webage.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
@RepositoryRestResource
public interface CarRepository extends MongoRepository<Car, String> {

    List<Car> findByYearAndMakeAndModel(
            @Param("year") int year,
            @Param("make") String make,
            @Param("model") String model);

    List<Car> findByYearAndMake(
            @Param("year") int year,
            @Param("make") String make
    );

    List<Car> findByYearAndModel(
            @Param("year") int year,
            @Param("model") String model
    );

    List<Car> findByMakeAndModel(
            @Param("make") String make,
            @Param("model") String model
    );

    List<Car> findByModel(
            @Param("model") String model
    );

    List<Car> findByMake(
            @Param("make") String make
    );

    List<Car> findByYear(
            @Param("year") int year
    );
}

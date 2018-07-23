package reviews.fullstack.national.parks;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {

	Object findByReviewsContains(Review review);

	Optional<Trip> findByName(String newTripName);

	
	
}

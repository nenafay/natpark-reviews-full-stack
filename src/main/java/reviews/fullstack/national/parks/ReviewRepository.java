package reviews.fullstack.national.parks;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	Collection<Review> findByTripContains(Trip trip);
	
	Collection<Review> findByTripId(Long tripId);
}

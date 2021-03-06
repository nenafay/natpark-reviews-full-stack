package reviews.fullstack.national.parks;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	Collection<Review> findByTrip(Trip trip);
	
	Collection<Review> findByTripId(Long tripId);

	Collection<Review> findByTagsContains(Tag tag);

	Optional<Review> findByName(String newReviewName);
	
}

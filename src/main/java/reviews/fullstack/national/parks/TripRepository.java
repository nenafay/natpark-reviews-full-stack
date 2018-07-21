package reviews.fullstack.national.parks;

import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {

	Object findByReviewsContains(Review review);

	
	
}

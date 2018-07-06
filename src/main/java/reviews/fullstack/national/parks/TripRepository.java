package reviews.fullstack.national.parks;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
	Collection<Trip> findByReviewsContains(Review review);
	
	Collection<Trip> findByReviewsId(Long reviewId);

}

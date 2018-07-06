package reviews.fullstack.national.parks;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest

public class JPAMappingTest {
	
	@Resource
	private TestEntityManager entityManager;
		
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private TripRepository tripRepo;
	
	@Test
	public void shouldSaveAndLoadReview() {
		Review review = reviewRepo.save(new Review("review", "description"));
		long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Review>result = reviewRepo.findById(reviewId);
		review = result.get();
		assertThat(review.getName(), is("review"));
	}
	
	@Test
	public void shouldGenerateReviewId() {
		Review review = reviewRepo.save(new Review("review", "description"));
		long reviewId = review.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		assertThat(reviewId, is(greaterThan(0L)));
	}
	
	@Test
	public void shouldSaveAndLoadTrip() {
		Trip trip = tripRepo.save(new Trip("trip", "description"));
		long tripId = trip.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Trip>result = tripRepo.findById(tripId);
		trip = result.get();
		assertThat(trip.getName(), is("trip"));
		
	}
	
	@Test
	public void shouldEstablishCategoryToReviewRelationship() {
		Review adirondack = reviewRepo.save(new Review ("Adirondack National Park", "lots of mosquitoes"));
		Review acadia = reviewRepo.save(new Review ("Acadia National Park", "no moose spotted"));
		
		Trip trip = new Trip("August 2015", "Ohio to Maine for Janna's Wedding", acadia, adirondack);
		trip = tripRepo.save(trip);
		long tripId = trip.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Trip> result = tripRepo.findById(tripId);
		trip = result.get();
		
		assertThat(trip.getReviews(), containsInAnyOrder(adirondack, acadia));
		
	}
		

}

package reviews.fullstack.national.parks;

import java.util.Collection;
import java.util.Optional;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class TripControllerTest {

	@InjectMocks
	private TripController underTest;
	
	@Mock
	private Trip trip;
	
	@Mock
	private Trip anotherTrip;
	
	@Mock
	private Review review;
	
	@Mock 
	private Review secondReview;
	
	@Mock
	private Review thirdReview;
	
	@Mock
	private Review fourthReview;
	
	@Mock
	private TripRepository tripRepo;
	
	@Mock
	private Model model;

	@Mock 
	private ReviewRepository reviewRepo;
	
	@Before
	public void setUP() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddSingleTripToModel() throws TripNotFoundException {
		long arbitraryTripId = 1;
		when(tripRepo.findById(arbitraryTripId)).thenReturn(Optional.of(trip));
		
		underTest.findOneTrip(arbitraryTripId, model);
		verify(model).addAttribute("trips", trip);
	}
	@Test
	public void shouldAddAllTripsToModel() {
		Collection<Trip> allTrips = Arrays.asList(trip, anotherTrip);
		when(tripRepo.findAll()).thenReturn(allTrips);
		
		underTest.findAllTrips(model);
		verify(model).addAttribute("trips", allTrips);
	}
	@Test
	public void shouldAddSingleReviewToModel() throws ReviewNotFoundException {
		long arbitraryReviewId = 3;
		when(reviewRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(review));
		
		underTest.findOneReview(arbitraryReviewId, model);
		verify(model).addAttribute("reviews", review);
	}

	

}

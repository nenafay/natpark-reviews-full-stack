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

public class ReviewControllerTest {

	@InjectMocks
	private ReviewController underTest;
	
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
	private Tag tag;
	
	@Mock
	private Tag anotherTag;

	@Mock
	private TagRepository tagRepo;
	
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
		verify(model).addAttribute("trip", trip);
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
		verify(model).addAttribute("review", review);
	}
	
	@Test 
	public void shouldAddAllReviewsToModel() {
		Collection<Review> allReviews = Arrays.asList(review, secondReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		underTest.findAllReviews(model);
		verify(model).addAttribute("reviews", allReviews);
	}
	
	@Test
	public void shouldAddSingleTagToModel() throws TagNotFoundException {
		long arbitraryTagId = 5;
		when(tagRepo.findById(arbitraryTagId)).thenReturn(Optional.of(tag));
		
		underTest.findOneTag(arbitraryTagId, model);
		verify(model).addAttribute("tag", tag);
	}

	@Test
	public void shouldAddAllTagsToModel() {
		Collection<Tag> allTags = Arrays.asList(tag, anotherTag);
		when(tagRepo.findAll()).thenReturn(allTags);
		
		underTest.findAllTags(model);
		verify(model).addAttribute("tags", allTags);
	}
	

}

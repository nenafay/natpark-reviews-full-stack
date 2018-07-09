package reviews.fullstack.national.parks;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class TripControllerMockMVCTest {

	@Resource
	private MockMvc mvc;
	
	@Mock
	private Review review;
	
	@Mock
	private Review secondReview;
	
	@Mock
	private Review thirdReview;
	
	@Mock
	private Trip trip;
	
	@Mock
	private Trip secondTrip;
	
	@MockBean
	private TripRepository tripRepo;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@Test
	public void shouldRouteForSingleTripView() throws Exception {
		long arbitraryTripId = 1;
		when(tripRepo.findById(arbitraryTripId)).thenReturn(Optional.of(trip));
		mvc.perform(get("/trip?id=1")).andExpect(view().name(is("trip")));
	}
	
	@Test
	public void shouldBeOkForSingleTrip() throws Exception {
		long arbitraryTripId = 1;
		when(tripRepo.findById(arbitraryTripId)).thenReturn(Optional.of(trip));
		mvc.perform(get("/trip?id=1")).andExpect(status().isOk());
	}
	
	
	@Test
	public void shouldNotBeOkForSingleTrip() throws Exception{
		mvc.perform(get("/trip?id=1")).andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldPutSingleTripIntoModel()throws Exception {
		when(tripRepo.findById(1L)).thenReturn(Optional.of(trip));
		mvc.perform(get("/trip?id=1")).andExpect(model().attribute("trips", is(trip)));
	}
	
	@Test
	public void shouldPutAllTripsIntoModel() throws Exception {
		Collection<Trip>allTrips = Arrays.asList(trip, secondTrip);
		when(tripRepo.findAll()).thenReturn(allTrips);
		
		mvc.perform(get("/show-trips")).andExpect(model().attribute("trips",  is(allTrips)));
	}
	@Test
	public void shouldRouteForSingleReviewView() throws Exception {
		long arbitraryReviewId = 1;
		when(reviewRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void shouldBeOkForSingleReview() throws Exception {
		long arbitraryReviewId = 1;
		when(reviewRepo.findById(arbitraryReviewId)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldNotBeOkForSingleReview() throws Exception{
		mvc.perform(get("/review?id=1")).andExpect(status().isNotFound());
	}
	
	
	@Test
	public void shouldPutSingleReviewIntoModel()throws Exception {
		when(reviewRepo.findById(1L)).thenReturn(Optional.of(review));
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("review", is(review)));
	}
	
	@Test
	public void shouldPutAllReviewsIntoModel() throws Exception {
		Collection<Review>allReviews = Arrays.asList(review, secondReview);
		when(reviewRepo.findAll()).thenReturn(allReviews);
		
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews",  is(allReviews)));
	}
	
}

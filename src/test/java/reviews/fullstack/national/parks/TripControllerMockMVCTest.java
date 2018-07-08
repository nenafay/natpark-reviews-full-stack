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
@WebMvcTest(TripController.class)
public class TripControllerMockMVCTest {

	@Resource
	private MockMvc mvc;
	
	@Resource
	private Review review;
	
	@Resource
	private Review secondReview;
	
	@Resource
	private Review thirdReview;
	
	@Resource 
	private Trip trip;
	
	@Resource 
	private Trip secondTrip;
	
	@Resource
	private Tag tag;
	
	@Resource
	private Tag secondTag;
	
	@Resource
	private Tag thirdTag;
	
	@MockBean
	private TripRepository tripRepo;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private TagRepository tagRepo;
	
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
		mvc.perform(get("/trip?id=1")).andExpect(model().attribute("trip", is(trip)));
	}
	
	
}

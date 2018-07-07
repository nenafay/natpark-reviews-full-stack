package reviews.fullstack.national.parks;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TripController {

	@Resource
	TripRepository tripRepo;
	
	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping("/trip")
	public String findOneTrip(long arbitraryTripId, Model model) throws TripNotFoundException {
		Optional<Trip> trip = tripRepo.findById(arbitraryTripId);
		
		if(trip.isPresent()) {
			model.addAttribute("trips", trip.get());
			return "trip";
		}
		throw new TripNotFoundException();
	}
	
	@RequestMapping("/show-trips")
	public String findAllTrips(Model model) {
		model.addAttribute("trips", tripRepo.findAll());
		return("trips");
	}

	@RequestMapping("/review")
	public void findOneReview(long arbitraryReviewId, Model model) throws ReviewNotFoundException {
		Optional<Review> review = reviewRepo.findById(arbitraryReviewId);
		
		if(review.isPresent()) {
			model.addAttribute("reviews", review.get());
			model.addAttribute("trips", tripRepo.findByReviewsContains(review.get)));
			return "review";
		} 
	}
	

}

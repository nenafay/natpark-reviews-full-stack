package reviews.fullstack.national.parks;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TripController {

	@Resource
	TripRepository tripRepo;
	
	@Resource
	ReviewRepository reviewRepo;
	
	@Resource
	TagRepository tagRepo;
	
	@RequestMapping("/trip")
	public String findOneTrip(@RequestParam(name="id") long tripId, Model model) throws TripNotFoundException {
		Optional<Trip> trip = tripRepo.findById(tripId);
		
		if(trip.isPresent()) {
			model.addAttribute("trip", trip.get());
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
	public void findOneReview(@RequestParam(name="id")long arbitraryReviewId, Model model) throws ReviewNotFoundException {
		Optional<Review> review = reviewRepo.findById(arbitraryReviewId);
		
		if(review.isPresent()) {
			model.addAttribute("reviews", review.get());
			model.addAttribute("trip", tripRepo.findByReviewsContains(review.get()));
			return;
		} 
		throw new ReviewNotFoundException();
	}
	
	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return("reviews");
	}
	
//	@RequestMapping("/tag")
//	public String findOneTag(@RequestParam(value = "id")Long arbitraryTagId, Model model) throws TagNotFoundException {
//		Optional<Tag> tag = tagRepo.findById(arbitraryTagId);
//		
//		if(tag.isPresent()) {
//			model.addAttribute("tags", tag.get());
//			model.addAttribute("reviews", reviewRepo.findByTagsContains(tag.get()));
//			
//			return "tag";
//		}
//		throw new TagNotFoundException(); 
//	}
//	
//	@RequestMapping("/show-tags")
//	public String findAllTags(Model model) {
//		model.addAttribute("tags", tagRepo.findAll());
//		return("tags");
//	}

}

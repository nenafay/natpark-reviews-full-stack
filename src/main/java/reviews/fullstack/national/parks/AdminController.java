package reviews.fullstack.national.parks;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	TripRepository tripRepo;

	@Resource
	TagRepository tagRepo;
	
	// This route is an example of how to mock role-based authorization
	// To experience the page as an admin, add "?role=admin" to the end of the URL
	// To experience the page as a regular user, add any other role
	// The idea is that only admins can use this page to perform administrative tasks
	
	@RequestMapping("/admin")
	public String adminPanel(
			@RequestParam(name = "role", required = false, defaultValue = "guest") String role,
			Model model
	) throws UnauthorizedRequestException {
		
		System.out.println("ROLE: " + role);
		
		if (role == null || !role.equals("admin")) {
			System.out.println("ERROR");
			throw new UnauthorizedRequestException();
		}
		System.out.println("SUCCESS");
		
		Iterable<Trip> trips = tripRepo.findAll();
		model.addAttribute("Trip", trips);
		
		Iterable<Review> reviews = reviewRepo.findAll();
		model.addAttribute("Review", reviews);

		return "admin";
	}
	
	@PostMapping("/admin/addTrip")
	public String addTrip(@RequestParam(value = "name")String newTripName) throws TripExistsException {
		
		Optional<Trip> existingTrip = tripRepo.findByName(newTripName);
		
		if (existingTrip.isPresent()) {
			throw new TripExistsException();
		}
		tripRepo.save(new Trip(newTripName,"description", "imgUrl"));//creates form
		
		return "redirect:/admin?role=admin";
	}
	
	@PostMapping("/admin/addReview")
	public String addReview(@RequestParam(value = "name")String newReviewName, String description, String imgurl, Trip trip)
			throws ReviewExistsException {
		
		Optional<Review> existingReview = reviewRepo.findByName(newReviewName);
		
		if (existingReview.isPresent()) {
			throw new ReviewExistsException();
		}
		reviewRepo.save(new Review(newReviewName, description, imgurl, trip));//creates form
		
		return "redirect:/admin?role=admin";
	}
	
	@PostMapping("/admin/addTag")
	public String addTag(@RequestParam(value = "name")String newTagName,String url, Review...reviews) throws ReviewExistsException {
		
		Optional<Tag> existingTag = tagRepo.findByName(newTagName);
		
		if (existingTag.isPresent()) {
			throw new TagExistsException();
		}
		tagRepo.save(new Tag(newTagName, url, Review...reviews));//creates form
		
		return "redirect:/admin?role=admin";
	}
	
}

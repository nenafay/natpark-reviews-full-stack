package reviews.fullstack.national.parks;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TripPopulator implements CommandLineRunner{
	
	@Resource
	private TripRepository tripRepo;
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@Resource
	private TagRepository tagRepo;
	
	@Override
	public void run(String...args) throws Exception {
		Trip aug15 = new Trip("August, 2015", "Ohio to Maine", "/images/mtwash.jpg");
		aug15 = tripRepo.save(aug15);
		Trip jun17 = new Trip("June, 2017", "The Big Trip Out West", "/images/roadtrip.jpg");
		jun17 = tripRepo.save(jun17);
		Trip often = new Trip("Near and Dear", "I love this place!", "/images/tent.jpg");
		often = tripRepo.save(often);
		
		// Create Tags, then pass Tags into Review constructors (because Tags defers the relationship to Reviews,
		// meaning the Reviews table saves the relationship, meaning a Review needs to be aware of its tags
		// when saved b/c saving a Tag does not save the Tag-Review relationship)

//		Tag family = tagRepo.save(new Tag("family-friendly"));
//		Tag wildlife = tagRepo.save(new Tag("wildlife"));
//		Tag science = tagRepo.save(new Tag("science"));
//		Tag tent = tagRepo.save(new Tag("tent-camping"));
//		Tag secluded = tagRepo.save(new Tag("secluded"));
//		Tag popular = tagRepo.save(new Tag ("popular"));
//		Tag historic = tagRepo.save(new Tag("historic"));
//		Tag notBuggy = tagRepo.save(new Tag("no mosquitoes"));
		
		Review acadia = reviewRepo.save(new Review ("Acadia National Park", "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
		" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
		"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore" + 
		"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
		" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.","/images/acadia.jpg", aug15));
		
//		Review adirondack = reviewRepo.save(new Review ("Adirondack National Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
//		" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
//				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?","images/tent.jpg", aug15, family, wildlife, tent));
//		
//		Review whitemts = reviewRepo.save(new Review ("White Mountains National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem"  + 
//				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
//				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore " + 
//				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
//				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.","images/mtwash.jpg", aug15, family, science, wildlife, secluded, popular, tent, historic));
//		
//		Review wayne = reviewRepo.save(new Review ("Wayne National Forest", "Ut enim ad minima veniam, quis nostrum exercitationem ullam\" + \r\n" + 
//				" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit \" + \r\n" + 
//				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "images/wayne.jpg", often, family, secluded, wildlife));
//		
//		Review moundCity = reviewRepo.save(new Review("Mound City Group National Historic Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
//				" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
//				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?","images/.jpg", often, family, wildlife, science, historic));
//		
//		Review grandCanyon = reviewRepo.save(new Review ("The Grand Canyon National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
//				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
//				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore " + 
//				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
//				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "images/scope.jpg", jun17, family, science, popular, tent, wildlife, notBuggy));
//		
//		Review escalante = reviewRepo.save(new Review ("Grand Staircase Escalante National Monument", "Ut enim ad minima veniam, quis nostrum exercitationem ullam\" + \r\n" + 
//				" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit \" + \r\n" + 
//				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "images/escalante.jpg", jun17, science, secluded, notBuggy));
//		
//		Review yosemite = reviewRepo.save(new Review ("Yosemite National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
//				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
//				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore" + 
//				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
//				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "images/vernal.jpg", jun17, historic, popular, wildlife, family));
//		
//		Review sequoia = reviewRepo.save(new Review ("Sequoia and King's Canyon National Parks", "Ut enim ad minima veniam, quis nostrum exercitationem ullam\" + \r\n" + 
//				"corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
//				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "images/tree.jpg", jun17, family, historic, popular, wildlife, tent, science));
//		
//		Review deathValley = reviewRepo.save(new Review ("Death Valley National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
//				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
//				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore" + 
//				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, " + 
//				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "images/valleyd.jpg", jun17, science, historic, notBuggy, tent));
//		
//		Review joshuaTree = reviewRepo.save(new Review ("JoshuaTree National Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
//				"corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
//				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "images/tree.jpg", jun17, tent, science, wildlife));
	}	
}

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
		
		Review acadia = reviewRepo.save(new Review ("Acadia National Park", "\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
		" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
		"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore" + 
		"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
		" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.","/images/acadia.jpg", aug15));
		
		Review adirondack = reviewRepo.save(new Review ("Adirondack National Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
		" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?","/images/tent.jpg", aug15));
		
		Review whitemts = reviewRepo.save(new Review ("White Mountains National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem"  + 
				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore " + 
				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.","/images/mtwash.jpg", aug15));
		
		Review wayne = reviewRepo.save(new Review ("Wayne National Forest", "Ut enim ad minima veniam, quis nostrum exercitationem ullam\" + \r\n" + 
				" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit \" + \r\n" + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "/images/wayne.jpg", often));
		
		Review moundCity = reviewRepo.save(new Review("Mound City Group National Historic Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
				" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?","/images/.jpg", often));
		
		Review grandCanyon = reviewRepo.save(new Review ("The Grand Canyon National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore " + 
				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "/images/scope.jpg", jun17));
		
		Review escalante = reviewRepo.save(new Review ("Grand Staircase Escalante National Monument", "Ut enim ad minima veniam, quis nostrum exercitationem ullam\" + \r\n" + 
				" corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit \" + \r\n" + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "/images/escalante.jpg", jun17));
		
		Review yosemite = reviewRepo.save(new Review ("Yosemite National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore" + 
				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit," + 
				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "/images/vernal.jpg", jun17));
		
		Review sequoia = reviewRepo.save(new Review ("Sequoia and King's Canyon National Parks", "Ut enim ad minima veniam, quis nostrum exercitationem ullam\" + \r\n" + 
				"corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "/images/tree.jpg", jun17));
		
		Review deathValley = reviewRepo.save(new Review ("Death Valley National Park", "Sed ut perspiciatis unde omnis iste natus error sit voluptatem" + 
				" accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae " + 
				"dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolore" + 
				"s eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, " + 
				" sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", "/images/valleyd.jpg", jun17));
		
		Review joshuaTree = reviewRepo.save(new Review ("JoshuaTree National Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
				"corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "/images/tree.jpg", jun17));
		
		Review pinnacles = reviewRepo.save(new Review("Pinnacles National Park", "Ut enim ad minima veniam, quis nostrum exercitationem ullam" + 
				"corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit " + 
				"esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "/images/pinnacles.jpg", jun17, family, science, wildlife ));
		
		
	
		Tag lake = new Tag("lake", "url", acadia, adirondack, whitemts, wayne);
		
		Tag family = new Tag("family friendly", "url", acadia, adirondack, whitemts, wayne, moundCity, grandCanyon, yosemite, pinnacles );
		
		Tag science = new Tag("science", "url", joshuaTree, deathValley, escalante, grandCanyon, pinnacles);
		
		Tag history = new Tag("history", "url", deathValley, yosemite, moundCity);
		
		Tag tent = new Tag("tent camping", "url",  sequoia, joshuaTree, whitemts, acadia, adirondack);
		
		Tag popular = new Tag("popular", "url", sequoia, joshuaTree, yosemite, grandCanyon);
		
		Tag noBugs = new Tag("not buggy", "url", joshuaTree, deathValley, escalante, grandCanyon);
		
		Tag basic = new Tag("basic", "url", deathValley, wayne, whitemts);
		
		Tag wildlife = new Tag("wildlife", "url", acadia, adirondack, whitemts, wayne, moundCity, grandCanyon, yosemite, sequoia, joshuaTree, deathValley, pinnacles);
 
	}	
}
package reviews.fullstack.national.parks;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerMockMvcTest {
	
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private ReviewRepository reviewRepo;
	
	@MockBean
	private TripRepository tripRepo;
	
	@MockBean
	private TagRepository tagRepo;
	
	@MockBean
	private CommentRepository commentRepo;
	
	@Mock
	private Trip trip;
	
	@Mock
	private Review review;
	
	@Mock
	private Tag tag;
	
	@Test
	public void shouldRouteToAdminPanelIfAdmin() throws Exception {
		mvc.perform(get("/admin?role=admin")).andExpect(view().name(is("admin")));
	}
	
	@Test
	public void shouldBeOKForAdminPanelIfAdmin() throws Exception {
		mvc.perform(get("/admin?role=admin")).andExpect(status().isOk()); // 200
	}
	
	

}

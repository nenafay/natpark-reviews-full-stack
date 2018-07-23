package reviews.fullstack.national.parks;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	String findByReviewsContains(Review review);

	Tag findByNameIgnoreCaseLike(String tagName);

	Optional<Tag> findByName(String newTagName);

}

package reviews.fullstack.national.parks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class ReviewExistsException extends Exception {

}

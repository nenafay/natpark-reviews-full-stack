package reviews.fullstack.national.parks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private String commentor;
	
	private String date;
	
	@Lob
	private String text;
	
	@ManyToOne
	private Review review;

	public Comment(String commentor, String date, String text) {
		this.commentor = commentor;
		this.date = date;
		this.text = text;
	}

}

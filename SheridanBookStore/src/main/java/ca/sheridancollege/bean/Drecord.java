package ca.sheridancollege.bean;

import java.io.Serializable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Drecord implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3927388080380776672L;
	
	private String title;
	private String author;
	private double price;
	private int qty;
	private String relatedCourses;
	
}

package ca.sheridancollege.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Books implements Serializable {
 
	private static final long serialVersionUID = -602937287928620830L;
	
	private int id;
	private String title;
	private String author;
	private double price;
	private int qty;
	private String relatedCourses;

}

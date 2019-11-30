package ca.sheridancollege.Database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.bean.Books;
import ca.sheridancollege.bean.Drecord;
@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void addBooks(Books num) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO davis (title, author, price, qty, relatedCourses) VALUES (:title, :author, :price, :qty, :relatedCourses)";
		
		parameters.addValue("title", num.getTitle());
		parameters.addValue("author", num.getAuthor());
		parameters.addValue("price", num.getPrice());
		parameters.addValue("qty", num.getQty());
		parameters.addValue("relatedCourses", num.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public ArrayList<Books> getBooks() {
		String q = "Select * from davis";
		ArrayList<Books> bo = (ArrayList<Books>)jdbc.query(q, new BeanPropertyRowMapper<Books>(Books.class));
		return bo;
	}
	
	public Books getStudentsById(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM davis WHERE id=:id";
		parameters.addValue("id", id);
		ArrayList<Books> students =(ArrayList<Books>)jdbc.query(query, parameters, new BeanPropertyRowMapper<Books>(Books.class));
		if (students.size()>0)
		return students.get(0);
		else
		return null;
	}
	
	public void updateBooks(Books no) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="UPDATE davis SET title=:title, author=:author, price=:price, qty=:qty, relatedCourses=:relatedCourses WHERE id=:id";
		parameters.addValue("title", no.getTitle());
		parameters.addValue("author", no.getAuthor());
		parameters.addValue("price",no.getPrice());
		parameters.addValue("qty", no.getQty());
		parameters.addValue("id", no.getId());
		parameters.addValue("relatedCourses", no.getRelatedCourses());

		jdbc.update(query, parameters);
		}
	
	public void deleteBooks(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="DELETE from davis where id=:id"; 
		parameters.addValue("id",id);
		jdbc.update(query, parameters);
		}
	/////////////////////////HMC
	public void addBooksH(Books num) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO hmc (title, author, price, qty, relatedCourses) VALUES (:title, :author, :price, :qty, :relatedCourses)";
		
		parameters.addValue("title", num.getTitle());
		parameters.addValue("author", num.getAuthor());
		parameters.addValue("price", num.getPrice());
		parameters.addValue("qty", num.getQty());
		parameters.addValue("relatedCourses", num.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public ArrayList<Books> getBooksH() {
		String q = "Select * from hmc";
		ArrayList<Books> bo = (ArrayList<Books>)jdbc.query(q, new BeanPropertyRowMapper<Books>(Books.class));
		return bo;
	}
	
	public Books getStudentsByIdH(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM hmc WHERE id=:id";
		parameters.addValue("id", id);
		ArrayList<Books> students =(ArrayList<Books>)jdbc.query(query, parameters, new BeanPropertyRowMapper<Books>(Books.class));
		if (students.size()>0)
		return students.get(0);
		else
		return null;
	}
	
	public void updateBooksH(Books no) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="UPDATE hmc SET title=:title, author=:author, price=:price, qty=:qty, relatedCourses=:relatedCourses WHERE id=:id";
		parameters.addValue("title", no.getTitle());
		parameters.addValue("author", no.getAuthor());
		parameters.addValue("price",no.getPrice());
		parameters.addValue("qty", no.getQty());
		parameters.addValue("id", no.getId());
		parameters.addValue("relatedCourses", no.getRelatedCourses());

		jdbc.update(query, parameters);
		}
	
	public void deleteBooksH(int id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="DELETE from hmc where id=:id"; 
		parameters.addValue("id",id);
		jdbc.update(query, parameters);
		}
	
	////////////////////////Trafalgar
	public void addBooksT(Books num){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO trafalgar (title, author, price, qty, relatedCourses) VALUES (:title, :author, :price, :qty, :relatedCourses)";
		
		parameters.addValue("title", num.getTitle());
		parameters.addValue("author", num.getAuthor());
		parameters.addValue("price", num.getPrice());
		parameters.addValue("qty", num.getQty());
		parameters.addValue("relatedCourses", num.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public ArrayList<Books> getBooksT() {
		String q = "Select * from trafalgar";
		ArrayList<Books> bo = (ArrayList<Books>)jdbc.query(q, new BeanPropertyRowMapper<Books>(Books.class));
		return bo;
	}
	
	public Books getStudentsByIdT(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM trafalgar WHERE id=:id";
		parameters.addValue("id", id);
		ArrayList<Books> students =(ArrayList<Books>)jdbc.query(query, parameters, new BeanPropertyRowMapper<Books>(Books.class));
		if (students.size()>0)
		return students.get(0);
		else
		return null;
	}
	
	public void updateBooksT(Books no) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="UPDATE trafalgar SET title=:title, author=:author, price=:price, qty=:qty, relatedCourses=:relatedCourses WHERE id=:id";
		parameters.addValue("title", no.getTitle());
		parameters.addValue("author", no.getAuthor());
		parameters.addValue("price",no.getPrice());
		parameters.addValue("qty", no.getQty());
		parameters.addValue("id", no.getId());
		parameters.addValue("relatedCourses", no.getRelatedCourses());

		jdbc.update(query, parameters);
		}
	
	public void deleteBooksT(int id) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="DELETE from trafalgar where id=:id"; 
		parameters.addValue("id",id);
		jdbc.update(query, parameters);
		}
	///////////////////////DUMMYY MATE
	public void dummyR() {
		for(int i=1;i <=6;i++) {
			dummyKar(new Drecord("C++","Jon",i+i,i+i+i,"PBSC"+i*i),
			 new Drecord("C#","Nik",i+i,i+i+i,"JBAC"+i*i),
			 new Drecord("JAVA I","Dev",i+i,i+i+i,"SPDV"+i*i),
			 new Drecord("JAVA II","Dim",i+i,i+i+i,"NDBC"+i*i),
			 new Drecord("JAVA III","Bro",i+i,i+i+i,"BBND"+i*i));
		}
	}
	
	public void dummyRhmc() {
		for(int i=1;i <=6;i++) {
			dummyhmc(new Drecord("C++","Jon",i+i,i+i+i,"PBSC"+i*i),
			 new Drecord("C#","Nik",i+i,i+i+i,"JBAC"+i*i),
			 new Drecord("JAVA I","Dev",i+i,i+i+i,"SPDV"+i*i),
			 new Drecord("JAVA II","Dim",i+i,i+i+i,"NDBC"+i*i),
			 new Drecord("JAVA III","Bro",i+i,i+i+i,"BBND"+i*i));
		}
	}
	
	public void dummyRtra() {
		for(int i=1;i <=6;i++) {
			dummytra(new Drecord("C++","Jon",i+i,i+i+i,"PBSC"+i*i),
			 new Drecord("C#","Nik",i+i,i+i+i,"JBAC"+i*i),
			 new Drecord("JAVA I","Dev",i+i,i+i+i,"SPDV"+i*i),
			 new Drecord("JAVA II","Dim",i+i,i+i+i,"NDBC"+i*i),
			 new Drecord("JAVA III","Bro",i+i,i+i+i,"BBND"+i*i));
		}
	}
	
	
	
	public void dummyKar(Drecord b1,Drecord b2,Drecord b3,Drecord b4,Drecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO davis (title, author, price, qty, relatedCourses)"
					+ " VALUES (:title, :author, :price, :qty, :relatedCourses)";
		  
		  parameters.addValue("title",b1.getTitle());
		  parameters.addValue("author",b1.getAuthor());
		  parameters.addValue("price",b1.getPrice());
		  parameters.addValue("qty",b1.getQty());
		  parameters.addValue("relatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("title",b2.getTitle());
		  parameters.addValue("author",b2.getAuthor());
		  parameters.addValue("price",b2.getPrice());
		  parameters.addValue("qty",b2.getQty());
		  parameters.addValue("relatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b3.getTitle());
		  parameters.addValue("author",b3.getAuthor());
		  parameters.addValue("price",b3.getPrice());
		  parameters.addValue("qty",b3.getQty());
		  parameters.addValue("relatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b4.getTitle());
		  parameters.addValue("author",b4.getAuthor());
		  parameters.addValue("price",b4.getPrice());
		  parameters.addValue("qty",b4.getQty());
		  parameters.addValue("relatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b5.getTitle());
		  parameters.addValue("author",b5.getAuthor());
		  parameters.addValue("price",b5.getPrice());
		  parameters.addValue("qty",b5.getQty());
		  parameters.addValue("relatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	public void dummyhmc(Drecord b1,Drecord b2,Drecord b3,Drecord b4,Drecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO hmc (title, author, price, qty, relatedCourses)"
					+ " VALUES (:title, :author, :price, :qty, :relatedCourses)";
		  
		  parameters.addValue("title",b1.getTitle());
		  parameters.addValue("author",b1.getAuthor());
		  parameters.addValue("price",b1.getPrice());
		  parameters.addValue("qty",b1.getQty());
		  parameters.addValue("relatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("title",b2.getTitle());
		  parameters.addValue("author",b2.getAuthor());
		  parameters.addValue("price",b2.getPrice());
		  parameters.addValue("qty",b2.getQty());
		  parameters.addValue("relatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b3.getTitle());
		  parameters.addValue("author",b3.getAuthor());
		  parameters.addValue("price",b3.getPrice());
		  parameters.addValue("qty",b3.getQty());
		  parameters.addValue("relatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b4.getTitle());
		  parameters.addValue("author",b4.getAuthor());
		  parameters.addValue("price",b4.getPrice());
		  parameters.addValue("qty",b4.getQty());
		  parameters.addValue("relatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b5.getTitle());
		  parameters.addValue("author",b5.getAuthor());
		  parameters.addValue("price",b5.getPrice());
		  parameters.addValue("qty",b5.getQty());
		  parameters.addValue("relatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
	public void dummytra(Drecord b1,Drecord b2,Drecord b3,Drecord b4,Drecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO trafalgar (title, author, price, qty, relatedCourses)"
					+ " VALUES (:title, :author, :price, :qty, :relatedCourses)";
		  
		  parameters.addValue("title",b1.getTitle());
		  parameters.addValue("author",b1.getAuthor());
		  parameters.addValue("price",b1.getPrice());
		  parameters.addValue("qty",b1.getQty());
		  parameters.addValue("relatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("title",b2.getTitle());
		  parameters.addValue("author",b2.getAuthor());
		  parameters.addValue("price",b2.getPrice());
		  parameters.addValue("qty",b2.getQty());
		  parameters.addValue("relatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b3.getTitle());
		  parameters.addValue("author",b3.getAuthor());
		  parameters.addValue("price",b3.getPrice());
		  parameters.addValue("qty",b3.getQty());
		  parameters.addValue("relatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b4.getTitle());
		  parameters.addValue("author",b4.getAuthor());
		  parameters.addValue("price",b4.getPrice());
		  parameters.addValue("qty",b4.getQty());
		  parameters.addValue("relatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("title",b5.getTitle());
		  parameters.addValue("author",b5.getAuthor());
		  parameters.addValue("price",b5.getPrice());
		  parameters.addValue("qty",b5.getQty());
		  parameters.addValue("relatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
	}
	
	////////////////////Search for Davis
	public ArrayList<Books> searchBox(int id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> searchBoxTitle(String title){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where title=:title";
		  parameters.addValue("title",title);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> searchBoxAuthor(String author){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where author=:author";
		  parameters.addValue("author",author);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> searchBoxQty(int qty){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where qty=:qty";
		  parameters.addValue("qty",qty);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> searchBoxRelatedCourses(String relatedCourses){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where relatedCourses=:relatedCourses";
		  parameters.addValue("relatedCourses",relatedCourses);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	
	////////////////////Search For Hmc
	public ArrayList<Books> seBoxH(int id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxTitleH(String title){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where title=:title";
		  parameters.addValue("title",title);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxAuthorH(String author){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where author=:author";
		  parameters.addValue("author",author);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxQtyH(int qty){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where qty=:qty";
		  parameters.addValue("qty",qty);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxRelatedCoursesH(String relatedCourses){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where relatedCourses=:relatedCourses";
		  parameters.addValue("relatedCourses",relatedCourses);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	////////////////////Search For Trafalgar
	public ArrayList<Books> seBoxT(int id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxTitleT(String title){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where title=:title";
		  parameters.addValue("title",title);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxAuthorT(String author){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where author=:author";
		  parameters.addValue("author",author);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxQtyT(int qty){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where qty=:qty";
		  parameters.addValue("qty",qty);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
	public ArrayList<Books> seBoxRelatedCoursesT(String relatedCourses){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where relatedCourses=:relatedCourses";
		  parameters.addValue("relatedCourses",relatedCourses);
	  ArrayList<Books> books=(ArrayList<Books>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Books>(Books.class));  
	  return books;
	}
}

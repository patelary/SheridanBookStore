package ca.sheridancollege.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.Database.DatabaseAccess;
import ca.sheridancollege.bean.Books;

@Controller
public class HomeController {
	
	@Autowired
	public DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome() {
		return "home.html";
	}
	@GetMapping("/davis")
	public String Davis() {
		return "davis.html";
	}
	@GetMapping("/hmc")
	public String HMC() {
		return "hmc.html";
	}
	@GetMapping("/trafalgar")
	public String trafalgar() {
		return "trafalgar.html";
	}
	@GetMapping("/addDavis")
	public String addBooks(@RequestParam String title,
	             @RequestParam String author,
	             @RequestParam double price,
	             @RequestParam int qty,
	             @RequestParam String relatedCourses) {

	Books ca=new Books();
	ca.setTitle(title);
	ca.setAuthor(author);
	ca.setPrice(price);
	ca.setQty(qty);
	ca.setRelatedCourses(relatedCourses);
	da.addBooks(ca);
		return "davis.html";
	}
	@GetMapping("/addHmc")
	public String addBooksHmc(@RequestParam String title,
	             @RequestParam String author,
	             @RequestParam double price,
	             @RequestParam int qty,
	             @RequestParam String relatedCourses) {

	Books ca=new Books();
	ca.setTitle(title);
	ca.setAuthor(author);
	ca.setPrice(price);
	ca.setQty(qty);
	ca.setRelatedCourses(relatedCourses);
	da.addBooksH(ca);
		return "hmc.html";
	}
	@GetMapping("/addTra")
	public String addBooksTra(@RequestParam String title,
	             @RequestParam String author,
	             @RequestParam double price,
	             @RequestParam int qty,
	             @RequestParam String relatedCourses) {

	Books ca=new Books();
	ca.setTitle(title);
	ca.setAuthor(author);
	ca.setPrice(price);
	ca.setQty(qty);
	ca.setRelatedCourses(relatedCourses);
	da.addBooksT(ca);
		return "trafalgar.html";
	}
	
	@GetMapping("/editDavis/{id}")
	public String editLink(Model model, @PathVariable int id){
	Books s = da.getStudentsById(id);
	model.addAttribute("davis",s);
	return "DavisModify.html";
	}
	@GetMapping("/editHmc/{id}")
	public String editLinkH(Model model, @PathVariable int id){
	Books s = da.getStudentsByIdH(id);
	model.addAttribute("hm",s);
	return "HmcModify.html";
	}
	@GetMapping("/editTra/{id}")
	public String editLinkT(Model model, @PathVariable int id){
	Books s = da.getStudentsByIdT(id);
	model.addAttribute("tr",s);
	return "TrafalgarModify.html";
	}
	
	@GetMapping("/Dmodify")
	public String modifyBooks(@RequestParam String title,
								@RequestParam String author,
								@RequestParam double price,
								@RequestParam int qty,
								@RequestParam int id,
								@RequestParam String relatedCourses,
								Model model) {
		
	Books c2 = new Books();
	c2.setTitle(title);
	c2.setAuthor(author);
	c2.setPrice(price);
	c2.setQty(qty);
	c2.setId(id);
	c2.setRelatedCourses(relatedCourses);
	da.updateBooks(c2);
	model.addAttribute("vp", da.getBooks());
	model.addAttribute("hm", da.getBooksH());
	model.addAttribute("tr", da.getBooksT());
	return "viewBooks.html";
	}
	
	@GetMapping("/Hmodify")
	public String modifyBooksH(@RequestParam String title,
								@RequestParam String author,
								@RequestParam double price,
								@RequestParam int qty,
								@RequestParam int id,
								@RequestParam String relatedCourses,
								Model model) {
		
	Books c2 = new Books();
	c2.setTitle(title);
	c2.setAuthor(author);
	c2.setPrice(price);
	c2.setQty(qty);
	c2.setId(id);
	c2.setRelatedCourses(relatedCourses);
	da.updateBooksH(c2);
	model.addAttribute("vp", da.getBooks());
	model.addAttribute("hm", da.getBooksH());
	model.addAttribute("tr", da.getBooksT());
	return "viewBooks.html";
	}
	@GetMapping("/Tmodify")
	public String modifyBooksT(@RequestParam String title,
								@RequestParam String author,
								@RequestParam double price,
								@RequestParam int qty,
								@RequestParam int id,
								@RequestParam String relatedCourses,
								Model model) {
		
	Books c2 = new Books();
	c2.setTitle(title);
	c2.setAuthor(author);
	c2.setPrice(price);
	c2.setQty(qty);
	c2.setId(id);
	c2.setRelatedCourses(relatedCourses);
	da.updateBooksT(c2);
	model.addAttribute("vp", da.getBooks());
	model.addAttribute("hm", da.getBooksH());
	model.addAttribute("tr", da.getBooksT());
	return "viewBooks.html";
	}
	
	@GetMapping("/deleteDavis/{id}")
	public String deleteLink(Model model, @PathVariable int id) {
		da.deleteBooks(id);
		model.addAttribute("vp", da.getBooks());
		model.addAttribute("tr", da.getBooksT());
		model.addAttribute("hm", da.getBooksH());
		return "viewBooks.html";
	}
	@GetMapping("/deleteHmc/{id}")
	public String deleteLinkH(Model model, @PathVariable int id) {
		da.deleteBooksH(id);
		model.addAttribute("vp", da.getBooks());
		model.addAttribute("hm", da.getBooksH());
		model.addAttribute("tr", da.getBooksT());
		return "viewBooks.html";
	}
	@GetMapping("/deleteTra/{id}")
	public String deleteLinkT(Model model, @PathVariable int id) {
		da.deleteBooksT(id);
		model.addAttribute("vp", da.getBooks());
		model.addAttribute("hm", da.getBooksH());
		model.addAttribute("tr", da.getBooksT());
		return "viewBooks.html";
	}
	@GetMapping("/view")
	public String viewContact(Model model){
		model.addAttribute("vp", da.getBooks());
		model.addAttribute("hm", da.getBooksH());
		model.addAttribute("tr", da.getBooksT());
		return "viewBooks.html";
}
	@GetMapping("/dummD")
	public String generateD(Model model) {
	da.dummyR();
	      model.addAttribute("DummyD", da.getBooks());
	      model.addAttribute("DummyH", da.getBooksH());
	      model.addAttribute("DummyT", da.getBooksT());
 
		return "dummyD.html";
	}
	
	@GetMapping("/dummH")
	public String generateDhmc(Model model) {
	da.dummyRhmc();
		model.addAttribute("DummyD", da.getBooks());
		model.addAttribute("DummyH", da.getBooksH());
		model.addAttribute("DummyT", da.getBooksT());
 
		return "dummyH.html";
	}
	
	@GetMapping("dummT")
	public String generateDtra(Model model) {
	da.dummyRtra();
		model.addAttribute("DummyD", da.getBooks());
		model.addAttribute("DummyH", da.getBooksH());
		model.addAttribute("DummyT", da.getBooksT());
		return "dummyT.html";
	}
	////////Search for davis 
	@GetMapping("/searchD")
	public String Search() {
		return "searchD.html";
	}
	@GetMapping("/search.id")
	public String goSearch(@RequestParam int id, Model model) {
		model.addAttribute("search", da.searchBox(id));
		return "searchD.html";
	}
	@GetMapping("/search.title")
	public String goTitle(@RequestParam String title, Model model) {
		model.addAttribute("search", da.searchBoxTitle(title));
		return "searchD.html";
	}
	@GetMapping("/search.author")
	public String goAuthor(@RequestParam String author, Model model) {
		model.addAttribute("search", da.searchBoxAuthor(author));
		return "searchD.html";
	}
	@GetMapping("/search.qty")
	public String goQty(@RequestParam int qty, Model model) {
		model.addAttribute("search", da.searchBoxQty(qty));
		return "searchD.html";
	}
	@GetMapping("/search.relatedCourses")
	public String goRelatedCourses(@RequestParam String relatedCourses, Model model) {
		model.addAttribute("search", da.searchBoxRelatedCourses(relatedCourses));
		return "searchD.html";
	}
	////////////////Search for Hmc
	@GetMapping("/searchH")
	public String SearchH() {
		return "searchH.html";
	}
	@GetMapping("/searchIdH")
	public String goSearchH(@RequestParam int id, Model model) {
		model.addAttribute("search", da.seBoxH(id));
		return "searchH.html";
	}
	@GetMapping("/searchTitleH")
	public String goTitleH(@RequestParam String title, Model model) {
		model.addAttribute("search", da.seBoxTitleH(title));
		return "searchH.html";
	}
	@GetMapping("/searchAuthorH")
	public String goAuthorH(@RequestParam String author, Model model) {
		model.addAttribute("search", da.seBoxAuthorH(author));
		return "searchH.html";
	}
	@GetMapping("/searchQtyH")
	public String goQtyH(@RequestParam int qty, Model model) {
		model.addAttribute("search", da.seBoxQtyH(qty));
		return "searchH.html";
	}
	@GetMapping("/searchRelatedCoursesH")
	public String goRelatedCoursesH(@RequestParam String relatedCourses, Model model) {
		model.addAttribute("search", da.seBoxRelatedCoursesH(relatedCourses));
		return "searchH.html";
	}
	///////////////Search for Trafalgar
	@GetMapping("/searchT")
	public String SearchT() {
		return "searchT.html";
	}
	@GetMapping("/searchIdT")
	public String goSearchT(@RequestParam int id, Model model) {
		model.addAttribute("search", da.seBoxT(id));
		return "searchT.html";
	}
	@GetMapping("/searchTitleT")
	public String goTitleT(@RequestParam String title, Model model) {
		model.addAttribute("search", da.seBoxTitleT(title));
		return "searchT.html";
	}
	@GetMapping("/searchAuthorT")
	public String goAuthorT(@RequestParam String author, Model model) {
		model.addAttribute("search", da.seBoxAuthorT(author));
		return "searchT.html";
	}
	@GetMapping("/searchQtyT")
	public String goQtyT(@RequestParam int qty, Model model) {
		model.addAttribute("search", da.seBoxQtyT(qty));
		return "searchT.html";
	}
	@GetMapping("/searchRelatedCoursesT")
	public String goRelatedCoursesT(@RequestParam String relatedCourses, Model model) {
		model.addAttribute("search", da.seBoxRelatedCoursesT(relatedCourses));
		return "searchT.html";
	}
}

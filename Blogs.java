package tourproject.Bean;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Blogs {
	private int id;
	private String blogTitle;
	private String blogDescription;
	private LocalDateTime time;
	private Archive archive;
	private User user;
	private int date;
	private Month month;
	private int year;
	private ArrayList<Comment> comments;
	
	
	public Blogs(String blogTitle, String blogDescription, LocalDateTime time, Archive archive, User user, int date,
			Month month, int year, ArrayList<Comment> comments) {
		super();
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.time = time;
		this.archive = archive;
		this.user = user;
		this.date = date;
		this.month = month;
		this.year = year;
		this.comments = comments;
	}

	public Blogs(int id, String blogTitle, String blogDescription, LocalDateTime time, Archive archive, User user,
			int date, Month month, int year, ArrayList<Comment> comments) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.time = time;
		this.archive = archive;
		this.user = user;
		this.date = date;
		this.month = month;
		this.year = year;
		this.comments = comments;
	}

	public Blogs(String blogTitle, String blogDescription, LocalDateTime time, Archive archive, User user) {
		super();
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.time = time;
		this.archive = archive;
		this.user = user;
	}

	public Blogs(int id, String blogTitle, String blogDescription, LocalDateTime time, Archive archive, User user) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.time = time;
		this.archive = archive;
		this.user = user;
	}

	public Blogs(int id, String blogTitle, String blogDescription, LocalDateTime time) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.time = time;
	}
	
	public Blogs(String blogTitle, String blogDescription, LocalDateTime time) {
		super();
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
		this.time = time;
	}
	
	
	public Blogs(int id, String blogTitle, String blogDescription) {
		super();
		this.id = id;
		this.blogTitle = blogTitle;
		this.blogDescription = blogDescription;
	}
	

	public Blogs(int id) {
		super();
		this.id = id;
	}

	public Blogs() {
		super();
	}
	
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month2) {
		this.month = month2;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	
	

}

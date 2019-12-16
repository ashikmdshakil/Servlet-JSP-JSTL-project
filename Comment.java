package tourproject.Bean;

public class Comment {
	private int commentId;
	private String comment;
	private Blogs blog;
	private User user;
	
	public Comment(int commentId, String comment, Blogs blog, User user) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.blog = blog;
		this.user = user;
	}
	
	public Comment(String comment, Blogs blog, User user) {
		super();
		this.comment = comment;
		this.blog = blog;
		this.user = user;
	}

	public Comment(int commentId, String comment, Blogs blog) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.blog = blog;
	}
	public Comment(String comment, Blogs blog) {
		super();
		this.comment = comment;
		this.blog = blog;
	}
	
	
	public Comment(String comment, User user) {
		super();
		this.comment = comment;
		this.user = user;
	}

	public Comment() {
		super();
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Blogs getBlog() {
		return blog;
	}
	public void setBlog(Blogs blog) {
		this.blog = blog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}

package tourproject.Repositories;

import java.sql.SQLException;
import java.util.ArrayList;

import tourproject.Bean.Blogs;

public interface IBlogs {
	public ArrayList<Blogs> getAllBlogs();
	public void postBlogs(Blogs blog);
	public ArrayList<Blogs> getBlogs(int id);
	public Blogs getForEdit(int id);
	public void edit(Blogs blog);
	public void deleteBlogss(int id);
	public ArrayList<Blogs> getMyBlogs(int id);
	public void deleteAllBlogs(int id);
	public ArrayList<Blogs> getAllBlogsWithComments();
}

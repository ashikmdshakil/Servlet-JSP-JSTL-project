package tourproject.Repositories;

import java.util.ArrayList;
import java.util.List;

import tourproject.Bean.Archive;
import tourproject.Bean.Blogs;

public interface IArchive {
	public void createArchive(Archive archive);
	public ArrayList<Archive> getArchives();
	public Archive getForEdit(int id);
	public void edit(Archive archive);
	public void deleteArchives(int id);
	public Archive getArchive(int id);
}

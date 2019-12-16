package tourproject.Bean;

import java.time.LocalDateTime;

public class Archive {
	private int id;
	private String title;
	private String description;
	private LocalDateTime time;
	public Archive(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	public Archive(int id, String title, String description, LocalDateTime time) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.time = time;
	}

	public Archive(int id) {
		super();
		this.id = id;
	}

	public Archive(String title, String description, LocalDateTime time) {
		super();
		this.title = title;
		this.description = description;
		this.time = time;
	}

	public Archive(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	public Archive() {
		super();
	}
	
	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}

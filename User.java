package tourproject.Bean;

public class User {
	private int id;
	private String name;
	private String mail;
	private String phone;
	private String password;
	private String role;
	public User(int id, String name, String mail, String phone, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	public User(String name, String mail, String phone, String password, String role) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	
	
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User(int id) {
		super();
		this.id = id;
	}
	
	
	
	public User(int id, String name, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	/*public User(String mail) {
		super();
		this.mail = mail;
	}*/
	public User(String name, String password, String role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public User(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}

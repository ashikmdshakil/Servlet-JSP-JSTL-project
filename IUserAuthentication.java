package tourproject.Repositories;

import tourproject.Bean.User;

public interface IUserAuthentication {
	public void signUp(User user);
	public boolean validate(User user);
	public User getSession(String mail);
	
}

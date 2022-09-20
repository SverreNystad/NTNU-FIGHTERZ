package fightinggame.core;

/**
 * The User represents a user. It will have all info about the logged in user. 
 */
public class User {
	private UserData userData;
	private UserId userId;

	public User(String id, String password) throws IllegalArgumentException{
		// TODO: Make constructor more robust with exceptions and checking for edge cases.
		this.userData = new UserData(password);
		this.userId = new UserId(id);
	}

	public boolean equals(User u) {
		return this.getUserId().equals(u.getUserId());
	}

	public UserId getUserId() {
		return this.userId;
	}

	public UserData getUserData() {
		return this.userData;
	}
	
	public String getUserName() {
		return this.getUserId().getUserId();
	}
	
	public String getPassword() {
		return this.getUserData().getPassword();
	}

	/**
	 * Changes UserId to new userId.
	 * If {@code userId} cant be constructed with userId, then does not chage userId.
	 * @param userId  the string to try to change field userId.
	 */
	public void changeUserId(String userId) {
		try {
			UserId id = new UserId(userId);
			this.setUserId(id);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * Changes UserData to new userData.
	 * If {@code userData} cant be constructed with userData, then does not chage userData.
	 * @param userData  the string to try to change field userData.
	 */
	public void changeUserData(String userData) {
		try {
			UserData data = new UserData(userData);
			this.setUserData(userData);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void setUserId(UserId userId) {
		this.userId = userId;
	}

	private void setUserData(UserData userData) {
		this.userData = userData;
	}
}

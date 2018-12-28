package application;

public class UserTO {
	private String email;
	private String playground;
	private String username;
	private String avatar;
	private String role;
	private long points;

	public UserTO() {
		this("","","","");
	}

	public UserTO(String email, String username, String avatar, String role) {
		super();
		setEmail(email);
		this.playground = "2019a.talin";
		setUsername(username);
		setAvatar(avatar);
		setRole(role);
		this.points = 0;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlayground() {
		return playground;
	}

	public void setPlayground(String playground) {
		this.playground = playground;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "[email = " + email + ", playground = " + playground + ", username= " + username + ", avatar = " + avatar
				+ ", role = " + role + ", points = " + points + "]";
	}

}

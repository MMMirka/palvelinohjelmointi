package MirkaM.TaskList.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class SignupForm {
    @NotEmpty
    @Size(min=4, max=10)
    private String username = "";
    
	@NotEmpty
	private String email = "";
	
	@NotEmpty
	private String emailCheck = "";

    @NotEmpty
    @Size(min=4, max=10)
    private String password = "";

    @NotEmpty
    @Size(min=4, max=10)
    private String passwordCheck = "";

    @NotEmpty
    private String role = "USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailCheck() {
		return emailCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}

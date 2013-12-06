package comp.cleniduarte.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "conta")
public class Account implements ISimplesKeyBean {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "cd_conta")
	private Long id;
	
	@Column(name = "nm_user", nullable = false, length = 50)
	private String name;
	
	@Column(name = "email_user", length = 50)
	private String email;
	
	@Column(name = "login_user", nullable = false, length = 50)
	private String login;
	
	@Column(name = "password_user", nullable = false, length = 50)
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "cd_user_type", insertable=false, updatable=false, nullable=false)
	private UserType roles;
	
	
	public Account() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getRoles() {
		return roles;
	}
	public void setRoles(UserType roles) {
		this.roles = roles;
	}
	
}

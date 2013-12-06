package comp.cleniduarte.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_type")
public class UserType implements ISimplesKeyBean {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cd_user_type", nullable = false)
	private Long id;
	
	@Column(name = "ds_user_type", nullable = false, length = 50)
	private String type;

	public UserType() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}

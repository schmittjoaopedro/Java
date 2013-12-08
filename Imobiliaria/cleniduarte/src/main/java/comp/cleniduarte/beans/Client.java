package comp.cleniduarte.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Client implements ISimplesKeyBean {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "cd_cliente", nullable = false)
	private Long id;
	
	@Column(name = "nome_cliente", nullable = false, length = 80)
	private String name;
	
	@Column(name = "cpf_cnpj")
	private String cpfOrCnpj;
	
	@Column(name = "email", length = 60)
	private String mail;
	
	@Column(name = "telefone", nullable = false)
	private Integer telephone;
	
	@Column(name = "data_nascimento")
	private Date dateBirth;
	
	@Column(name = "tel_celular")
	private Integer telephoneMobile;
	
	@Column(name = "tel_outro")
	private Integer telephoneOther;
	
	public Client() {}
	
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
	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}
	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	public Date getDateNascimento() {
		return dateBirth;
	}
	public void setDateNascimento(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	public Integer getTelephoneMobile() {
		return telephoneMobile;
	}
	public void setTelephoneMobile(Integer telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}
	public Integer getTelephoneOther() {
		return telephoneOther;
	}
	public void setTelephoneOther(Integer telephoneOther) {
		this.telephoneOther = telephoneOther;
	}
	
}

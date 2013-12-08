package comp.cleniduarte.beans;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "imovel")
public class Still implements ISimplesKeyBean {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "cd_imovel", nullable = false)
	private Long id;
	
	@Column(name = "descricao", nullable = false, length=500)
	private String description;
	
	@Column(name = "tipo_operacao", columnDefinition = "enum('AnuncioVenda','AnuncioLocacao','ProcuraVenda','ProcuraLocacao')")
	@Enumerated(EnumType.STRING)
	private ETypeOperation typeOperation;
	
	@Column(name = "tipo_imovel", columnDefinition = "enum('Apartamento','Casa','Terreno','Comercial','Rural')")
	@Enumerated(EnumType.STRING)
	private ETipoImovel typeStill;
	
	@Column(name = "area_total")
	private Integer totalArea;
	
	@Column(name = "area_util")
	private Integer utilArea;
	
	@Column(name = "nr_vagas_garagen")
	private Integer numberGaragePlaces;
	
	@Column(name = "nr_quartos")
	private Integer numberBedroom; //quarto
	
	@Column(name = "nr_banheiros")
	private Integer numberBethroom; //banheiro
	
	@Column(name = "tem_suite")
	private Boolean hasSuite;
	
	@Column(name = "tem_churrasqueira")
	private Boolean hasBarbecue;
	
	@Column(name = "tem_ar_condicionado")
	private Boolean hasArConditioning;
	
	@Column(name = "tem_academia")
	private Boolean hasAcademy;
	
	@Column(name = "tem_armario_embutido")
	private Boolean hasCupboard; //armario embutido
	
	@Column(name = "tem_sacada_varanda")
	private Boolean hasBalcony; //varanda
	
	@Column(name = "tem_piscina")
	private Boolean hasPool;
	
	@Column(name = "tem_porteiro")
	private Boolean hasPorter;
	
	@Column(name = "tem_salao_festas")
	private Boolean hasBallroomParty; //salao festas
	
	@Column(name = "tem_aposentos_empregada")
	private Boolean hasRoomMaid;
	
	@Column(name = "valor_mensal_condominio")
	private Double costMonthlyCondominium;
	
	@Column(name = "valor_anual_iptu")
	private Double costAnnualIptu;
	
	@Column(name = "valor")
	private Double value;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "data_cadastro", nullable = false)
	private Date registerDate;
	
	@Column(name = "data_ultima_atualizacao")
	private Date lastUpdateDate;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "cidade")
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "cd_estado", insertable = false, updatable = false)
	private State state;
	
	@Column(name = "bairro")
	private String neighborhood;
	
	@Column(name = "rua")
	private String street;
	
	@Column(name = "nr")
	private String number;
	
	@Column(name = "complemento")
	private String complement;
	
	@ManyToOne
	@JoinColumn(name = "cd_cliente", insertable = false, updatable = false)
	private Client client;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "cd_images", insertable = false, updatable = false)
	private List<Images> images;
	
	public Still() {}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ETypeOperation getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(ETypeOperation typeOperation) {
		this.typeOperation = typeOperation;
	}

	public ETipoImovel getTypeStill() {
		return typeStill;
	}

	public void setTypeStill(ETipoImovel typeStill) {
		this.typeStill = typeStill;
	}

	public Integer getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Integer totalArea) {
		this.totalArea = totalArea;
	}

	public Integer getUtilArea() {
		return utilArea;
	}

	public void setUtilArea(Integer utilArea) {
		this.utilArea = utilArea;
	}

	public Integer getNumberGaragePlaces() {
		return numberGaragePlaces;
	}

	public void setNumberGaragePlaces(Integer numberGaragePlaces) {
		this.numberGaragePlaces = numberGaragePlaces;
	}

	public Integer getNumberBedroom() {
		return numberBedroom;
	}

	public void setNumberBedroom(Integer numberBedroom) {
		this.numberBedroom = numberBedroom;
	}

	public Integer getNumberBethroom() {
		return numberBethroom;
	}

	public void setNumberBethroom(Integer numberBethroom) {
		this.numberBethroom = numberBethroom;
	}

	public Boolean getHasSuite() {
		return hasSuite;
	}

	public void setHasSuite(Boolean hasSuite) {
		this.hasSuite = hasSuite;
	}

	public Boolean getHasBarbecue() {
		return hasBarbecue;
	}

	public void setHasBarbecue(Boolean hasBarbecue) {
		this.hasBarbecue = hasBarbecue;
	}

	public Boolean getHasArConditioning() {
		return hasArConditioning;
	}

	public void setHasArConditioning(Boolean hasArConditioning) {
		this.hasArConditioning = hasArConditioning;
	}

	public Boolean getHasAcademy() {
		return hasAcademy;
	}

	public void setHasAcademy(Boolean hasAcademy) {
		this.hasAcademy = hasAcademy;
	}

	public Boolean getHasCupboard() {
		return hasCupboard;
	}

	public void setHasCupboard(Boolean hasCupboard) {
		this.hasCupboard = hasCupboard;
	}

	public Boolean getHasBalcony() {
		return hasBalcony;
	}

	public void setHasBalcony(Boolean hasBalcony) {
		this.hasBalcony = hasBalcony;
	}

	public Boolean getHasPool() {
		return hasPool;
	}

	public void setHasPool(Boolean hasPool) {
		this.hasPool = hasPool;
	}

	public Boolean getHasPorter() {
		return hasPorter;
	}

	public void setHasPorter(Boolean hasPorter) {
		this.hasPorter = hasPorter;
	}

	public Boolean getHasBallroomParty() {
		return hasBallroomParty;
	}

	public void setHasBallroomParty(Boolean hasBallroomParty) {
		this.hasBallroomParty = hasBallroomParty;
	}

	public Boolean getHasRoomMaid() {
		return hasRoomMaid;
	}

	public void setHasRoomMaid(Boolean hasRoomMaid) {
		this.hasRoomMaid = hasRoomMaid;
	}

	public Double getCostMonthlyCondominium() {
		return costMonthlyCondominium;
	}

	public void setCostMonthlyCondominium(Double costMonthlyCondominium) {
		this.costMonthlyCondominium = costMonthlyCondominium;
	}

	public Double getCostAnnualIptu() {
		return costAnnualIptu;
	}

	public void setCostAnnualIptu(Double costAnnualIptu) {
		this.costAnnualIptu = costAnnualIptu;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}

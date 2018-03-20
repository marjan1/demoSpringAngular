package nl.datavisual.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the organisation_units database table.
 * 
 */
@Entity
@Table(name = "organisation_units")
@NamedQuery(name = "OrganisationUnit.findAll", query = "SELECT o FROM OrganisationUnit o")
public class OrganisationUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_org_units")
	private int idOrgUnits;

	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name = "efective_year")
	private Date efectiveYear;

	private String name;

	//bi-directional many-to-one association to OrganisationSubunitDTO
	@OneToMany(mappedBy = "organisationUnit")
	private List<OrganisationSubunit> organisationSubunits;

	//bi-directional many-to-one association to CompanyDTO
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public OrganisationUnit() {
	}

	public int getIdOrgUnits() {
		return this.idOrgUnits;
	}

	public void setIdOrgUnits(int idOrgUnits) {
		this.idOrgUnits = idOrgUnits;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEfectiveYear() {
		return this.efectiveYear;
	}

	public void setEfectiveYear(Date efectiveYear) {
		this.efectiveYear = efectiveYear;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrganisationSubunit> getOrganisationSubunits() {
		return this.organisationSubunits;
	}

	public void setOrganisationSubunits(List<OrganisationSubunit> organisationSubunits) {
		this.organisationSubunits = organisationSubunits;
	}

	public OrganisationSubunit addOrganisationSubunit(OrganisationSubunit organisationSubunit) {
		getOrganisationSubunits().add(organisationSubunit);
		organisationSubunit.setOrganisationUnit(this);

		return organisationSubunit;
	}

	public OrganisationSubunit removeOrganisationSubunit(OrganisationSubunit organisationSubunit) {
		getOrganisationSubunits().remove(organisationSubunit);
		organisationSubunit.setOrganisationUnit(null);

		return organisationSubunit;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
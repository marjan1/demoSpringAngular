package nl.datavisual.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the organisation_subunit database table.
 * 
 */
@Entity
@Table(name = "organisation_subunit")
@NamedQuery(name = "OrganisationSubunit.findAll", query = "SELECT o FROM OrganisationSubunit o")
public class OrganisationSubunit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_org_subunit")
	private int idOrgSubunit;

	private String code;

	private byte folder;

	private String name;

	@Column(name = "retentation_yesrs")
	private byte retentationYesrs;

	//bi-directional many-to-one association to DocumentDTO
	@OneToMany(mappedBy = "organisationSubunit")
	private List<Document> documents;

	//bi-directional many-to-one association to OrganisationUnitDTO
	@ManyToOne
	@JoinColumn(name = "org_unit_id")
	private OrganisationUnit organisationUnit;

	public OrganisationSubunit() {
	}

	public int getIdOrgSubunit() {
		return this.idOrgSubunit;
	}

	public void setIdOrgSubunit(int idOrgSubunit) {
		this.idOrgSubunit = idOrgSubunit;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte getFolder() {
		return this.folder;
	}

	public void setFolder(byte folder) {
		this.folder = folder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getRetentationYesrs() {
		return this.retentationYesrs;
	}

	public void setRetentationYesrs(byte retentationYesrs) {
		this.retentationYesrs = retentationYesrs;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setOrganisationSubunit(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setOrganisationSubunit(null);

		return document;
	}

	public OrganisationUnit getOrganisationUnit() {
		return this.organisationUnit;
	}

	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
	}

}
package nl.datavisual.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the companies database table.
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_companies")
    private int idCompanies;

    private String address;

    @Column(name = "company_name")
    private String companyName;

    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Lob
    private byte[] logo;

    @Column(name = "number_of_users")
    private int numberOfUsers;

    private String phone;

    @Column(name = "status_code")
    private int statusCode;

    //bi-directional many-to-one association to OrganisationUnitDTO
    @OneToMany(mappedBy = "company")
    private List<OrganisationUnit> organisationUnits;

    //bi-directional many-to-one association to User
    @OneToMany(mappedBy = "company")
    private List<User> users;

    public Company() {
    }

    public int getIdCompanies() {
        return this.idCompanies;
    }

    public void setIdCompanies(int idCompanies) {
        this.idCompanies = idCompanies;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public byte[] getLogo() {
        return logo;
    }



    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public int getNumberOfUsers() {
        return this.numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<OrganisationUnit> getOrganisationUnits() {
        return this.organisationUnits;
    }

    public void setOrganisationUnits(List<OrganisationUnit> organisationUnits) {
        this.organisationUnits = organisationUnits;
    }

    public OrganisationUnit addOrganisationUnit(OrganisationUnit organisationUnit) {
        getOrganisationUnits().add(organisationUnit);
        organisationUnit.setCompany(this);

        return organisationUnit;
    }

    public OrganisationUnit removeOrganisationUnit(OrganisationUnit organisationUnit) {
        getOrganisationUnits().remove(organisationUnit);
        organisationUnit.setCompany(null);

        return organisationUnit;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User addUser(User user) {
        getUsers().add(user);
        user.setCompany(this);

        return user;
    }

    public User removeUser(User user) {
        getUsers().remove(user);
        user.setCompany(null);

        return user;
    }

}
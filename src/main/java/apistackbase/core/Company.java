package apistackbase.core;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 64)
    private String name;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private CompanyProfile profile;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("age DESC")
    @JoinColumn(name = "COMPANY_IDaaaa")
    private Set<Employee> employees;

    private Long cost;

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public CompanyProfile getProfile() {
        return profile;
    }

    public void setProfile(CompanyProfile profile) {
        this.profile = profile;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(Long id, String name, CompanyProfile profile) {
        this.id = id;
        this.name = name;
        this.profile = profile;
    }
}

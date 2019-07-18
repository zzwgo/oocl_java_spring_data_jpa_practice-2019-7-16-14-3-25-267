package apistackbase.core;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class CompanyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer registeredCapital;

    @NotNull
    @Column(length = 64)
    private String certId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public CompanyProfile(Long id, Integer registeredCapital, String certId) {
        this.id = id;
        this.registeredCapital = registeredCapital;
        this.certId = certId;
    }

    public CompanyProfile() {
    }
}

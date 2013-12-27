package com.ensi.vetokit.dto;


import java.io.Serializable;

public class Laboratory implements Serializable {

    private int labId;
    private String raisonSociale;
    private String email;
    private String telephone;
    private String mobile;
    private String fax;
    private int adresseId;

    public Laboratory() {

    }

    public int getLabId() {
        return labId;
    }

    public void setLabId(int labId) {
        this.labId = labId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laboratory that = (Laboratory) o;

        if (adresseId != that.adresseId) return false;
        if (labId != that.labId) return false;
        if (!email.equals(that.email)) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (!raisonSociale.equals(that.raisonSociale)) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = labId;
        result = 31 * result + raisonSociale.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + adresseId;
        return result;
    }
}

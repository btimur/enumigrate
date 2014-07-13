package kz.arta.ext.migrate.model;

import javax.persistence.*;

/**
 * Created by timur on 12/07/2014 12:17.
 */
@Entity
@Table(name = "librarians", schema = "", catalog = "books")
public class LibrariansEntity {
    private Integer id;
    private String name;
    private String password;
    private Byte current;
    private String userPc;
    private String cats;
    private String politika;
    private Byte userOff;
    private String siglas;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Current")
    public Byte getCurrent() {
        return current;
    }

    public void setCurrent(Byte current) {
        this.current = current;
    }

    @Basic
    @Column(name = "UserPC")
    public String getUserPc() {
        return userPc;
    }

    public void setUserPc(String userPc) {
        this.userPc = userPc;
    }

    @Basic
    @Column(name = "Cats")
    public String getCats() {
        return cats;
    }

    public void setCats(String cats) {
        this.cats = cats;
    }

    @Basic
    @Column(name = "Politika")
    public String getPolitika() {
        return politika;
    }

    public void setPolitika(String politika) {
        this.politika = politika;
    }

    @Basic
    @Column(name = "UserOff")
    public Byte getUserOff() {
        return userOff;
    }

    public void setUserOff(Byte userOff) {
        this.userOff = userOff;
    }

    @Basic
    @Column(name = "Siglas")
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibrariansEntity that = (LibrariansEntity) o;

        if (cats != null ? !cats.equals(that.cats) : that.cats != null) return false;
        if (current != null ? !current.equals(that.current) : that.current != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (politika != null ? !politika.equals(that.politika) : that.politika != null) return false;
        if (siglas != null ? !siglas.equals(that.siglas) : that.siglas != null) return false;
        if (userOff != null ? !userOff.equals(that.userOff) : that.userOff != null) return false;
        if (userPc != null ? !userPc.equals(that.userPc) : that.userPc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (current != null ? current.hashCode() : 0);
        result = 31 * result + (userPc != null ? userPc.hashCode() : 0);
        result = 31 * result + (cats != null ? cats.hashCode() : 0);
        result = 31 * result + (politika != null ? politika.hashCode() : 0);
        result = 31 * result + (userOff != null ? userOff.hashCode() : 0);
        result = 31 * result + (siglas != null ? siglas.hashCode() : 0);
        return result;
    }
}

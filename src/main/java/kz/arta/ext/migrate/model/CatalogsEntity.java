package kz.arta.ext.migrate.model;

import javax.persistence.*;

/**
 * Created by timur on 09/07/2014 14:13.
 */
@Entity
@Table(name = "catalogs", schema = "", catalog = "books")
public class CatalogsEntity {
    private Integer idCatalog;
    private String name;
    private String nLang;
    private Integer idInvBook;
    private Integer idLabel;
    private Integer booksCnt;
    private Integer copySum;
    private Integer idAut;

    @Id
    @Column(name = "ID_Catalog")
    public Integer getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
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
    @Column(name = "NLang")
    public String getnLang() {
        return nLang;
    }

    public void setnLang(String nLang) {
        this.nLang = nLang;
    }

    @Basic
    @Column(name = "ID_InvBook")
    public Integer getIdInvBook() {
        return idInvBook;
    }

    public void setIdInvBook(Integer idInvBook) {
        this.idInvBook = idInvBook;
    }

    @Basic
    @Column(name = "ID_Label")
    public Integer getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(Integer idLabel) {
        this.idLabel = idLabel;
    }

    @Basic
    @Column(name = "BooksCnt")
    public Integer getBooksCnt() {
        return booksCnt;
    }

    public void setBooksCnt(Integer booksCnt) {
        this.booksCnt = booksCnt;
    }

    @Basic
    @Column(name = "CopySum")
    public Integer getCopySum() {
        return copySum;
    }

    public void setCopySum(Integer copySum) {
        this.copySum = copySum;
    }

    @Basic
    @Column(name = "ID_Aut")
    public Integer getIdAut() {
        return idAut;
    }

    public void setIdAut(Integer idAut) {
        this.idAut = idAut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatalogsEntity that = (CatalogsEntity) o;

        if (booksCnt != null ? !booksCnt.equals(that.booksCnt) : that.booksCnt != null) return false;
        if (copySum != null ? !copySum.equals(that.copySum) : that.copySum != null) return false;
        if (idAut != null ? !idAut.equals(that.idAut) : that.idAut != null) return false;
        if (idCatalog != null ? !idCatalog.equals(that.idCatalog) : that.idCatalog != null) return false;
        if (idInvBook != null ? !idInvBook.equals(that.idInvBook) : that.idInvBook != null) return false;
        if (idLabel != null ? !idLabel.equals(that.idLabel) : that.idLabel != null) return false;
        if (nLang != null ? !nLang.equals(that.nLang) : that.nLang != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCatalog != null ? idCatalog.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nLang != null ? nLang.hashCode() : 0);
        result = 31 * result + (idInvBook != null ? idInvBook.hashCode() : 0);
        result = 31 * result + (idLabel != null ? idLabel.hashCode() : 0);
        result = 31 * result + (booksCnt != null ? booksCnt.hashCode() : 0);
        result = 31 * result + (copySum != null ? copySum.hashCode() : 0);
        result = 31 * result + (idAut != null ? idAut.hashCode() : 0);
        return result;
    }
}

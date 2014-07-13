package kz.arta.ext.migrate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by timur on 09/07/2014 14:13.
 */
@Entity
@javax.persistence.Table(name = "books", schema = "", catalog = "books")
public class BooksEntity {
    private Integer idBook;

    @Id
    @javax.persistence.Column(name = "ID_Book")
    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    private String desc1;

    @Basic
    @javax.persistence.Column(name = "Desc_1")
    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    private String desc21;

    @Basic
    @javax.persistence.Column(name = "Desc_21")
    public String getDesc21() {
        return desc21;
    }

    public void setDesc21(String desc21) {
        this.desc21 = desc21;
    }

    private String desc29;

    @Basic
    @javax.persistence.Column(name = "Desc_29")
    public String getDesc29() {
        return desc29;
    }

    public void setDesc29(String desc29) {
        this.desc29 = desc29;
    }

    private Short desc31;

    @Basic
    @javax.persistence.Column(name = "Desc_31")
    public Short getDesc31() {
        return desc31;
    }

    public void setDesc31(Short desc31) {
        this.desc31 = desc31;
    }

    private Integer idCatalog;

    @Basic
    @javax.persistence.Column(name = "ID_Catalog")
    public Integer getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    private Integer idLabel;

    @Basic
    @javax.persistence.Column(name = "ID_Label")
    public Integer getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(Integer idLabel) {
        this.idLabel = idLabel;
    }

    private String nLabel;

    @Basic
    @javax.persistence.Column(name = "N_Label")
    public String getnLabel() {
        return nLabel;
    }

    public void setnLabel(String nLabel) {
        this.nLabel = nLabel;
    }

    private Integer idLibrarian;

    @Basic
    @javax.persistence.Column(name = "ID_Librarian")
    public Integer getIdLibrarian() {
        return idLibrarian;
    }

    public void setIdLibrarian(Integer idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    private Timestamp firstDate;

    @Basic
    @javax.persistence.Column(name = "FirstDate")
    public Timestamp getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Timestamp firstDate) {
        this.firstDate = firstDate;
    }

    private Timestamp lastDate;

    @Basic
    @javax.persistence.Column(name = "LastDate")
    public Timestamp getLastDate() {
        return lastDate;
    }

    public void setLastDate(Timestamp lastDate) {
        this.lastDate = lastDate;
    }

    private Short desc65;

    @Basic
    @javax.persistence.Column(name = "Desc_65")
    public Short getDesc65() {
        return desc65;
    }

    public void setDesc65(Short desc65) {
        this.desc65 = desc65;
    }

    private String bkGuid;

    @Basic
    @javax.persistence.Column(name = "Bk_GUID")
    public String getBkGuid() {
        return bkGuid;
    }

    public void setBkGuid(String bkGuid) {
        this.bkGuid = bkGuid;
    }

    private Byte deleting;

    @Basic
    @javax.persistence.Column(name = "Deleting")
    public Byte getDeleting() {
        return deleting;
    }

    public void setDeleting(Byte deleting) {
        this.deleting = deleting;
    }

    private String sortStr;

    @Basic
    @javax.persistence.Column(name = "SortStr")
    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr;
    }

    private Timestamp recDate;

    @Basic
    @javax.persistence.Column(name = "RecDate")
    public Timestamp getRecDate() {
        return recDate;
    }

    public void setRecDate(Timestamp recDate) {
        this.recDate = recDate;
    }

    private Short copyCnt;

    @Basic
    @javax.persistence.Column(name = "CopyCnt")
    public Short getCopyCnt() {
        return copyCnt;
    }

    public void setCopyCnt(Short copyCnt) {
        this.copyCnt = copyCnt;
    }

    private String desc77;

    @Basic
    @javax.persistence.Column(name = "Desc_77")
    public String getDesc77() {
        return desc77;
    }

    public void setDesc77(String desc77) {
        this.desc77 = desc77;
    }

    private Integer idLibrarian2;

    @Basic
    @javax.persistence.Column(name = "ID_Librarian2")
    public Integer getIdLibrarian2() {
        return idLibrarian2;
    }

    public void setIdLibrarian2(Integer idLibrarian2) {
        this.idLibrarian2 = idLibrarian2;
    }

    private String eb;

    @Basic
    @javax.persistence.Column(name = "eb")
    public String getEb() {
        return eb;
    }

    public void setEb(String eb) {
        this.eb = eb;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (bkGuid != null ? !bkGuid.equals(that.bkGuid) : that.bkGuid != null) return false;
        if (copyCnt != null ? !copyCnt.equals(that.copyCnt) : that.copyCnt != null) return false;
        if (deleting != null ? !deleting.equals(that.deleting) : that.deleting != null) return false;
        if (desc1 != null ? !desc1.equals(that.desc1) : that.desc1 != null) return false;
        if (desc21 != null ? !desc21.equals(that.desc21) : that.desc21 != null) return false;
        if (desc29 != null ? !desc29.equals(that.desc29) : that.desc29 != null) return false;
        if (desc31 != null ? !desc31.equals(that.desc31) : that.desc31 != null) return false;
        if (desc65 != null ? !desc65.equals(that.desc65) : that.desc65 != null) return false;
        if (desc77 != null ? !desc77.equals(that.desc77) : that.desc77 != null) return false;
        if (eb != null ? !eb.equals(that.eb) : that.eb != null) return false;
        if (firstDate != null ? !firstDate.equals(that.firstDate) : that.firstDate != null) return false;
        if (idBook != null ? !idBook.equals(that.idBook) : that.idBook != null) return false;
        if (idCatalog != null ? !idCatalog.equals(that.idCatalog) : that.idCatalog != null) return false;
        if (idLabel != null ? !idLabel.equals(that.idLabel) : that.idLabel != null) return false;
        if (idLibrarian != null ? !idLibrarian.equals(that.idLibrarian) : that.idLibrarian != null) return false;
        if (idLibrarian2 != null ? !idLibrarian2.equals(that.idLibrarian2) : that.idLibrarian2 != null) return false;
        if (lastDate != null ? !lastDate.equals(that.lastDate) : that.lastDate != null) return false;
        if (nLabel != null ? !nLabel.equals(that.nLabel) : that.nLabel != null) return false;
        if (recDate != null ? !recDate.equals(that.recDate) : that.recDate != null) return false;
        if (sortStr != null ? !sortStr.equals(that.sortStr) : that.sortStr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBook != null ? idBook.hashCode() : 0;
        result = 31 * result + (desc1 != null ? desc1.hashCode() : 0);
        result = 31 * result + (desc21 != null ? desc21.hashCode() : 0);
        result = 31 * result + (desc29 != null ? desc29.hashCode() : 0);
        result = 31 * result + (desc31 != null ? desc31.hashCode() : 0);
        result = 31 * result + (idCatalog != null ? idCatalog.hashCode() : 0);
        result = 31 * result + (idLabel != null ? idLabel.hashCode() : 0);
        result = 31 * result + (nLabel != null ? nLabel.hashCode() : 0);
        result = 31 * result + (idLibrarian != null ? idLibrarian.hashCode() : 0);
        result = 31 * result + (firstDate != null ? firstDate.hashCode() : 0);
        result = 31 * result + (lastDate != null ? lastDate.hashCode() : 0);
        result = 31 * result + (desc65 != null ? desc65.hashCode() : 0);
        result = 31 * result + (bkGuid != null ? bkGuid.hashCode() : 0);
        result = 31 * result + (deleting != null ? deleting.hashCode() : 0);
        result = 31 * result + (sortStr != null ? sortStr.hashCode() : 0);
        result = 31 * result + (recDate != null ? recDate.hashCode() : 0);
        result = 31 * result + (copyCnt != null ? copyCnt.hashCode() : 0);
        result = 31 * result + (desc77 != null ? desc77.hashCode() : 0);
        result = 31 * result + (idLibrarian2 != null ? idLibrarian2.hashCode() : 0);
        result = 31 * result + (eb != null ? eb.hashCode() : 0);
        return result;
    }
}

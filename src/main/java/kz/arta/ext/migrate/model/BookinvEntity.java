package kz.arta.ext.migrate.model;

import javax.persistence.*;

/**
 * Created by timur on 09/07/2014 14:13.
 */
@Entity
@Table(name = "bookinv", schema = "", catalog = "books")
public class BookinvEntity {
    private Integer idInv;
    private Integer idBook;
    private Integer invNum;
    private Integer invIdKsu1;
    private Short invCnt;
    private Integer invIdDepart;
    private Integer desc53;
    private Integer idValut;
    private String invPrim;
    private String barCode;
    private Integer uchNum;
    private Short rCnt;
    private String pFix;

    @Id
    @Column(name = "ID_Inv")
    public Integer getIdInv() {
        return idInv;
    }

    public void setIdInv(Integer idInv) {
        this.idInv = idInv;
    }

    @Basic
    @Column(name = "ID_Book")
    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    @Basic
    @Column(name = "InvNum")
    public Integer getInvNum() {
        return invNum;
    }

    public void setInvNum(Integer invNum) {
        this.invNum = invNum;
    }

    @Basic
    @Column(name = "InvID_KSU1")
    public Integer getInvIdKsu1() {
        return invIdKsu1;
    }

    public void setInvIdKsu1(Integer invIdKsu1) {
        this.invIdKsu1 = invIdKsu1;
    }

    @Basic
    @Column(name = "InvCnt")
    public Short getInvCnt() {
        return invCnt;
    }

    public void setInvCnt(Short invCnt) {
        this.invCnt = invCnt;
    }

    @Basic
    @Column(name = "InvIDDepart")
    public Integer getInvIdDepart() {
        return invIdDepart;
    }

    public void setInvIdDepart(Integer invIdDepart) {
        this.invIdDepart = invIdDepart;
    }

    @Basic
    @Column(name = "Desc_53")
    public Integer getDesc53() {
        return desc53;
    }

    public void setDesc53(Integer desc53) {
        this.desc53 = desc53;
    }

    @Basic
    @Column(name = "ID_Valut")
    public Integer getIdValut() {
        return idValut;
    }

    public void setIdValut(Integer idValut) {
        this.idValut = idValut;
    }

    @Basic
    @Column(name = "InvPrim")
    public String getInvPrim() {
        return invPrim;
    }

    public void setInvPrim(String invPrim) {
        this.invPrim = invPrim;
    }

    @Basic
    @Column(name = "BarCode")
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Basic
    @Column(name = "UchNum")
    public Integer getUchNum() {
        return uchNum;
    }

    public void setUchNum(Integer uchNum) {
        this.uchNum = uchNum;
    }

    @Basic
    @Column(name = "RCnt")
    public Short getrCnt() {
        return rCnt;
    }

    public void setrCnt(Short rCnt) {
        this.rCnt = rCnt;
    }

    @Basic
    @Column(name = "PFix")
    public String getpFix() {
        return pFix;
    }

    public void setpFix(String pFix) {
        this.pFix = pFix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookinvEntity that = (BookinvEntity) o;

        if (barCode != null ? !barCode.equals(that.barCode) : that.barCode != null) return false;
        if (desc53 != null ? !desc53.equals(that.desc53) : that.desc53 != null) return false;
        if (idBook != null ? !idBook.equals(that.idBook) : that.idBook != null) return false;
        if (idInv != null ? !idInv.equals(that.idInv) : that.idInv != null) return false;
        if (idValut != null ? !idValut.equals(that.idValut) : that.idValut != null) return false;
        if (invCnt != null ? !invCnt.equals(that.invCnt) : that.invCnt != null) return false;
        if (invIdDepart != null ? !invIdDepart.equals(that.invIdDepart) : that.invIdDepart != null) return false;
        if (invIdKsu1 != null ? !invIdKsu1.equals(that.invIdKsu1) : that.invIdKsu1 != null) return false;
        if (invNum != null ? !invNum.equals(that.invNum) : that.invNum != null) return false;
        if (invPrim != null ? !invPrim.equals(that.invPrim) : that.invPrim != null) return false;
        if (pFix != null ? !pFix.equals(that.pFix) : that.pFix != null) return false;
        if (rCnt != null ? !rCnt.equals(that.rCnt) : that.rCnt != null) return false;
        if (uchNum != null ? !uchNum.equals(that.uchNum) : that.uchNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInv != null ? idInv.hashCode() : 0;
        result = 31 * result + (idBook != null ? idBook.hashCode() : 0);
        result = 31 * result + (invNum != null ? invNum.hashCode() : 0);
        result = 31 * result + (invIdKsu1 != null ? invIdKsu1.hashCode() : 0);
        result = 31 * result + (invCnt != null ? invCnt.hashCode() : 0);
        result = 31 * result + (invIdDepart != null ? invIdDepart.hashCode() : 0);
        result = 31 * result + (desc53 != null ? desc53.hashCode() : 0);
        result = 31 * result + (idValut != null ? idValut.hashCode() : 0);
        result = 31 * result + (invPrim != null ? invPrim.hashCode() : 0);
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (uchNum != null ? uchNum.hashCode() : 0);
        result = 31 * result + (rCnt != null ? rCnt.hashCode() : 0);
        result = 31 * result + (pFix != null ? pFix.hashCode() : 0);
        return result;
    }
}

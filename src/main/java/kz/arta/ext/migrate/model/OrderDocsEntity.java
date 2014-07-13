package kz.arta.ext.migrate.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by timur on 09/07/2014 14:13.
 */
@Entity
@Table(name = "orderdocs", schema = "", catalog = "books")
public class OrderDocsEntity {
    private Integer id;
    private Integer idOrder;
    private Integer idBook;
    private Integer idInv;
    private Integer invNum;
    private String invSigla;
    private String barCode;
    private Integer uchNum;
    private Timestamp dOut;
    private Timestamp dTerm;
    private Timestamp dIn;
    private Float price;
    private Integer idLibrarianOut;
    private Integer idLibrarianIn;
    private String userInfoOut;
    private String userInfoIn;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_Order")
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
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
    @Column(name = "ID_Inv")
    public Integer getIdInv() {
        return idInv;
    }

    public void setIdInv(Integer idInv) {
        this.idInv = idInv;
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
    @Column(name = "InvSigla")
    public String getInvSigla() {
        return invSigla;
    }

    public void setInvSigla(String invSigla) {
        this.invSigla = invSigla;
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
    @Column(name = "D_OUT")
    public Timestamp getdOut() {
        return dOut;
    }

    public void setdOut(Timestamp dOut) {
        this.dOut = dOut;
    }

    @Basic
    @Column(name = "D_TERM")
    public Timestamp getdTerm() {
        return dTerm;
    }

    public void setdTerm(Timestamp dTerm) {
        this.dTerm = dTerm;
    }

    @Basic
    @Column(name = "D_IN")
    public Timestamp getdIn() {
        return dIn;
    }

    public void setdIn(Timestamp dIn) {
        this.dIn = dIn;
    }

    @Basic
    @Column(name = "Price")
    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "ID_LibrarianOut")
    public Integer getIdLibrarianOut() {
        return idLibrarianOut;
    }

    public void setIdLibrarianOut(Integer idLibrarianOut) {
        this.idLibrarianOut = idLibrarianOut;
    }

    @Basic
    @Column(name = "ID_LibrarianIn")
    public Integer getIdLibrarianIn() {
        return idLibrarianIn;
    }

    public void setIdLibrarianIn(Integer idLibrarianIn) {
        this.idLibrarianIn = idLibrarianIn;
    }

    @Basic
    @Column(name = "user_info_out")
    public String getUserInfoOut() {
        return userInfoOut;
    }

    public void setUserInfoOut(String userInfoOut) {
        this.userInfoOut = userInfoOut;
    }

    @Basic
    @Column(name = "user_info_in")
    public String getUserInfoIn() {
        return userInfoIn;
    }

    public void setUserInfoIn(String userInfoIn) {
        this.userInfoIn = userInfoIn;
    }


    private String migrateUUID;
    @Basic
    @javax.persistence.Column(name = "migrateUUID")
    public String getMigrateUUID() {
        return migrateUUID;
    }

    public void setMigrateUUID(String migrateUUID) {
        this.migrateUUID = migrateUUID;
    }


    private String errorInfo;

    @Basic
    @javax.persistence.Column(name = "errorInfo")
    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDocsEntity that = (OrderDocsEntity) o;

        if (barCode != null ? !barCode.equals(that.barCode) : that.barCode != null) return false;
        if (dIn != null ? !dIn.equals(that.dIn) : that.dIn != null) return false;
        if (dOut != null ? !dOut.equals(that.dOut) : that.dOut != null) return false;
        if (dTerm != null ? !dTerm.equals(that.dTerm) : that.dTerm != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idBook != null ? !idBook.equals(that.idBook) : that.idBook != null) return false;
        if (idInv != null ? !idInv.equals(that.idInv) : that.idInv != null) return false;
        if (idLibrarianIn != null ? !idLibrarianIn.equals(that.idLibrarianIn) : that.idLibrarianIn != null)
            return false;
        if (idLibrarianOut != null ? !idLibrarianOut.equals(that.idLibrarianOut) : that.idLibrarianOut != null)
            return false;
        if (idOrder != null ? !idOrder.equals(that.idOrder) : that.idOrder != null) return false;
        if (invNum != null ? !invNum.equals(that.invNum) : that.invNum != null) return false;
        if (invSigla != null ? !invSigla.equals(that.invSigla) : that.invSigla != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (uchNum != null ? !uchNum.equals(that.uchNum) : that.uchNum != null) return false;
        if (userInfoIn != null ? !userInfoIn.equals(that.userInfoIn) : that.userInfoIn != null) return false;
        if (userInfoOut != null ? !userInfoOut.equals(that.userInfoOut) : that.userInfoOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idOrder != null ? idOrder.hashCode() : 0);
        result = 31 * result + (idBook != null ? idBook.hashCode() : 0);
        result = 31 * result + (idInv != null ? idInv.hashCode() : 0);
        result = 31 * result + (invNum != null ? invNum.hashCode() : 0);
        result = 31 * result + (invSigla != null ? invSigla.hashCode() : 0);
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        result = 31 * result + (uchNum != null ? uchNum.hashCode() : 0);
        result = 31 * result + (dOut != null ? dOut.hashCode() : 0);
        result = 31 * result + (dTerm != null ? dTerm.hashCode() : 0);
        result = 31 * result + (dIn != null ? dIn.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (idLibrarianOut != null ? idLibrarianOut.hashCode() : 0);
        result = 31 * result + (idLibrarianIn != null ? idLibrarianIn.hashCode() : 0);
        result = 31 * result + (userInfoOut != null ? userInfoOut.hashCode() : 0);
        result = 31 * result + (userInfoIn != null ? userInfoIn.hashCode() : 0);
        return result;
    }
}

package kz.arta.ext.migrate.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by timur on 09/07/2014 14:13.
 */


@Entity
@javax.persistence.Table(name = "orders", schema = "", catalog = "books")
public class OrdersEntity {
    private Integer id;

    @Id
    @javax.persistence.Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer readerFrom;

    @Basic
    @javax.persistence.Column(name = "ReaderFrom")
    public Integer getReaderFrom() {
        return readerFrom;
    }

    public void setReaderFrom(Integer readerFrom) {
        this.readerFrom = readerFrom;
    }

    private Integer idStud;

    @Basic
    @javax.persistence.Column(name = "ID_Stud")
    public Integer getIdStud() {
        return idStud;
    }

    public void setIdStud(Integer idStud) {
        this.idStud = idStud;
    }

    private String cnReader;

    @Basic
    @javax.persistence.Column(name = "cn_Reader")
    public String getCnReader() {
        return cnReader;
    }

    public void setCnReader(String cnReader) {
        this.cnReader = cnReader;
    }

    private String fio;

    @Basic
    @javax.persistence.Column(name = "FIO")
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    private String iin;

    @Basic
    @javax.persistence.Column(name = "iin")
    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    private Integer idSigla;

    @Basic
    @javax.persistence.Column(name = "ID_Sigla")
    public Integer getIdSigla() {
        return idSigla;
    }

    public void setIdSigla(Integer idSigla) {
        this.idSigla = idSigla;
    }

    private Integer idOrderStatus;

    @Basic
    @javax.persistence.Column(name = "ID_OrderStatus")
    public Integer getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(Integer idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    private Integer orderCnt;

    @Basic
    @javax.persistence.Column(name = "OrderCnt")
    public Integer getOrderCnt() {
        return orderCnt;
    }

    public void setOrderCnt(Integer orderCnt) {
        this.orderCnt = orderCnt;
    }

    private Integer outCnt;

    @Basic
    @javax.persistence.Column(name = "OutCnt")
    public Integer getOutCnt() {
        return outCnt;
    }

    public void setOutCnt(Integer outCnt) {
        this.outCnt = outCnt;
    }

    private Integer debtCnt;

    @Basic
    @javax.persistence.Column(name = "DebtCnt")
    public Integer getDebtCnt() {
        return debtCnt;
    }

    public void setDebtCnt(Integer debtCnt) {
        this.debtCnt = debtCnt;
    }

    private Timestamp dOrder;

    @Basic
    @javax.persistence.Column(name = "D_Order")
    public Timestamp getdOrder() {
        return dOrder;
    }

    public void setdOrder(Timestamp dOrder) {
        this.dOrder = dOrder;
    }

    private Timestamp dExec;

    @Basic
    @javax.persistence.Column(name = "D_Exec")
    public Timestamp getdExec() {
        return dExec;
    }

    public void setdExec(Timestamp dExec) {
        this.dExec = dExec;
    }

    private Float orderPrice;

    @Basic
    @javax.persistence.Column(name = "OrderPrice")
    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    private Float paid;

    @Basic
    @javax.persistence.Column(name = "Paid")
    public Float getPaid() {
        return paid;
    }

    public void setPaid(Float paid) {
        this.paid = paid;
    }

    private String prim;

    @Basic
    @javax.persistence.Column(name = "Prim")
    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
    }

    private Timestamp dCreate;

    @Basic
    @javax.persistence.Column(name = "d_create")
    public Timestamp getdCreate() {
        return dCreate;
    }

    public void setdCreate(Timestamp dCreate) {
        this.dCreate = dCreate;
    }

    private Integer faculty;

    @Basic
    @javax.persistence.Column(name = "Faculty")
    public Integer getFaculty() {
        return faculty;
    }

    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }

    private Integer cafedra;

    @Basic
    @javax.persistence.Column(name = "Cafedra")
    public Integer getCafedra() {
        return cafedra;
    }

    public void setCafedra(Integer cafedra) {
        this.cafedra = cafedra;
    }

    private Integer courseNumber;

    @Basic
    @javax.persistence.Column(name = "CourseNumber")
    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    private Integer groupId;

    @Basic
    @javax.persistence.Column(name = "GroupId")
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (cafedra != null ? !cafedra.equals(that.cafedra) : that.cafedra != null) return false;
        if (cnReader != null ? !cnReader.equals(that.cnReader) : that.cnReader != null) return false;
        if (courseNumber != null ? !courseNumber.equals(that.courseNumber) : that.courseNumber != null) return false;
        if (dCreate != null ? !dCreate.equals(that.dCreate) : that.dCreate != null) return false;
        if (dExec != null ? !dExec.equals(that.dExec) : that.dExec != null) return false;
        if (dOrder != null ? !dOrder.equals(that.dOrder) : that.dOrder != null) return false;
        if (debtCnt != null ? !debtCnt.equals(that.debtCnt) : that.debtCnt != null) return false;
        if (faculty != null ? !faculty.equals(that.faculty) : that.faculty != null) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idOrderStatus != null ? !idOrderStatus.equals(that.idOrderStatus) : that.idOrderStatus != null)
            return false;
        if (idSigla != null ? !idSigla.equals(that.idSigla) : that.idSigla != null) return false;
        if (idStud != null ? !idStud.equals(that.idStud) : that.idStud != null) return false;
        if (iin != null ? !iin.equals(that.iin) : that.iin != null) return false;
        if (orderCnt != null ? !orderCnt.equals(that.orderCnt) : that.orderCnt != null) return false;
        if (orderPrice != null ? !orderPrice.equals(that.orderPrice) : that.orderPrice != null) return false;
        if (outCnt != null ? !outCnt.equals(that.outCnt) : that.outCnt != null) return false;
        if (paid != null ? !paid.equals(that.paid) : that.paid != null) return false;
        if (prim != null ? !prim.equals(that.prim) : that.prim != null) return false;
        if (readerFrom != null ? !readerFrom.equals(that.readerFrom) : that.readerFrom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (readerFrom != null ? readerFrom.hashCode() : 0);
        result = 31 * result + (idStud != null ? idStud.hashCode() : 0);
        result = 31 * result + (cnReader != null ? cnReader.hashCode() : 0);
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (iin != null ? iin.hashCode() : 0);
        result = 31 * result + (idSigla != null ? idSigla.hashCode() : 0);
        result = 31 * result + (idOrderStatus != null ? idOrderStatus.hashCode() : 0);
        result = 31 * result + (orderCnt != null ? orderCnt.hashCode() : 0);
        result = 31 * result + (outCnt != null ? outCnt.hashCode() : 0);
        result = 31 * result + (debtCnt != null ? debtCnt.hashCode() : 0);
        result = 31 * result + (dOrder != null ? dOrder.hashCode() : 0);
        result = 31 * result + (dExec != null ? dExec.hashCode() : 0);
        result = 31 * result + (orderPrice != null ? orderPrice.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        result = 31 * result + (prim != null ? prim.hashCode() : 0);
        result = 31 * result + (dCreate != null ? dCreate.hashCode() : 0);
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (cafedra != null ? cafedra.hashCode() : 0);
        result = 31 * result + (courseNumber != null ? courseNumber.hashCode() : 0);
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        return result;
    }
}

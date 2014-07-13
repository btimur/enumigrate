package kz.arta.ext.migrate.model.synergy;

import kz.arta.ext.migrate.util.ApiFormField;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by timur on 12/07/2014 10:35.
 * Реестр заказов
 */

@NamedNativeQuery(name="OrderQuery", query = "select od.ID, b.Desc_21 as nameofbook, " +
        "od.InvNum as invnum, " +
        "od.BarCode as shtrihkod, " +
        "s.Name as siglaName, s.ID as siglID, " +
        "od.D_OUT as dateofvidacha, " +
        "l1.Name as vidalbibl, " +
        "od.D_IN as dateofsdacha, " +
        "l2.Name  as prinalbibl , " +
        "od.D_TERM as periodV, " +
        "o.ID_OrderStatus as status, " +
        "o.iin " +
        "from orderdocs od " +
        "left join orders o on od.ID_Order=o.ID " +
        "left join ref_sigla s on o.ID_Sigla=s.ID " +
        "left join books b on od.ID_Book=b.ID_Book " +
        "left join librarians l1 on l1.ID=od.ID_LibrarianOut " +
        "left join librarians l2 on l2.ID=od.ID_LibrarianIn " +
        "where od.ID=?",resultClass=Orders.class)

//@SqlResultSetMapping(name="OrderResults",)
@Entity
public class Orders {

    /**
     * ID
     */
    private Integer id;


    /**
     * Пользователь
     */
    private String userid;
    /**
     * Название книги
     */
    @ApiFormField(typeField = "textarea")
    private String nameofbook;
    /**
     * Инвентарный номер
     */
    @ApiFormField(typeField = "textbox")
    private String invnum;
    /**
     * Штрих код
     */
    @ApiFormField(typeField = "textbox")
    private String shtrihkod;
    /**
     * Сигла
     */
    @ApiFormField(typeField = "listbox")
    private KeyObject sigla;
    /**
     * Дата выдачи
     */
    @ApiFormField(typeField = "date")
    private Timestamp dateofvidacha;
    /**
     * Выдал бибилиотекарь
     */
    @ApiFormField(typeField = "textbox")
    private String vidalbibl;
    /**
     * Информация
     */
//    @ApiFormField(typeField = "textarea")
    private String information1;
    /**
     * Срок возврата
     */
    private String srokvozvrata;
    /***
     * период выдачи
     */
    private Timestamp periodV;
    /**
     * Дата сдачи
     */
    @ApiFormField(typeField = "date")
    private Timestamp dateofsdacha;
    /**
     * Принял бибилиотекарь
     */
    @ApiFormField(typeField = "textbox")
    private String prinalbibl;
    /**
     * Информация
     */
    @ApiFormField(typeField = "textarea")
    private String information2;
    /**
     * ИИН пользователя в Платона
     */
    @ApiFormField(typeField = "textbox")
    private String iin;
    /**
     * Статус заказа
     */
    @ApiFormField(typeField = "textbox")
    private String status;

    private String siglaName;
    private Integer siglID;

    /**
     * uuid в реестре
     */
    private String migrateUUID;



    @Id
    @javax.persistence.Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Transient
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNameofbook() {
        return nameofbook;
    }

    public void setNameofbook(String nameofbook) {
        this.nameofbook = nameofbook;
    }

    public String getInvnum() {
        return invnum;
    }

    public void setInvnum(String invnum) {
        this.invnum = invnum;
    }

    public String getShtrihkod() {
        return shtrihkod;
    }

    public void setShtrihkod(String shtrihkod) {
        this.shtrihkod = shtrihkod;
    }

    @Transient
    public KeyObject getSigla() {
        return sigla;
    }

    public void setSigla(KeyObject sigla) {
        this.sigla = sigla;
    }

    public Timestamp getDateofvidacha() {
        return dateofvidacha;
    }

    public void setDateofvidacha(Timestamp dateofvidacha) {
        this.dateofvidacha = dateofvidacha;
    }

    public String getVidalbibl() {
        return vidalbibl;
    }

    public void setVidalbibl(String vidalbibl) {
        this.vidalbibl = vidalbibl;
    }

    @Transient
    public String getSrokvozvrata() {
        return srokvozvrata;
    }

    public void setSrokvozvrata(String srokvozvrata) {
        this.srokvozvrata = srokvozvrata;
    }

    public Timestamp getDateofsdacha() {
        return dateofsdacha;
    }

    public void setDateofsdacha(Timestamp dateofsdacha) {
        this.dateofsdacha = dateofsdacha;
    }

    public String getPrinalbibl() {
        return prinalbibl;
    }

    public void setPrinalbibl(String prinalbibl) {
        this.prinalbibl = prinalbibl;
    }

    @Transient
    public String getInformation1() {
        return information1;
    }

    public void setInformation1(String information1) {
        this.information1 = information1;
    }

    @Transient
    public String getInformation2() {
        return information2;
    }

    public void setInformation2(String information2) {
        this.information2 = information2;
    }




    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    @Transient
    public String getMigrateUUID() {
        return migrateUUID;
    }

    public void setMigrateUUID(String migrateUUID) {
        this.migrateUUID = migrateUUID;
    }



    public Timestamp getPeriodV() {
        return periodV;
    }

    public void setPeriodV(Timestamp periodV) {
        this.periodV = periodV;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiglaName() {
        return siglaName;
    }

    public void setSiglaName(String siglaName) {
        this.siglaName = siglaName;
    }

    public Integer getSiglID() {
        return siglID;
    }

    public void setSiglID(Integer siglID) {
        this.siglID = siglID;
    }
}

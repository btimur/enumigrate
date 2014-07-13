package kz.arta.ext.migrate.model;

import javax.persistence.*;

/**
 * Created by timur on 12/07/2014 23:15.
 */
@Entity
@Table(name = "migrate_status", schema = "", catalog = "books")
public class MigrateStatusEntity {
    private String code;
    private Integer val;

    @Id
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "val")
    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MigrateStatusEntity that = (MigrateStatusEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (val != null ? !val.equals(that.val) : that.val != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (val != null ? val.hashCode() : 0);
        return result;
    }
}

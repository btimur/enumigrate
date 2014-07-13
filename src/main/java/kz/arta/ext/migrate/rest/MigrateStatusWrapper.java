package kz.arta.ext.migrate.rest;


/**
 * Created by timur on 13/07/2014 01:41.
 */
public class MigrateStatusWrapper {
    private Boolean isStarted;
    private Integer countDid;
    private Long countAll;
    private Double procent;

    public Boolean getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(Boolean isStarted) {
        this.isStarted = isStarted;
    }

    public Integer getCountDid() {
        return countDid;
    }

    public void setCountDid(Integer countDid) {
        this.countDid = countDid;
    }

    public Long getCountAll() {
        return countAll;
    }

    public void setCountAll(Long countAll) {
        this.countAll = countAll;
    }

    public Double getProcent() {
        return procent;
    }

    public void setProcent(Double procent) {
        this.procent = procent;
    }
}

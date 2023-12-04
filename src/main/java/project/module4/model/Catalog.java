package project.module4.model;

import java.util.Date;

public class Catalog {
    private Long catalogId;
    private String catalogName;
    private String description;
    private Date createAt;
    private boolean Status;

    public Catalog() {
    }

    public Catalog(Long catalogId, String catalogName, String description, Date createAt, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.createAt = createAt;
        Status = status;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return new Date();
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }
}

package project.module4.model;

import java.util.Date;

public class Product {
    private Long productId;
    private String productName;
    private Long categoryId;
    private String description;
    private double unitPrice;
    private int stock;
    private Date createAt;
    private Date updateAt;
    private boolean status;

    public Product() {
    }

    public Product(Long productId, String productName, Long categoryId, String description, double unitPrice, int stock, Date createAt, Date updateAt, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.status = status;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getCreateAt() {
        return new Date();
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return new Date();
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}


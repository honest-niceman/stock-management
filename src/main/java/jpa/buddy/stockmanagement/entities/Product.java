package jpa.buddy.stockmanagement.entities;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product", indexes = {
        @Index(name = "idx_product_name", columnList = "name")
})
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "product_code", nullable = false)
    private String product_code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String name) {
        this.product_code = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
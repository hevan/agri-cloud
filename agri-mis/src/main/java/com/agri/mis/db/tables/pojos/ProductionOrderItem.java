/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ProductionOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long productId;
    private Double quantity;
    private BigDecimal price;
    private Long orderId;
    private LocalDateTime createdAt;
    private Long corpId;
    private BigDecimal amount;
    private String productSku;
    private String description;

    public ProductionOrderItem() {}

    public ProductionOrderItem(ProductionOrderItem value) {
        this.id = value.id;
        this.productId = value.productId;
        this.quantity = value.quantity;
        this.price = value.price;
        this.orderId = value.orderId;
        this.createdAt = value.createdAt;
        this.corpId = value.corpId;
        this.amount = value.amount;
        this.productSku = value.productSku;
        this.description = value.description;
    }

    public ProductionOrderItem(
        Long id,
        Long productId,
        Double quantity,
        BigDecimal price,
        Long orderId,
        LocalDateTime createdAt,
        Long corpId,
        BigDecimal amount,
        String productSku,
        String description
    ) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.corpId = corpId;
        this.amount = amount;
        this.productSku = productSku;
        this.description = description;
    }

    /**
     * Getter for <code>public.production_order_item.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.production_order_item.id</code>.
     */
    public ProductionOrderItem setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.product_id</code>.
     */
    public Long getProductId() {
        return this.productId;
    }

    /**
     * Setter for <code>public.production_order_item.product_id</code>.
     */
    public ProductionOrderItem setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.quantity</code>.
     */
    public Double getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.production_order_item.quantity</code>.
     */
    public ProductionOrderItem setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.price</code>.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.production_order_item.price</code>.
     */
    public ProductionOrderItem setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.order_id</code>.
     */
    public Long getOrderId() {
        return this.orderId;
    }

    /**
     * Setter for <code>public.production_order_item.order_id</code>.
     */
    public ProductionOrderItem setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.production_order_item.created_at</code>.
     */
    public ProductionOrderItem setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.production_order_item.corp_id</code>.
     */
    public ProductionOrderItem setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.amount</code>.
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Setter for <code>public.production_order_item.amount</code>.
     */
    public ProductionOrderItem setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.product_sku</code>.
     */
    public String getProductSku() {
        return this.productSku;
    }

    /**
     * Setter for <code>public.production_order_item.product_sku</code>.
     */
    public ProductionOrderItem setProductSku(String productSku) {
        this.productSku = productSku;
        return this;
    }

    /**
     * Getter for <code>public.production_order_item.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.production_order_item.description</code>.
     */
    public ProductionOrderItem setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProductionOrderItem other = (ProductionOrderItem) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.productId == null) {
            if (other.productId != null)
                return false;
        }
        else if (!this.productId.equals(other.productId))
            return false;
        if (this.quantity == null) {
            if (other.quantity != null)
                return false;
        }
        else if (!this.quantity.equals(other.quantity))
            return false;
        if (this.price == null) {
            if (other.price != null)
                return false;
        }
        else if (!this.price.equals(other.price))
            return false;
        if (this.orderId == null) {
            if (other.orderId != null)
                return false;
        }
        else if (!this.orderId.equals(other.orderId))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.corpId == null) {
            if (other.corpId != null)
                return false;
        }
        else if (!this.corpId.equals(other.corpId))
            return false;
        if (this.amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!this.amount.equals(other.amount))
            return false;
        if (this.productSku == null) {
            if (other.productSku != null)
                return false;
        }
        else if (!this.productSku.equals(other.productSku))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.productId == null) ? 0 : this.productId.hashCode());
        result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
        result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
        result = prime * result + ((this.orderId == null) ? 0 : this.orderId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.productSku == null) ? 0 : this.productSku.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ProductionOrderItem (");

        sb.append(id);
        sb.append(", ").append(productId);
        sb.append(", ").append(quantity);
        sb.append(", ").append(price);
        sb.append(", ").append(orderId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(corpId);
        sb.append(", ").append(amount);
        sb.append(", ").append(productSku);
        sb.append(", ").append(description);

        sb.append(")");
        return sb.toString();
    }
}
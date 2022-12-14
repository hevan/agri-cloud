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
public class MisProductionOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long productId;
    private BigDecimal quantity;
    private BigDecimal price;
    private Long purchaseOrderId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updtedAt;
    private String updatedBy;
    private Long corpId;
    private BigDecimal amount;
    private LocalDateTime occurAt;

    public MisProductionOrderItem() {}

    public MisProductionOrderItem(MisProductionOrderItem value) {
        this.id = value.id;
        this.productId = value.productId;
        this.quantity = value.quantity;
        this.price = value.price;
        this.purchaseOrderId = value.purchaseOrderId;
        this.createdAt = value.createdAt;
        this.createdBy = value.createdBy;
        this.updtedAt = value.updtedAt;
        this.updatedBy = value.updatedBy;
        this.corpId = value.corpId;
        this.amount = value.amount;
        this.occurAt = value.occurAt;
    }

    public MisProductionOrderItem(
        Long id,
        Long productId,
        BigDecimal quantity,
        BigDecimal price,
        Long purchaseOrderId,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updtedAt,
        String updatedBy,
        Long corpId,
        BigDecimal amount,
        LocalDateTime occurAt
    ) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.purchaseOrderId = purchaseOrderId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updtedAt = updtedAt;
        this.updatedBy = updatedBy;
        this.corpId = corpId;
        this.amount = amount;
        this.occurAt = occurAt;
    }

    /**
     * Getter for <code>public.mis_production_order_item.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.mis_production_order_item.id</code>.
     */
    public MisProductionOrderItem setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.product_id</code>.
     */
    public Long getProductId() {
        return this.productId;
    }

    /**
     * Setter for <code>public.mis_production_order_item.product_id</code>.
     */
    public MisProductionOrderItem setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.quantity</code>.
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.mis_production_order_item.quantity</code>.
     */
    public MisProductionOrderItem setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.price</code>.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.mis_production_order_item.price</code>.
     */
    public MisProductionOrderItem setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Getter for
     * <code>public.mis_production_order_item.purchase_order_id</code>.
     */
    public Long getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    /**
     * Setter for
     * <code>public.mis_production_order_item.purchase_order_id</code>.
     */
    public MisProductionOrderItem setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.mis_production_order_item.created_at</code>.
     */
    public MisProductionOrderItem setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.created_by</code>.
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>public.mis_production_order_item.created_by</code>.
     */
    public MisProductionOrderItem setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.updted_at</code>.
     */
    public LocalDateTime getUpdtedAt() {
        return this.updtedAt;
    }

    /**
     * Setter for <code>public.mis_production_order_item.updted_at</code>.
     */
    public MisProductionOrderItem setUpdtedAt(LocalDateTime updtedAt) {
        this.updtedAt = updtedAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.updated_by</code>.
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * Setter for <code>public.mis_production_order_item.updated_by</code>.
     */
    public MisProductionOrderItem setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.mis_production_order_item.corp_id</code>.
     */
    public MisProductionOrderItem setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.amount</code>.
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Setter for <code>public.mis_production_order_item.amount</code>.
     */
    public MisProductionOrderItem setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order_item.occur_at</code>.
     */
    public LocalDateTime getOccurAt() {
        return this.occurAt;
    }

    /**
     * Setter for <code>public.mis_production_order_item.occur_at</code>.
     */
    public MisProductionOrderItem setOccurAt(LocalDateTime occurAt) {
        this.occurAt = occurAt;
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
        final MisProductionOrderItem other = (MisProductionOrderItem) obj;
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
        if (this.purchaseOrderId == null) {
            if (other.purchaseOrderId != null)
                return false;
        }
        else if (!this.purchaseOrderId.equals(other.purchaseOrderId))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.createdBy == null) {
            if (other.createdBy != null)
                return false;
        }
        else if (!this.createdBy.equals(other.createdBy))
            return false;
        if (this.updtedAt == null) {
            if (other.updtedAt != null)
                return false;
        }
        else if (!this.updtedAt.equals(other.updtedAt))
            return false;
        if (this.updatedBy == null) {
            if (other.updatedBy != null)
                return false;
        }
        else if (!this.updatedBy.equals(other.updatedBy))
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
        if (this.occurAt == null) {
            if (other.occurAt != null)
                return false;
        }
        else if (!this.occurAt.equals(other.occurAt))
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
        result = prime * result + ((this.purchaseOrderId == null) ? 0 : this.purchaseOrderId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        result = prime * result + ((this.updtedAt == null) ? 0 : this.updtedAt.hashCode());
        result = prime * result + ((this.updatedBy == null) ? 0 : this.updatedBy.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.occurAt == null) ? 0 : this.occurAt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MisProductionOrderItem (");

        sb.append(id);
        sb.append(", ").append(productId);
        sb.append(", ").append(quantity);
        sb.append(", ").append(price);
        sb.append(", ").append(purchaseOrderId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(updtedAt);
        sb.append(", ").append(updatedBy);
        sb.append(", ").append(corpId);
        sb.append(", ").append(amount);
        sb.append(", ").append(occurAt);

        sb.append(")");
        return sb.toString();
    }
}

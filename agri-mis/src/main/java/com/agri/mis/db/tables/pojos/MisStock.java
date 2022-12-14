/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MisStock implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String orderNo;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal amount;
    private Long originId;
    private String originType;
    private Long storeId;
    private Integer direction;
    private LocalDate occurAt;
    private Integer status;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updtedAt;
    private String updatedBy;
    private Long corpId;

    public MisStock() {}

    public MisStock(MisStock value) {
        this.id = value.id;
        this.name = value.name;
        this.orderNo = value.orderNo;
        this.quantity = value.quantity;
        this.price = value.price;
        this.amount = value.amount;
        this.originId = value.originId;
        this.originType = value.originType;
        this.storeId = value.storeId;
        this.direction = value.direction;
        this.occurAt = value.occurAt;
        this.status = value.status;
        this.createdAt = value.createdAt;
        this.createdBy = value.createdBy;
        this.updtedAt = value.updtedAt;
        this.updatedBy = value.updatedBy;
        this.corpId = value.corpId;
    }

    public MisStock(
        Long id,
        String name,
        String orderNo,
        BigDecimal quantity,
        BigDecimal price,
        BigDecimal amount,
        Long originId,
        String originType,
        Long storeId,
        Integer direction,
        LocalDate occurAt,
        Integer status,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updtedAt,
        String updatedBy,
        Long corpId
    ) {
        this.id = id;
        this.name = name;
        this.orderNo = orderNo;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
        this.originId = originId;
        this.originType = originType;
        this.storeId = storeId;
        this.direction = direction;
        this.occurAt = occurAt;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updtedAt = updtedAt;
        this.updatedBy = updatedBy;
        this.corpId = corpId;
    }

    /**
     * Getter for <code>public.mis_stock.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.mis_stock.id</code>.
     */
    public MisStock setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.mis_stock.name</code>.
     */
    public MisStock setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.order_no</code>.
     */
    public String getOrderNo() {
        return this.orderNo;
    }

    /**
     * Setter for <code>public.mis_stock.order_no</code>.
     */
    public MisStock setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.quantity</code>.
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.mis_stock.quantity</code>.
     */
    public MisStock setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.price</code>.
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Setter for <code>public.mis_stock.price</code>.
     */
    public MisStock setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.amount</code>.
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Setter for <code>public.mis_stock.amount</code>.
     */
    public MisStock setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.origin_id</code>.
     */
    public Long getOriginId() {
        return this.originId;
    }

    /**
     * Setter for <code>public.mis_stock.origin_id</code>.
     */
    public MisStock setOriginId(Long originId) {
        this.originId = originId;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.origin_type</code>.
     */
    public String getOriginType() {
        return this.originType;
    }

    /**
     * Setter for <code>public.mis_stock.origin_type</code>.
     */
    public MisStock setOriginType(String originType) {
        this.originType = originType;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.store_id</code>.
     */
    public Long getStoreId() {
        return this.storeId;
    }

    /**
     * Setter for <code>public.mis_stock.store_id</code>.
     */
    public MisStock setStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.direction</code>.
     */
    public Integer getDirection() {
        return this.direction;
    }

    /**
     * Setter for <code>public.mis_stock.direction</code>.
     */
    public MisStock setDirection(Integer direction) {
        this.direction = direction;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.occur_at</code>.
     */
    public LocalDate getOccurAt() {
        return this.occurAt;
    }

    /**
     * Setter for <code>public.mis_stock.occur_at</code>.
     */
    public MisStock setOccurAt(LocalDate occurAt) {
        this.occurAt = occurAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.status</code>.
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.mis_stock.status</code>.
     */
    public MisStock setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.mis_stock.created_at</code>.
     */
    public MisStock setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.created_by</code>.
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>public.mis_stock.created_by</code>.
     */
    public MisStock setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.updted_at</code>.
     */
    public LocalDateTime getUpdtedAt() {
        return this.updtedAt;
    }

    /**
     * Setter for <code>public.mis_stock.updted_at</code>.
     */
    public MisStock setUpdtedAt(LocalDateTime updtedAt) {
        this.updtedAt = updtedAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.updated_by</code>.
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * Setter for <code>public.mis_stock.updated_by</code>.
     */
    public MisStock setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.mis_stock.corp_id</code>.
     */
    public MisStock setCorpId(Long corpId) {
        this.corpId = corpId;
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
        final MisStock other = (MisStock) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.orderNo == null) {
            if (other.orderNo != null)
                return false;
        }
        else if (!this.orderNo.equals(other.orderNo))
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
        if (this.amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!this.amount.equals(other.amount))
            return false;
        if (this.originId == null) {
            if (other.originId != null)
                return false;
        }
        else if (!this.originId.equals(other.originId))
            return false;
        if (this.originType == null) {
            if (other.originType != null)
                return false;
        }
        else if (!this.originType.equals(other.originType))
            return false;
        if (this.storeId == null) {
            if (other.storeId != null)
                return false;
        }
        else if (!this.storeId.equals(other.storeId))
            return false;
        if (this.direction == null) {
            if (other.direction != null)
                return false;
        }
        else if (!this.direction.equals(other.direction))
            return false;
        if (this.occurAt == null) {
            if (other.occurAt != null)
                return false;
        }
        else if (!this.occurAt.equals(other.occurAt))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
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
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.orderNo == null) ? 0 : this.orderNo.hashCode());
        result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
        result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.originId == null) ? 0 : this.originId.hashCode());
        result = prime * result + ((this.originType == null) ? 0 : this.originType.hashCode());
        result = prime * result + ((this.storeId == null) ? 0 : this.storeId.hashCode());
        result = prime * result + ((this.direction == null) ? 0 : this.direction.hashCode());
        result = prime * result + ((this.occurAt == null) ? 0 : this.occurAt.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        result = prime * result + ((this.updtedAt == null) ? 0 : this.updtedAt.hashCode());
        result = prime * result + ((this.updatedBy == null) ? 0 : this.updatedBy.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MisStock (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(orderNo);
        sb.append(", ").append(quantity);
        sb.append(", ").append(price);
        sb.append(", ").append(amount);
        sb.append(", ").append(originId);
        sb.append(", ").append(originType);
        sb.append(", ").append(storeId);
        sb.append(", ").append(direction);
        sb.append(", ").append(occurAt);
        sb.append(", ").append(status);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(updtedAt);
        sb.append(", ").append(updatedBy);
        sb.append(", ").append(corpId);

        sb.append(")");
        return sb.toString();
    }
}

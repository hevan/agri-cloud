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
public class MisPurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String orderNo;
    private Long customerId;
    private BigDecimal quantity;
    private BigDecimal amount;
    private Long batchId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updtedAt;
    private String updatedBy;
    private Long corpId;
    private Integer status;
    private LocalDateTime occurAt;
    private Long createdUserId;

    public MisPurchaseOrder() {}

    public MisPurchaseOrder(MisPurchaseOrder value) {
        this.id = value.id;
        this.name = value.name;
        this.orderNo = value.orderNo;
        this.customerId = value.customerId;
        this.quantity = value.quantity;
        this.amount = value.amount;
        this.batchId = value.batchId;
        this.createdAt = value.createdAt;
        this.createdBy = value.createdBy;
        this.updtedAt = value.updtedAt;
        this.updatedBy = value.updatedBy;
        this.corpId = value.corpId;
        this.status = value.status;
        this.occurAt = value.occurAt;
        this.createdUserId = value.createdUserId;
    }

    public MisPurchaseOrder(
        Long id,
        String name,
        String orderNo,
        Long customerId,
        BigDecimal quantity,
        BigDecimal amount,
        Long batchId,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime updtedAt,
        String updatedBy,
        Long corpId,
        Integer status,
        LocalDateTime occurAt,
        Long createdUserId
    ) {
        this.id = id;
        this.name = name;
        this.orderNo = orderNo;
        this.customerId = customerId;
        this.quantity = quantity;
        this.amount = amount;
        this.batchId = batchId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updtedAt = updtedAt;
        this.updatedBy = updatedBy;
        this.corpId = corpId;
        this.status = status;
        this.occurAt = occurAt;
        this.createdUserId = createdUserId;
    }

    /**
     * Getter for <code>public.mis_purchase_order.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.mis_purchase_order.id</code>.
     */
    public MisPurchaseOrder setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.mis_purchase_order.name</code>.
     */
    public MisPurchaseOrder setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.order_no</code>.
     */
    public String getOrderNo() {
        return this.orderNo;
    }

    /**
     * Setter for <code>public.mis_purchase_order.order_no</code>.
     */
    public MisPurchaseOrder setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.customer_id</code>.
     */
    public Long getCustomerId() {
        return this.customerId;
    }

    /**
     * Setter for <code>public.mis_purchase_order.customer_id</code>.
     */
    public MisPurchaseOrder setCustomerId(Long customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.quantity</code>.
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.mis_purchase_order.quantity</code>.
     */
    public MisPurchaseOrder setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.amount</code>.
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Setter for <code>public.mis_purchase_order.amount</code>.
     */
    public MisPurchaseOrder setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.batch_id</code>.
     */
    public Long getBatchId() {
        return this.batchId;
    }

    /**
     * Setter for <code>public.mis_purchase_order.batch_id</code>.
     */
    public MisPurchaseOrder setBatchId(Long batchId) {
        this.batchId = batchId;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.mis_purchase_order.created_at</code>.
     */
    public MisPurchaseOrder setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.created_by</code>.
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>public.mis_purchase_order.created_by</code>.
     */
    public MisPurchaseOrder setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.updted_at</code>.
     */
    public LocalDateTime getUpdtedAt() {
        return this.updtedAt;
    }

    /**
     * Setter for <code>public.mis_purchase_order.updted_at</code>.
     */
    public MisPurchaseOrder setUpdtedAt(LocalDateTime updtedAt) {
        this.updtedAt = updtedAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.updated_by</code>.
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * Setter for <code>public.mis_purchase_order.updated_by</code>.
     */
    public MisPurchaseOrder setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.mis_purchase_order.corp_id</code>.
     */
    public MisPurchaseOrder setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.status</code>.
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.mis_purchase_order.status</code>.
     */
    public MisPurchaseOrder setStatus(Integer status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.occur_at</code>.
     */
    public LocalDateTime getOccurAt() {
        return this.occurAt;
    }

    /**
     * Setter for <code>public.mis_purchase_order.occur_at</code>.
     */
    public MisPurchaseOrder setOccurAt(LocalDateTime occurAt) {
        this.occurAt = occurAt;
        return this;
    }

    /**
     * Getter for <code>public.mis_purchase_order.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return this.createdUserId;
    }

    /**
     * Setter for <code>public.mis_purchase_order.created_user_id</code>.
     */
    public MisPurchaseOrder setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
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
        final MisPurchaseOrder other = (MisPurchaseOrder) obj;
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
        if (this.customerId == null) {
            if (other.customerId != null)
                return false;
        }
        else if (!this.customerId.equals(other.customerId))
            return false;
        if (this.quantity == null) {
            if (other.quantity != null)
                return false;
        }
        else if (!this.quantity.equals(other.quantity))
            return false;
        if (this.amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!this.amount.equals(other.amount))
            return false;
        if (this.batchId == null) {
            if (other.batchId != null)
                return false;
        }
        else if (!this.batchId.equals(other.batchId))
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
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.occurAt == null) {
            if (other.occurAt != null)
                return false;
        }
        else if (!this.occurAt.equals(other.occurAt))
            return false;
        if (this.createdUserId == null) {
            if (other.createdUserId != null)
                return false;
        }
        else if (!this.createdUserId.equals(other.createdUserId))
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
        result = prime * result + ((this.customerId == null) ? 0 : this.customerId.hashCode());
        result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.batchId == null) ? 0 : this.batchId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        result = prime * result + ((this.updtedAt == null) ? 0 : this.updtedAt.hashCode());
        result = prime * result + ((this.updatedBy == null) ? 0 : this.updatedBy.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.occurAt == null) ? 0 : this.occurAt.hashCode());
        result = prime * result + ((this.createdUserId == null) ? 0 : this.createdUserId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MisPurchaseOrder (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(orderNo);
        sb.append(", ").append(customerId);
        sb.append(", ").append(quantity);
        sb.append(", ").append(amount);
        sb.append(", ").append(batchId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(updtedAt);
        sb.append(", ").append(updatedBy);
        sb.append(", ").append(corpId);
        sb.append(", ").append(status);
        sb.append(", ").append(occurAt);
        sb.append(", ").append(createdUserId);

        sb.append(")");
        return sb.toString();
    }
}

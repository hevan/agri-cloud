/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MisStockPlaceItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long stockPlaceId;
    private Long productId;
    private BigDecimal quantity;
    private String boxCode;
    private String productCode;

    public MisStockPlaceItem() {}

    public MisStockPlaceItem(MisStockPlaceItem value) {
        this.id = value.id;
        this.stockPlaceId = value.stockPlaceId;
        this.productId = value.productId;
        this.quantity = value.quantity;
        this.boxCode = value.boxCode;
        this.productCode = value.productCode;
    }

    public MisStockPlaceItem(
        Long id,
        Long stockPlaceId,
        Long productId,
        BigDecimal quantity,
        String boxCode,
        String productCode
    ) {
        this.id = id;
        this.stockPlaceId = stockPlaceId;
        this.productId = productId;
        this.quantity = quantity;
        this.boxCode = boxCode;
        this.productCode = productCode;
    }

    /**
     * Getter for <code>public.mis_stock_place_item.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.mis_stock_place_item.id</code>.
     */
    public MisStockPlaceItem setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_place_item.stock_place_id</code>.
     */
    public Long getStockPlaceId() {
        return this.stockPlaceId;
    }

    /**
     * Setter for <code>public.mis_stock_place_item.stock_place_id</code>.
     */
    public MisStockPlaceItem setStockPlaceId(Long stockPlaceId) {
        this.stockPlaceId = stockPlaceId;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_place_item.product_id</code>.
     */
    public Long getProductId() {
        return this.productId;
    }

    /**
     * Setter for <code>public.mis_stock_place_item.product_id</code>.
     */
    public MisStockPlaceItem setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_place_item.quantity</code>.
     */
    public BigDecimal getQuantity() {
        return this.quantity;
    }

    /**
     * Setter for <code>public.mis_stock_place_item.quantity</code>.
     */
    public MisStockPlaceItem setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_place_item.box_code</code>.
     */
    public String getBoxCode() {
        return this.boxCode;
    }

    /**
     * Setter for <code>public.mis_stock_place_item.box_code</code>.
     */
    public MisStockPlaceItem setBoxCode(String boxCode) {
        this.boxCode = boxCode;
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_place_item.product_code</code>.
     */
    public String getProductCode() {
        return this.productCode;
    }

    /**
     * Setter for <code>public.mis_stock_place_item.product_code</code>.
     */
    public MisStockPlaceItem setProductCode(String productCode) {
        this.productCode = productCode;
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
        final MisStockPlaceItem other = (MisStockPlaceItem) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.stockPlaceId == null) {
            if (other.stockPlaceId != null)
                return false;
        }
        else if (!this.stockPlaceId.equals(other.stockPlaceId))
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
        if (this.boxCode == null) {
            if (other.boxCode != null)
                return false;
        }
        else if (!this.boxCode.equals(other.boxCode))
            return false;
        if (this.productCode == null) {
            if (other.productCode != null)
                return false;
        }
        else if (!this.productCode.equals(other.productCode))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.stockPlaceId == null) ? 0 : this.stockPlaceId.hashCode());
        result = prime * result + ((this.productId == null) ? 0 : this.productId.hashCode());
        result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
        result = prime * result + ((this.boxCode == null) ? 0 : this.boxCode.hashCode());
        result = prime * result + ((this.productCode == null) ? 0 : this.productCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MisStockPlaceItem (");

        sb.append(id);
        sb.append(", ").append(stockPlaceId);
        sb.append(", ").append(productId);
        sb.append(", ").append(quantity);
        sb.append(", ").append(boxCode);
        sb.append(", ").append(productCode);

        sb.append(")");
        return sb.toString();
    }
}

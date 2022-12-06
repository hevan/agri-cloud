/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.MisStockItem;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MisStockItemRecord extends UpdatableRecordImpl<MisStockItemRecord> implements Record13<Long, Long, BigDecimal, BigDecimal, Integer, Long, Long, LocalDate, LocalDateTime, String, LocalDateTime, String, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.mis_stock_item.id</code>.
     */
    public MisStockItemRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mis_stock_item.product_id</code>.
     */
    public MisStockItemRecord setProductId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.product_id</code>.
     */
    public Long getProductId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.mis_stock_item.quantity</code>.
     */
    public MisStockItemRecord setQuantity(BigDecimal value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.quantity</code>.
     */
    public BigDecimal getQuantity() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>public.mis_stock_item.price</code>.
     */
    public MisStockItemRecord setPrice(BigDecimal value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.price</code>.
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.mis_stock_item.direction</code>.
     */
    public MisStockItemRecord setDirection(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.direction</code>.
     */
    public Integer getDirection() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.mis_stock_item.store_id</code>.
     */
    public MisStockItemRecord setStoreId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.store_id</code>.
     */
    public Long getStoreId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.mis_stock_item.stock_id</code>.
     */
    public MisStockItemRecord setStockId(Long value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.stock_id</code>.
     */
    public Long getStockId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.mis_stock_item.occur_at</code>.
     */
    public MisStockItemRecord setOccurAt(LocalDate value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.occur_at</code>.
     */
    public LocalDate getOccurAt() {
        return (LocalDate) get(7);
    }

    /**
     * Setter for <code>public.mis_stock_item.created_at</code>.
     */
    public MisStockItemRecord setCreatedAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>public.mis_stock_item.created_by</code>.
     */
    public MisStockItemRecord setCreatedBy(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.created_by</code>.
     */
    public String getCreatedBy() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.mis_stock_item.updted_at</code>.
     */
    public MisStockItemRecord setUpdtedAt(LocalDateTime value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.updted_at</code>.
     */
    public LocalDateTime getUpdtedAt() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>public.mis_stock_item.updated_by</code>.
     */
    public MisStockItemRecord setUpdatedBy(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.updated_by</code>.
     */
    public String getUpdatedBy() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.mis_stock_item.corp_id</code>.
     */
    public MisStockItemRecord setCorpId(Long value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_stock_item.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Long, Long, BigDecimal, BigDecimal, Integer, Long, Long, LocalDate, LocalDateTime, String, LocalDateTime, String, Long> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Long, Long, BigDecimal, BigDecimal, Integer, Long, Long, LocalDate, LocalDateTime, String, LocalDateTime, String, Long> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MisStockItem.MIS_STOCK_ITEM.ID;
    }

    @Override
    public Field<Long> field2() {
        return MisStockItem.MIS_STOCK_ITEM.PRODUCT_ID;
    }

    @Override
    public Field<BigDecimal> field3() {
        return MisStockItem.MIS_STOCK_ITEM.QUANTITY;
    }

    @Override
    public Field<BigDecimal> field4() {
        return MisStockItem.MIS_STOCK_ITEM.PRICE;
    }

    @Override
    public Field<Integer> field5() {
        return MisStockItem.MIS_STOCK_ITEM.DIRECTION;
    }

    @Override
    public Field<Long> field6() {
        return MisStockItem.MIS_STOCK_ITEM.STORE_ID;
    }

    @Override
    public Field<Long> field7() {
        return MisStockItem.MIS_STOCK_ITEM.STOCK_ID;
    }

    @Override
    public Field<LocalDate> field8() {
        return MisStockItem.MIS_STOCK_ITEM.OCCUR_AT;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return MisStockItem.MIS_STOCK_ITEM.CREATED_AT;
    }

    @Override
    public Field<String> field10() {
        return MisStockItem.MIS_STOCK_ITEM.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return MisStockItem.MIS_STOCK_ITEM.UPDTED_AT;
    }

    @Override
    public Field<String> field12() {
        return MisStockItem.MIS_STOCK_ITEM.UPDATED_BY;
    }

    @Override
    public Field<Long> field13() {
        return MisStockItem.MIS_STOCK_ITEM.CORP_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getProductId();
    }

    @Override
    public BigDecimal component3() {
        return getQuantity();
    }

    @Override
    public BigDecimal component4() {
        return getPrice();
    }

    @Override
    public Integer component5() {
        return getDirection();
    }

    @Override
    public Long component6() {
        return getStoreId();
    }

    @Override
    public Long component7() {
        return getStockId();
    }

    @Override
    public LocalDate component8() {
        return getOccurAt();
    }

    @Override
    public LocalDateTime component9() {
        return getCreatedAt();
    }

    @Override
    public String component10() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component11() {
        return getUpdtedAt();
    }

    @Override
    public String component12() {
        return getUpdatedBy();
    }

    @Override
    public Long component13() {
        return getCorpId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getProductId();
    }

    @Override
    public BigDecimal value3() {
        return getQuantity();
    }

    @Override
    public BigDecimal value4() {
        return getPrice();
    }

    @Override
    public Integer value5() {
        return getDirection();
    }

    @Override
    public Long value6() {
        return getStoreId();
    }

    @Override
    public Long value7() {
        return getStockId();
    }

    @Override
    public LocalDate value8() {
        return getOccurAt();
    }

    @Override
    public LocalDateTime value9() {
        return getCreatedAt();
    }

    @Override
    public String value10() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value11() {
        return getUpdtedAt();
    }

    @Override
    public String value12() {
        return getUpdatedBy();
    }

    @Override
    public Long value13() {
        return getCorpId();
    }

    @Override
    public MisStockItemRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MisStockItemRecord value2(Long value) {
        setProductId(value);
        return this;
    }

    @Override
    public MisStockItemRecord value3(BigDecimal value) {
        setQuantity(value);
        return this;
    }

    @Override
    public MisStockItemRecord value4(BigDecimal value) {
        setPrice(value);
        return this;
    }

    @Override
    public MisStockItemRecord value5(Integer value) {
        setDirection(value);
        return this;
    }

    @Override
    public MisStockItemRecord value6(Long value) {
        setStoreId(value);
        return this;
    }

    @Override
    public MisStockItemRecord value7(Long value) {
        setStockId(value);
        return this;
    }

    @Override
    public MisStockItemRecord value8(LocalDate value) {
        setOccurAt(value);
        return this;
    }

    @Override
    public MisStockItemRecord value9(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public MisStockItemRecord value10(String value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public MisStockItemRecord value11(LocalDateTime value) {
        setUpdtedAt(value);
        return this;
    }

    @Override
    public MisStockItemRecord value12(String value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public MisStockItemRecord value13(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public MisStockItemRecord values(Long value1, Long value2, BigDecimal value3, BigDecimal value4, Integer value5, Long value6, Long value7, LocalDate value8, LocalDateTime value9, String value10, LocalDateTime value11, String value12, Long value13) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MisStockItemRecord
     */
    public MisStockItemRecord() {
        super(MisStockItem.MIS_STOCK_ITEM);
    }

    /**
     * Create a detached, initialised MisStockItemRecord
     */
    public MisStockItemRecord(Long id, Long productId, BigDecimal quantity, BigDecimal price, Integer direction, Long storeId, Long stockId, LocalDate occurAt, LocalDateTime createdAt, String createdBy, LocalDateTime updtedAt, String updatedBy, Long corpId) {
        super(MisStockItem.MIS_STOCK_ITEM);

        setId(id);
        setProductId(productId);
        setQuantity(quantity);
        setPrice(price);
        setDirection(direction);
        setStoreId(storeId);
        setStockId(stockId);
        setOccurAt(occurAt);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setUpdtedAt(updtedAt);
        setUpdatedBy(updatedBy);
        setCorpId(corpId);
    }

    /**
     * Create a detached, initialised MisStockItemRecord
     */
    public MisStockItemRecord(com.agri.mis.db.tables.pojos.MisStockItem value) {
        super(MisStockItem.MIS_STOCK_ITEM);

        if (value != null) {
            setId(value.getId());
            setProductId(value.getProductId());
            setQuantity(value.getQuantity());
            setPrice(value.getPrice());
            setDirection(value.getDirection());
            setStoreId(value.getStoreId());
            setStockId(value.getStockId());
            setOccurAt(value.getOccurAt());
            setCreatedAt(value.getCreatedAt());
            setCreatedBy(value.getCreatedBy());
            setUpdtedAt(value.getUpdtedAt());
            setUpdatedBy(value.getUpdatedBy());
            setCorpId(value.getCorpId());
        }
    }
}

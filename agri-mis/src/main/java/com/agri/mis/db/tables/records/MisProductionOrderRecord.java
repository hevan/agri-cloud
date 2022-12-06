/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.MisProductionOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MisProductionOrderRecord extends UpdatableRecordImpl<MisProductionOrderRecord> implements Record15<Long, String, String, BigDecimal, BigDecimal, Long, String, LocalDateTime, String, LocalDateTime, String, Long, Integer, LocalDateTime, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.mis_production_order.id</code>.
     */
    public MisProductionOrderRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.mis_production_order.name</code>.
     */
    public MisProductionOrderRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.mis_production_order.order_no</code>.
     */
    public MisProductionOrderRecord setOrderNo(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.order_no</code>.
     */
    public String getOrderNo() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.mis_production_order.quantity</code>.
     */
    public MisProductionOrderRecord setQuantity(BigDecimal value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.quantity</code>.
     */
    public BigDecimal getQuantity() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.mis_production_order.amount</code>.
     */
    public MisProductionOrderRecord setAmount(BigDecimal value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>public.mis_production_order.batch_id</code>.
     */
    public MisProductionOrderRecord setBatchId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.batch_id</code>.
     */
    public Long getBatchId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.mis_production_order.batch_name</code>.
     */
    public MisProductionOrderRecord setBatchName(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.batch_name</code>.
     */
    public String getBatchName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.mis_production_order.created_at</code>.
     */
    public MisProductionOrderRecord setCreatedAt(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.mis_production_order.created_by</code>.
     */
    public MisProductionOrderRecord setCreatedBy(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.created_by</code>.
     */
    public String getCreatedBy() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.mis_production_order.updted_at</code>.
     */
    public MisProductionOrderRecord setUpdtedAt(LocalDateTime value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.updted_at</code>.
     */
    public LocalDateTime getUpdtedAt() {
        return (LocalDateTime) get(9);
    }

    /**
     * Setter for <code>public.mis_production_order.updated_by</code>.
     */
    public MisProductionOrderRecord setUpdatedBy(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.updated_by</code>.
     */
    public String getUpdatedBy() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.mis_production_order.corp_id</code>.
     */
    public MisProductionOrderRecord setCorpId(Long value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>public.mis_production_order.status</code>.
     */
    public MisProductionOrderRecord setStatus(Integer value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.status</code>.
     */
    public Integer getStatus() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>public.mis_production_order.occur_at</code>.
     */
    public MisProductionOrderRecord setOccurAt(LocalDateTime value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.occur_at</code>.
     */
    public LocalDateTime getOccurAt() {
        return (LocalDateTime) get(13);
    }

    /**
     * Setter for <code>public.mis_production_order.created_user_id</code>.
     */
    public MisProductionOrderRecord setCreatedUserId(Long value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>public.mis_production_order.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Long, String, String, BigDecimal, BigDecimal, Long, String, LocalDateTime, String, LocalDateTime, String, Long, Integer, LocalDateTime, Long> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Long, String, String, BigDecimal, BigDecimal, Long, String, LocalDateTime, String, LocalDateTime, String, Long, Integer, LocalDateTime, Long> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.ID;
    }

    @Override
    public Field<String> field2() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.NAME;
    }

    @Override
    public Field<String> field3() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.ORDER_NO;
    }

    @Override
    public Field<BigDecimal> field4() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.QUANTITY;
    }

    @Override
    public Field<BigDecimal> field5() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.AMOUNT;
    }

    @Override
    public Field<Long> field6() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.BATCH_ID;
    }

    @Override
    public Field<String> field7() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.BATCH_NAME;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.CREATED_AT;
    }

    @Override
    public Field<String> field9() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.CREATED_BY;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.UPDTED_AT;
    }

    @Override
    public Field<String> field11() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.UPDATED_BY;
    }

    @Override
    public Field<Long> field12() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.CORP_ID;
    }

    @Override
    public Field<Integer> field13() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.STATUS;
    }

    @Override
    public Field<LocalDateTime> field14() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.OCCUR_AT;
    }

    @Override
    public Field<Long> field15() {
        return MisProductionOrder.MIS_PRODUCTION_ORDER.CREATED_USER_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getOrderNo();
    }

    @Override
    public BigDecimal component4() {
        return getQuantity();
    }

    @Override
    public BigDecimal component5() {
        return getAmount();
    }

    @Override
    public Long component6() {
        return getBatchId();
    }

    @Override
    public String component7() {
        return getBatchName();
    }

    @Override
    public LocalDateTime component8() {
        return getCreatedAt();
    }

    @Override
    public String component9() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime component10() {
        return getUpdtedAt();
    }

    @Override
    public String component11() {
        return getUpdatedBy();
    }

    @Override
    public Long component12() {
        return getCorpId();
    }

    @Override
    public Integer component13() {
        return getStatus();
    }

    @Override
    public LocalDateTime component14() {
        return getOccurAt();
    }

    @Override
    public Long component15() {
        return getCreatedUserId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getOrderNo();
    }

    @Override
    public BigDecimal value4() {
        return getQuantity();
    }

    @Override
    public BigDecimal value5() {
        return getAmount();
    }

    @Override
    public Long value6() {
        return getBatchId();
    }

    @Override
    public String value7() {
        return getBatchName();
    }

    @Override
    public LocalDateTime value8() {
        return getCreatedAt();
    }

    @Override
    public String value9() {
        return getCreatedBy();
    }

    @Override
    public LocalDateTime value10() {
        return getUpdtedAt();
    }

    @Override
    public String value11() {
        return getUpdatedBy();
    }

    @Override
    public Long value12() {
        return getCorpId();
    }

    @Override
    public Integer value13() {
        return getStatus();
    }

    @Override
    public LocalDateTime value14() {
        return getOccurAt();
    }

    @Override
    public Long value15() {
        return getCreatedUserId();
    }

    @Override
    public MisProductionOrderRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value3(String value) {
        setOrderNo(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value4(BigDecimal value) {
        setQuantity(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value5(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value6(Long value) {
        setBatchId(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value7(String value) {
        setBatchName(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value8(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value9(String value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value10(LocalDateTime value) {
        setUpdtedAt(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value11(String value) {
        setUpdatedBy(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value12(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value13(Integer value) {
        setStatus(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value14(LocalDateTime value) {
        setOccurAt(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord value15(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public MisProductionOrderRecord values(Long value1, String value2, String value3, BigDecimal value4, BigDecimal value5, Long value6, String value7, LocalDateTime value8, String value9, LocalDateTime value10, String value11, Long value12, Integer value13, LocalDateTime value14, Long value15) {
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
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MisProductionOrderRecord
     */
    public MisProductionOrderRecord() {
        super(MisProductionOrder.MIS_PRODUCTION_ORDER);
    }

    /**
     * Create a detached, initialised MisProductionOrderRecord
     */
    public MisProductionOrderRecord(Long id, String name, String orderNo, BigDecimal quantity, BigDecimal amount, Long batchId, String batchName, LocalDateTime createdAt, String createdBy, LocalDateTime updtedAt, String updatedBy, Long corpId, Integer status, LocalDateTime occurAt, Long createdUserId) {
        super(MisProductionOrder.MIS_PRODUCTION_ORDER);

        setId(id);
        setName(name);
        setOrderNo(orderNo);
        setQuantity(quantity);
        setAmount(amount);
        setBatchId(batchId);
        setBatchName(batchName);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setUpdtedAt(updtedAt);
        setUpdatedBy(updatedBy);
        setCorpId(corpId);
        setStatus(status);
        setOccurAt(occurAt);
        setCreatedUserId(createdUserId);
    }

    /**
     * Create a detached, initialised MisProductionOrderRecord
     */
    public MisProductionOrderRecord(com.agri.mis.db.tables.pojos.MisProductionOrder value) {
        super(MisProductionOrder.MIS_PRODUCTION_ORDER);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setOrderNo(value.getOrderNo());
            setQuantity(value.getQuantity());
            setAmount(value.getAmount());
            setBatchId(value.getBatchId());
            setBatchName(value.getBatchName());
            setCreatedAt(value.getCreatedAt());
            setCreatedBy(value.getCreatedBy());
            setUpdtedAt(value.getUpdtedAt());
            setUpdatedBy(value.getUpdatedBy());
            setCorpId(value.getCorpId());
            setStatus(value.getStatus());
            setOccurAt(value.getOccurAt());
            setCreatedUserId(value.getCreatedUserId());
        }
    }
}

/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.BatchCycleExecute;

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
public class BatchCycleExecuteRecord extends UpdatableRecordImpl<BatchCycleExecuteRecord> implements Record13<Long, String, LocalDateTime, LocalDateTime, Long, String, Long, Short, String, LocalDateTime, Double, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.batch_cycle_execute.id</code>.
     */
    public BatchCycleExecuteRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.name</code>.
     */
    public BatchCycleExecuteRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.start_at</code>.
     */
    public BatchCycleExecuteRecord setStartAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.start_at</code>.
     */
    public LocalDateTime getStartAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.end_at</code>.
     */
    public BatchCycleExecuteRecord setEndAt(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.end_at</code>.
     */
    public LocalDateTime getEndAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.created_user_id</code>.
     */
    public BatchCycleExecuteRecord setCreatedUserId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.created_by</code>.
     */
    public BatchCycleExecuteRecord setCreatedBy(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.created_by</code>.
     */
    public String getCreatedBy() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.batch_cycle_id</code>.
     */
    public BatchCycleExecuteRecord setBatchCycleId(Long value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.batch_cycle_id</code>.
     */
    public Long getBatchCycleId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.status</code>.
     */
    public BatchCycleExecuteRecord setStatus(Short value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.status</code>.
     */
    public Short getStatus() {
        return (Short) get(7);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.description</code>.
     */
    public BatchCycleExecuteRecord setDescription(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.description</code>.
     */
    public String getDescription() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.created_at</code>.
     */
    public BatchCycleExecuteRecord setCreatedAt(LocalDateTime value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(9);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.progress</code>.
     */
    public BatchCycleExecuteRecord setProgress(Double value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.progress</code>.
     */
    public Double getProgress() {
        return (Double) get(10);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.corp_id</code>.
     */
    public BatchCycleExecuteRecord setCorpId(Long value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>public.batch_cycle_execute.batch_id</code>.
     */
    public BatchCycleExecuteRecord setBatchId(Long value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.batch_cycle_execute.batch_id</code>.
     */
    public Long getBatchId() {
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
    public Row13<Long, String, LocalDateTime, LocalDateTime, Long, String, Long, Short, String, LocalDateTime, Double, Long, Long> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Long, String, LocalDateTime, LocalDateTime, Long, String, Long, Short, String, LocalDateTime, Double, Long, Long> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.ID;
    }

    @Override
    public Field<String> field2() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.NAME;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.START_AT;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.END_AT;
    }

    @Override
    public Field<Long> field5() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.CREATED_USER_ID;
    }

    @Override
    public Field<String> field6() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.CREATED_BY;
    }

    @Override
    public Field<Long> field7() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.BATCH_CYCLE_ID;
    }

    @Override
    public Field<Short> field8() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.STATUS;
    }

    @Override
    public Field<String> field9() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.DESCRIPTION;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.CREATED_AT;
    }

    @Override
    public Field<Double> field11() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.PROGRESS;
    }

    @Override
    public Field<Long> field12() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.CORP_ID;
    }

    @Override
    public Field<Long> field13() {
        return BatchCycleExecute.BATCH_CYCLE_EXECUTE.BATCH_ID;
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
    public LocalDateTime component3() {
        return getStartAt();
    }

    @Override
    public LocalDateTime component4() {
        return getEndAt();
    }

    @Override
    public Long component5() {
        return getCreatedUserId();
    }

    @Override
    public String component6() {
        return getCreatedBy();
    }

    @Override
    public Long component7() {
        return getBatchCycleId();
    }

    @Override
    public Short component8() {
        return getStatus();
    }

    @Override
    public String component9() {
        return getDescription();
    }

    @Override
    public LocalDateTime component10() {
        return getCreatedAt();
    }

    @Override
    public Double component11() {
        return getProgress();
    }

    @Override
    public Long component12() {
        return getCorpId();
    }

    @Override
    public Long component13() {
        return getBatchId();
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
    public LocalDateTime value3() {
        return getStartAt();
    }

    @Override
    public LocalDateTime value4() {
        return getEndAt();
    }

    @Override
    public Long value5() {
        return getCreatedUserId();
    }

    @Override
    public String value6() {
        return getCreatedBy();
    }

    @Override
    public Long value7() {
        return getBatchCycleId();
    }

    @Override
    public Short value8() {
        return getStatus();
    }

    @Override
    public String value9() {
        return getDescription();
    }

    @Override
    public LocalDateTime value10() {
        return getCreatedAt();
    }

    @Override
    public Double value11() {
        return getProgress();
    }

    @Override
    public Long value12() {
        return getCorpId();
    }

    @Override
    public Long value13() {
        return getBatchId();
    }

    @Override
    public BatchCycleExecuteRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value3(LocalDateTime value) {
        setStartAt(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value4(LocalDateTime value) {
        setEndAt(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value5(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value6(String value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value7(Long value) {
        setBatchCycleId(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value8(Short value) {
        setStatus(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value9(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value10(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value11(Double value) {
        setProgress(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value12(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord value13(Long value) {
        setBatchId(value);
        return this;
    }

    @Override
    public BatchCycleExecuteRecord values(Long value1, String value2, LocalDateTime value3, LocalDateTime value4, Long value5, String value6, Long value7, Short value8, String value9, LocalDateTime value10, Double value11, Long value12, Long value13) {
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
     * Create a detached BatchCycleExecuteRecord
     */
    public BatchCycleExecuteRecord() {
        super(BatchCycleExecute.BATCH_CYCLE_EXECUTE);
    }

    /**
     * Create a detached, initialised BatchCycleExecuteRecord
     */
    public BatchCycleExecuteRecord(Long id, String name, LocalDateTime startAt, LocalDateTime endAt, Long createdUserId, String createdBy, Long batchCycleId, Short status, String description, LocalDateTime createdAt, Double progress, Long corpId, Long batchId) {
        super(BatchCycleExecute.BATCH_CYCLE_EXECUTE);

        setId(id);
        setName(name);
        setStartAt(startAt);
        setEndAt(endAt);
        setCreatedUserId(createdUserId);
        setCreatedBy(createdBy);
        setBatchCycleId(batchCycleId);
        setStatus(status);
        setDescription(description);
        setCreatedAt(createdAt);
        setProgress(progress);
        setCorpId(corpId);
        setBatchId(batchId);
    }

    /**
     * Create a detached, initialised BatchCycleExecuteRecord
     */
    public BatchCycleExecuteRecord(com.agri.mis.db.tables.pojos.BatchCycleExecute value) {
        super(BatchCycleExecute.BATCH_CYCLE_EXECUTE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setStartAt(value.getStartAt());
            setEndAt(value.getEndAt());
            setCreatedUserId(value.getCreatedUserId());
            setCreatedBy(value.getCreatedBy());
            setBatchCycleId(value.getBatchCycleId());
            setStatus(value.getStatus());
            setDescription(value.getDescription());
            setCreatedAt(value.getCreatedAt());
            setProgress(value.getProgress());
            setCorpId(value.getCorpId());
            setBatchId(value.getBatchId());
        }
    }
}

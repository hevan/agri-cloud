/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CheckTrace;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CheckTraceRecord extends UpdatableRecordImpl<CheckTraceRecord> implements Record10<Long, String, Long, Long, Integer, Long, LocalDateTime, String, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.check_trace.id</code>.
     */
    public CheckTraceRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.check_trace.entity_name</code>.
     */
    public CheckTraceRecord setEntityName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.entity_name</code>.
     */
    public String getEntityName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.check_trace.entity_id</code>.
     */
    public CheckTraceRecord setEntityId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.entity_id</code>.
     */
    public Long getEntityId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.check_trace.user_id</code>.
     */
    public CheckTraceRecord setUserId(Long value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.user_id</code>.
     */
    public Long getUserId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>public.check_trace.status</code>.
     */
    public CheckTraceRecord setStatus(Integer value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.status</code>.
     */
    public Integer getStatus() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.check_trace.corp_id</code>.
     */
    public CheckTraceRecord setCorpId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.check_trace.created_at</code>.
     */
    public CheckTraceRecord setCreatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.check_trace.title</code>.
     */
    public CheckTraceRecord setTitle(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.title</code>.
     */
    public String getTitle() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.check_trace.description</code>.
     */
    public CheckTraceRecord setDescription(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.description</code>.
     */
    public String getDescription() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.check_trace.updated_at</code>.
     */
    public CheckTraceRecord setUpdatedAt(LocalDateTime value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.check_trace.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, Long, Long, Integer, Long, LocalDateTime, String, String, LocalDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, String, Long, Long, Integer, Long, LocalDateTime, String, String, LocalDateTime> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CheckTrace.CHECK_TRACE.ID;
    }

    @Override
    public Field<String> field2() {
        return CheckTrace.CHECK_TRACE.ENTITY_NAME;
    }

    @Override
    public Field<Long> field3() {
        return CheckTrace.CHECK_TRACE.ENTITY_ID;
    }

    @Override
    public Field<Long> field4() {
        return CheckTrace.CHECK_TRACE.USER_ID;
    }

    @Override
    public Field<Integer> field5() {
        return CheckTrace.CHECK_TRACE.STATUS;
    }

    @Override
    public Field<Long> field6() {
        return CheckTrace.CHECK_TRACE.CORP_ID;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return CheckTrace.CHECK_TRACE.CREATED_AT;
    }

    @Override
    public Field<String> field8() {
        return CheckTrace.CHECK_TRACE.TITLE;
    }

    @Override
    public Field<String> field9() {
        return CheckTrace.CHECK_TRACE.DESCRIPTION;
    }

    @Override
    public Field<LocalDateTime> field10() {
        return CheckTrace.CHECK_TRACE.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEntityName();
    }

    @Override
    public Long component3() {
        return getEntityId();
    }

    @Override
    public Long component4() {
        return getUserId();
    }

    @Override
    public Integer component5() {
        return getStatus();
    }

    @Override
    public Long component6() {
        return getCorpId();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedAt();
    }

    @Override
    public String component8() {
        return getTitle();
    }

    @Override
    public String component9() {
        return getDescription();
    }

    @Override
    public LocalDateTime component10() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEntityName();
    }

    @Override
    public Long value3() {
        return getEntityId();
    }

    @Override
    public Long value4() {
        return getUserId();
    }

    @Override
    public Integer value5() {
        return getStatus();
    }

    @Override
    public Long value6() {
        return getCorpId();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedAt();
    }

    @Override
    public String value8() {
        return getTitle();
    }

    @Override
    public String value9() {
        return getDescription();
    }

    @Override
    public LocalDateTime value10() {
        return getUpdatedAt();
    }

    @Override
    public CheckTraceRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CheckTraceRecord value2(String value) {
        setEntityName(value);
        return this;
    }

    @Override
    public CheckTraceRecord value3(Long value) {
        setEntityId(value);
        return this;
    }

    @Override
    public CheckTraceRecord value4(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public CheckTraceRecord value5(Integer value) {
        setStatus(value);
        return this;
    }

    @Override
    public CheckTraceRecord value6(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public CheckTraceRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public CheckTraceRecord value8(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public CheckTraceRecord value9(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CheckTraceRecord value10(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public CheckTraceRecord values(Long value1, String value2, Long value3, Long value4, Integer value5, Long value6, LocalDateTime value7, String value8, String value9, LocalDateTime value10) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CheckTraceRecord
     */
    public CheckTraceRecord() {
        super(CheckTrace.CHECK_TRACE);
    }

    /**
     * Create a detached, initialised CheckTraceRecord
     */
    public CheckTraceRecord(Long id, String entityName, Long entityId, Long userId, Integer status, Long corpId, LocalDateTime createdAt, String title, String description, LocalDateTime updatedAt) {
        super(CheckTrace.CHECK_TRACE);

        setId(id);
        setEntityName(entityName);
        setEntityId(entityId);
        setUserId(userId);
        setStatus(status);
        setCorpId(corpId);
        setCreatedAt(createdAt);
        setTitle(title);
        setDescription(description);
        setUpdatedAt(updatedAt);
    }

    /**
     * Create a detached, initialised CheckTraceRecord
     */
    public CheckTraceRecord(com.agri.mis.db.tables.pojos.CheckTrace value) {
        super(CheckTrace.CHECK_TRACE);

        if (value != null) {
            setId(value.getId());
            setEntityName(value.getEntityName());
            setEntityId(value.getEntityId());
            setUserId(value.getUserId());
            setStatus(value.getStatus());
            setCorpId(value.getCorpId());
            setCreatedAt(value.getCreatedAt());
            setTitle(value.getTitle());
            setDescription(value.getDescription());
            setUpdatedAt(value.getUpdatedAt());
        }
    }
}

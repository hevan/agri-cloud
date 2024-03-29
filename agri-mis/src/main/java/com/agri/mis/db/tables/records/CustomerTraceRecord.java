/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CustomerTrace;

import java.time.LocalDate;
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
public class CustomerTraceRecord extends UpdatableRecordImpl<CustomerTraceRecord> implements Record10<Long, Long, String, String, String, String, LocalDateTime, Long, LocalDate, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.customer_trace.id</code>.
     */
    public CustomerTraceRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.customer_trace.customer_id</code>.
     */
    public CustomerTraceRecord setCustomerId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.customer_id</code>.
     */
    public Long getCustomerId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.customer_trace.description</code>.
     */
    public CustomerTraceRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.customer_trace.title</code>.
     */
    public CustomerTraceRecord setTitle(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.title</code>.
     */
    public String getTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.customer_trace.link_name</code>.
     */
    public CustomerTraceRecord setLinkName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.link_name</code>.
     */
    public String getLinkName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.customer_trace.link_mobile</code>.
     */
    public CustomerTraceRecord setLinkMobile(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.link_mobile</code>.
     */
    public String getLinkMobile() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.customer_trace.created_at</code>.
     */
    public CustomerTraceRecord setCreatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.customer_trace.corp_id</code>.
     */
    public CustomerTraceRecord setCorpId(Long value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.customer_trace.occur_at</code>.
     */
    public CustomerTraceRecord setOccurAt(LocalDate value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.occur_at</code>.
     */
    public LocalDate getOccurAt() {
        return (LocalDate) get(8);
    }

    /**
     * Setter for <code>public.customer_trace.created_user_id</code>.
     */
    public CustomerTraceRecord setCreatedUserId(Long value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.customer_trace.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(9);
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
    public Row10<Long, Long, String, String, String, String, LocalDateTime, Long, LocalDate, Long> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Long, Long, String, String, String, String, LocalDateTime, Long, LocalDate, Long> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CustomerTrace.CUSTOMER_TRACE.ID;
    }

    @Override
    public Field<Long> field2() {
        return CustomerTrace.CUSTOMER_TRACE.CUSTOMER_ID;
    }

    @Override
    public Field<String> field3() {
        return CustomerTrace.CUSTOMER_TRACE.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return CustomerTrace.CUSTOMER_TRACE.TITLE;
    }

    @Override
    public Field<String> field5() {
        return CustomerTrace.CUSTOMER_TRACE.LINK_NAME;
    }

    @Override
    public Field<String> field6() {
        return CustomerTrace.CUSTOMER_TRACE.LINK_MOBILE;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return CustomerTrace.CUSTOMER_TRACE.CREATED_AT;
    }

    @Override
    public Field<Long> field8() {
        return CustomerTrace.CUSTOMER_TRACE.CORP_ID;
    }

    @Override
    public Field<LocalDate> field9() {
        return CustomerTrace.CUSTOMER_TRACE.OCCUR_AT;
    }

    @Override
    public Field<Long> field10() {
        return CustomerTrace.CUSTOMER_TRACE.CREATED_USER_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getCustomerId();
    }

    @Override
    public String component3() {
        return getDescription();
    }

    @Override
    public String component4() {
        return getTitle();
    }

    @Override
    public String component5() {
        return getLinkName();
    }

    @Override
    public String component6() {
        return getLinkMobile();
    }

    @Override
    public LocalDateTime component7() {
        return getCreatedAt();
    }

    @Override
    public Long component8() {
        return getCorpId();
    }

    @Override
    public LocalDate component9() {
        return getOccurAt();
    }

    @Override
    public Long component10() {
        return getCreatedUserId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getCustomerId();
    }

    @Override
    public String value3() {
        return getDescription();
    }

    @Override
    public String value4() {
        return getTitle();
    }

    @Override
    public String value5() {
        return getLinkName();
    }

    @Override
    public String value6() {
        return getLinkMobile();
    }

    @Override
    public LocalDateTime value7() {
        return getCreatedAt();
    }

    @Override
    public Long value8() {
        return getCorpId();
    }

    @Override
    public LocalDate value9() {
        return getOccurAt();
    }

    @Override
    public Long value10() {
        return getCreatedUserId();
    }

    @Override
    public CustomerTraceRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value2(Long value) {
        setCustomerId(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value4(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value5(String value) {
        setLinkName(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value6(String value) {
        setLinkMobile(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value7(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value8(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value9(LocalDate value) {
        setOccurAt(value);
        return this;
    }

    @Override
    public CustomerTraceRecord value10(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public CustomerTraceRecord values(Long value1, Long value2, String value3, String value4, String value5, String value6, LocalDateTime value7, Long value8, LocalDate value9, Long value10) {
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
     * Create a detached CustomerTraceRecord
     */
    public CustomerTraceRecord() {
        super(CustomerTrace.CUSTOMER_TRACE);
    }

    /**
     * Create a detached, initialised CustomerTraceRecord
     */
    public CustomerTraceRecord(Long id, Long customerId, String description, String title, String linkName, String linkMobile, LocalDateTime createdAt, Long corpId, LocalDate occurAt, Long createdUserId) {
        super(CustomerTrace.CUSTOMER_TRACE);

        setId(id);
        setCustomerId(customerId);
        setDescription(description);
        setTitle(title);
        setLinkName(linkName);
        setLinkMobile(linkMobile);
        setCreatedAt(createdAt);
        setCorpId(corpId);
        setOccurAt(occurAt);
        setCreatedUserId(createdUserId);
    }

    /**
     * Create a detached, initialised CustomerTraceRecord
     */
    public CustomerTraceRecord(com.agri.mis.db.tables.pojos.CustomerTrace value) {
        super(CustomerTrace.CUSTOMER_TRACE);

        if (value != null) {
            setId(value.getId());
            setCustomerId(value.getCustomerId());
            setDescription(value.getDescription());
            setTitle(value.getTitle());
            setLinkName(value.getLinkName());
            setLinkMobile(value.getLinkMobile());
            setCreatedAt(value.getCreatedAt());
            setCorpId(value.getCorpId());
            setOccurAt(value.getOccurAt());
            setCreatedUserId(value.getCreatedUserId());
        }
    }
}

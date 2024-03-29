/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.CustomerTraceRecord;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function10;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerTrace extends TableImpl<CustomerTraceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.customer_trace</code>
     */
    public static final CustomerTrace CUSTOMER_TRACE = new CustomerTrace();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CustomerTraceRecord> getRecordType() {
        return CustomerTraceRecord.class;
    }

    /**
     * The column <code>public.customer_trace.id</code>.
     */
    public final TableField<CustomerTraceRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.customer_trace.customer_id</code>.
     */
    public final TableField<CustomerTraceRecord, Long> CUSTOMER_ID = createField(DSL.name("customer_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.customer_trace.description</code>.
     */
    public final TableField<CustomerTraceRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(500).nullable(false), this, "");

    /**
     * The column <code>public.customer_trace.title</code>.
     */
    public final TableField<CustomerTraceRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.customer_trace.link_name</code>.
     */
    public final TableField<CustomerTraceRecord, String> LINK_NAME = createField(DSL.name("link_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.customer_trace.link_mobile</code>.
     */
    public final TableField<CustomerTraceRecord, String> LINK_MOBILE = createField(DSL.name("link_mobile"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.customer_trace.created_at</code>.
     */
    public final TableField<CustomerTraceRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.customer_trace.corp_id</code>.
     */
    public final TableField<CustomerTraceRecord, Long> CORP_ID = createField(DSL.name("corp_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.customer_trace.occur_at</code>.
     */
    public final TableField<CustomerTraceRecord, LocalDate> OCCUR_AT = createField(DSL.name("occur_at"), SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>public.customer_trace.created_user_id</code>.
     */
    public final TableField<CustomerTraceRecord, Long> CREATED_USER_ID = createField(DSL.name("created_user_id"), SQLDataType.BIGINT, this, "");

    private CustomerTrace(Name alias, Table<CustomerTraceRecord> aliased) {
        this(alias, aliased, null);
    }

    private CustomerTrace(Name alias, Table<CustomerTraceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.customer_trace</code> table reference
     */
    public CustomerTrace(String alias) {
        this(DSL.name(alias), CUSTOMER_TRACE);
    }

    /**
     * Create an aliased <code>public.customer_trace</code> table reference
     */
    public CustomerTrace(Name alias) {
        this(alias, CUSTOMER_TRACE);
    }

    /**
     * Create a <code>public.customer_trace</code> table reference
     */
    public CustomerTrace() {
        this(DSL.name("customer_trace"), null);
    }

    public <O extends Record> CustomerTrace(Table<O> child, ForeignKey<O, CustomerTraceRecord> key) {
        super(child, key, CUSTOMER_TRACE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CustomerTraceRecord, Long> getIdentity() {
        return (Identity<CustomerTraceRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CustomerTraceRecord> getPrimaryKey() {
        return Keys.CUSTOMER_TRACE_PKEY;
    }

    @Override
    public CustomerTrace as(String alias) {
        return new CustomerTrace(DSL.name(alias), this);
    }

    @Override
    public CustomerTrace as(Name alias) {
        return new CustomerTrace(alias, this);
    }

    @Override
    public CustomerTrace as(Table<?> alias) {
        return new CustomerTrace(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerTrace rename(String name) {
        return new CustomerTrace(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerTrace rename(Name name) {
        return new CustomerTrace(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public CustomerTrace rename(Table<?> name) {
        return new CustomerTrace(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, Long, String, String, String, String, LocalDateTime, Long, LocalDate, Long> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super Long, ? super Long, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super Long, ? super LocalDate, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super Long, ? super Long, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super Long, ? super LocalDate, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

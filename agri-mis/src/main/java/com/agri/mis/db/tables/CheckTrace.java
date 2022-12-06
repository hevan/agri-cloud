/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.CheckTraceRecord;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
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
public class CheckTrace extends TableImpl<CheckTraceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.check_trace</code>
     */
    public static final CheckTrace CHECK_TRACE = new CheckTrace();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CheckTraceRecord> getRecordType() {
        return CheckTraceRecord.class;
    }

    /**
     * The column <code>public.check_trace.id</code>.
     */
    public final TableField<CheckTraceRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.check_trace.entity_name</code>.
     */
    public final TableField<CheckTraceRecord, String> ENTITY_NAME = createField(DSL.name("entity_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.check_trace.entity_id</code>.
     */
    public final TableField<CheckTraceRecord, Long> ENTITY_ID = createField(DSL.name("entity_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.check_trace.user_id</code>.
     */
    public final TableField<CheckTraceRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.check_trace.status</code>.
     */
    public final TableField<CheckTraceRecord, Integer> STATUS = createField(DSL.name("status"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.check_trace.corp_id</code>.
     */
    public final TableField<CheckTraceRecord, Long> CORP_ID = createField(DSL.name("corp_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.check_trace.created_at</code>.
     */
    public final TableField<CheckTraceRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).nullable(false), this, "");

    /**
     * The column <code>public.check_trace.title</code>.
     */
    public final TableField<CheckTraceRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.check_trace.description</code>.
     */
    public final TableField<CheckTraceRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(500).nullable(false), this, "");

    private CheckTrace(Name alias, Table<CheckTraceRecord> aliased) {
        this(alias, aliased, null);
    }

    private CheckTrace(Name alias, Table<CheckTraceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.check_trace</code> table reference
     */
    public CheckTrace(String alias) {
        this(DSL.name(alias), CHECK_TRACE);
    }

    /**
     * Create an aliased <code>public.check_trace</code> table reference
     */
    public CheckTrace(Name alias) {
        this(alias, CHECK_TRACE);
    }

    /**
     * Create a <code>public.check_trace</code> table reference
     */
    public CheckTrace() {
        this(DSL.name("check_trace"), null);
    }

    public <O extends Record> CheckTrace(Table<O> child, ForeignKey<O, CheckTraceRecord> key) {
        super(child, key, CHECK_TRACE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CheckTraceRecord, Long> getIdentity() {
        return (Identity<CheckTraceRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CheckTraceRecord> getPrimaryKey() {
        return Keys.CHECK_TRACE_PKEY;
    }

    @Override
    public CheckTrace as(String alias) {
        return new CheckTrace(DSL.name(alias), this);
    }

    @Override
    public CheckTrace as(Name alias) {
        return new CheckTrace(alias, this);
    }

    @Override
    public CheckTrace as(Table<?> alias) {
        return new CheckTrace(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public CheckTrace rename(String name) {
        return new CheckTrace(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CheckTrace rename(Name name) {
        return new CheckTrace(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public CheckTrace rename(Table<?> name) {
        return new CheckTrace(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, Long, Long, Integer, Long, LocalDateTime, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super Long, ? super String, ? super Long, ? super Long, ? super Integer, ? super Long, ? super LocalDateTime, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super Long, ? super String, ? super Long, ? super Long, ? super Integer, ? super Long, ? super LocalDateTime, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

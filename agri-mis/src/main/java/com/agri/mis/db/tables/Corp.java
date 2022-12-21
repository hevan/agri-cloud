/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.CorpRecord;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Corp extends TableImpl<CorpRecord> {


    /**
     * The reference instance of <code>public.corp</code>
     */
    public static final Corp CORP = new Corp();
    public static final SelectFieldOrAsterisk ADDRESS = new Address();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CorpRecord> getRecordType() {
        return CorpRecord.class;
    }

    /**
     * The column <code>public.corp.id</code>.
     */
    public final TableField<CorpRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.corp.name</code>.
     */
    public final TableField<CorpRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.corp.code</code>.
     */
    public final TableField<CorpRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.corp.description</code>.
     */
    public final TableField<CorpRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.corp.address_id</code>.
     */
    public final TableField<CorpRecord, Long> ADDRESS_ID = createField(DSL.name("address_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.corp.created_at</code>.
     */
    public final TableField<CorpRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    private Corp(Name alias, Table<CorpRecord> aliased) {
        this(alias, aliased, null);
    }

    private Corp(Name alias, Table<CorpRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.corp</code> table reference
     */
    public Corp(String alias) {
        this(DSL.name(alias), CORP);
    }

    /**
     * Create an aliased <code>public.corp</code> table reference
     */
    public Corp(Name alias) {
        this(alias, CORP);
    }

    /**
     * Create a <code>public.corp</code> table reference
     */
    public Corp() {
        this(DSL.name("corp"), null);
    }

    public <O extends Record> Corp(Table<O> child, ForeignKey<O, CorpRecord> key) {
        super(child, key, CORP);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CorpRecord, Long> getIdentity() {
        return (Identity<CorpRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CorpRecord> getPrimaryKey() {
        return Keys.CORP_PKEY;
    }

    @Override
    public Corp as(String alias) {
        return new Corp(DSL.name(alias), this);
    }

    @Override
    public Corp as(Name alias) {
        return new Corp(alias, this);
    }

    @Override
    public Corp as(Table<?> alias) {
        return new Corp(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Corp rename(String name) {
        return new Corp(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Corp rename(Name name) {
        return new Corp(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Corp rename(Table<?> name) {
        return new Corp(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Long, String, String, String, Long, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super String, ? super String, ? super String, ? super Long, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super String, ? super String, ? super String, ? super Long, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

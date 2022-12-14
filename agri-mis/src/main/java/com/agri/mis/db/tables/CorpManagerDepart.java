/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.CorpManagerDepartRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class CorpManagerDepart extends TableImpl<CorpManagerDepartRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.corp_manager_depart</code>
     */
    public static final CorpManagerDepart CORP_MANAGER_DEPART = new CorpManagerDepart();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CorpManagerDepartRecord> getRecordType() {
        return CorpManagerDepartRecord.class;
    }

    /**
     * The column <code>public.corp_manager_depart.id</code>.
     */
    public final TableField<CorpManagerDepartRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.corp_manager_depart.manager_id</code>.
     */
    public final TableField<CorpManagerDepartRecord, Long> MANAGER_ID = createField(DSL.name("manager_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.corp_manager_depart.depart_id</code>.
     */
    public final TableField<CorpManagerDepartRecord, Long> DEPART_ID = createField(DSL.name("depart_id"), SQLDataType.BIGINT.nullable(false), this, "");

    private CorpManagerDepart(Name alias, Table<CorpManagerDepartRecord> aliased) {
        this(alias, aliased, null);
    }

    private CorpManagerDepart(Name alias, Table<CorpManagerDepartRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.corp_manager_depart</code> table reference
     */
    public CorpManagerDepart(String alias) {
        this(DSL.name(alias), CORP_MANAGER_DEPART);
    }

    /**
     * Create an aliased <code>public.corp_manager_depart</code> table reference
     */
    public CorpManagerDepart(Name alias) {
        this(alias, CORP_MANAGER_DEPART);
    }

    /**
     * Create a <code>public.corp_manager_depart</code> table reference
     */
    public CorpManagerDepart() {
        this(DSL.name("corp_manager_depart"), null);
    }

    public <O extends Record> CorpManagerDepart(Table<O> child, ForeignKey<O, CorpManagerDepartRecord> key) {
        super(child, key, CORP_MANAGER_DEPART);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CorpManagerDepartRecord, Long> getIdentity() {
        return (Identity<CorpManagerDepartRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CorpManagerDepartRecord> getPrimaryKey() {
        return Keys.CORP_MANAGER_DEPART_PKEY;
    }

    @Override
    public CorpManagerDepart as(String alias) {
        return new CorpManagerDepart(DSL.name(alias), this);
    }

    @Override
    public CorpManagerDepart as(Name alias) {
        return new CorpManagerDepart(alias, this);
    }

    @Override
    public CorpManagerDepart as(Table<?> alias) {
        return new CorpManagerDepart(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public CorpManagerDepart rename(String name) {
        return new CorpManagerDepart(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CorpManagerDepart rename(Name name) {
        return new CorpManagerDepart(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public CorpManagerDepart rename(Table<?> name) {
        return new CorpManagerDepart(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Long, ? super Long, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Long, ? super Long, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

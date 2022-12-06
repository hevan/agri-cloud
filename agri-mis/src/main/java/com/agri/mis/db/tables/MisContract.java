/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.MisContractRecord;

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
public class MisContract extends TableImpl<MisContractRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.mis_contract</code>
     */
    public static final MisContract MIS_CONTRACT = new MisContract();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MisContractRecord> getRecordType() {
        return MisContractRecord.class;
    }

    /**
     * The column <code>public.mis_contract.id</code>.
     */
    public final TableField<MisContractRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.mis_contract.name</code>.
     */
    public final TableField<MisContractRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.mis_contract.code</code>.
     */
    public final TableField<MisContractRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.mis_contract.description</code>.
     */
    public final TableField<MisContractRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(500), this, "");

    /**
     * The column <code>public.mis_contract.customer_id</code>.
     */
    public final TableField<MisContractRecord, Long> CUSTOMER_ID = createField(DSL.name("customer_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_contract.start_at</code>.
     */
    public final TableField<MisContractRecord, LocalDate> START_AT = createField(DSL.name("start_at"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.mis_contract.end_at</code>.
     */
    public final TableField<MisContractRecord, LocalDate> END_AT = createField(DSL.name("end_at"), SQLDataType.LOCALDATE, this, "");

    /**
     * The column <code>public.mis_contract.created_at</code>.
     */
    public final TableField<MisContractRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.mis_contract.corp_id</code>.
     */
    public final TableField<MisContractRecord, Long> CORP_ID = createField(DSL.name("corp_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mis_contract.sign_at</code>.
     */
    public final TableField<MisContractRecord, LocalDate> SIGN_AT = createField(DSL.name("sign_at"), SQLDataType.LOCALDATE.nullable(false), this, "");

    private MisContract(Name alias, Table<MisContractRecord> aliased) {
        this(alias, aliased, null);
    }

    private MisContract(Name alias, Table<MisContractRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.mis_contract</code> table reference
     */
    public MisContract(String alias) {
        this(DSL.name(alias), MIS_CONTRACT);
    }

    /**
     * Create an aliased <code>public.mis_contract</code> table reference
     */
    public MisContract(Name alias) {
        this(alias, MIS_CONTRACT);
    }

    /**
     * Create a <code>public.mis_contract</code> table reference
     */
    public MisContract() {
        this(DSL.name("mis_contract"), null);
    }

    public <O extends Record> MisContract(Table<O> child, ForeignKey<O, MisContractRecord> key) {
        super(child, key, MIS_CONTRACT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<MisContractRecord, Long> getIdentity() {
        return (Identity<MisContractRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<MisContractRecord> getPrimaryKey() {
        return Keys.CONTRACT_PKEY;
    }

    @Override
    public MisContract as(String alias) {
        return new MisContract(DSL.name(alias), this);
    }

    @Override
    public MisContract as(Name alias) {
        return new MisContract(alias, this);
    }

    @Override
    public MisContract as(Table<?> alias) {
        return new MisContract(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public MisContract rename(String name) {
        return new MisContract(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MisContract rename(Name name) {
        return new MisContract(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public MisContract rename(Table<?> name) {
        return new MisContract(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, String, Long, LocalDate, LocalDate, LocalDateTime, Long, LocalDate> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super Long, ? super String, ? super String, ? super String, ? super Long, ? super LocalDate, ? super LocalDate, ? super LocalDateTime, ? super Long, ? super LocalDate, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super Long, ? super String, ? super String, ? super String, ? super Long, ? super LocalDate, ? super LocalDate, ? super LocalDateTime, ? super Long, ? super LocalDate, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.SysMenuActionRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
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
public class SysMenuAction extends TableImpl<SysMenuActionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.sys_menu_action</code>
     */
    public static final SysMenuAction SYS_MENU_ACTION = new SysMenuAction();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysMenuActionRecord> getRecordType() {
        return SysMenuActionRecord.class;
    }

    /**
     * The column <code>public.sys_menu_action.id</code>.
     */
    public final TableField<SysMenuActionRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.sys_menu_action.menu_id</code>.
     */
    public final TableField<SysMenuActionRecord, Long> MENU_ID = createField(DSL.name("menu_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.sys_menu_action.name</code>.
     */
    public final TableField<SysMenuActionRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    /**
     * The column <code>public.sys_menu_action.code</code>.
     */
    public final TableField<SysMenuActionRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR(50).nullable(false), this, "");

    private SysMenuAction(Name alias, Table<SysMenuActionRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysMenuAction(Name alias, Table<SysMenuActionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.sys_menu_action</code> table reference
     */
    public SysMenuAction(String alias) {
        this(DSL.name(alias), SYS_MENU_ACTION);
    }

    /**
     * Create an aliased <code>public.sys_menu_action</code> table reference
     */
    public SysMenuAction(Name alias) {
        this(alias, SYS_MENU_ACTION);
    }

    /**
     * Create a <code>public.sys_menu_action</code> table reference
     */
    public SysMenuAction() {
        this(DSL.name("sys_menu_action"), null);
    }

    public <O extends Record> SysMenuAction(Table<O> child, ForeignKey<O, SysMenuActionRecord> key) {
        super(child, key, SYS_MENU_ACTION);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<SysMenuActionRecord, Long> getIdentity() {
        return (Identity<SysMenuActionRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<SysMenuActionRecord> getPrimaryKey() {
        return Keys.SYS_MENU_ACTION_PKEY;
    }

    @Override
    public SysMenuAction as(String alias) {
        return new SysMenuAction(DSL.name(alias), this);
    }

    @Override
    public SysMenuAction as(Name alias) {
        return new SysMenuAction(alias, this);
    }

    @Override
    public SysMenuAction as(Table<?> alias) {
        return new SysMenuAction(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysMenuAction rename(String name) {
        return new SysMenuAction(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysMenuAction rename(Name name) {
        return new SysMenuAction(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SysMenuAction rename(Table<?> name) {
        return new SysMenuAction(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super Long, ? super Long, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super Long, ? super Long, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

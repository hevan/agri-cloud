/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.SysMenuAction;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysMenuActionRecord extends UpdatableRecordImpl<SysMenuActionRecord> implements Record4<Long, Long, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.sys_menu_action.id</code>.
     */
    public SysMenuActionRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.sys_menu_action.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.sys_menu_action.menu_id</code>.
     */
    public SysMenuActionRecord setMenuId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.sys_menu_action.menu_id</code>.
     */
    public Long getMenuId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.sys_menu_action.name</code>.
     */
    public SysMenuActionRecord setName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.sys_menu_action.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.sys_menu_action.code</code>.
     */
    public SysMenuActionRecord setCode(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.sys_menu_action.code</code>.
     */
    public String getCode() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Long, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Long, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return SysMenuAction.SYS_MENU_ACTION.ID;
    }

    @Override
    public Field<Long> field2() {
        return SysMenuAction.SYS_MENU_ACTION.MENU_ID;
    }

    @Override
    public Field<String> field3() {
        return SysMenuAction.SYS_MENU_ACTION.NAME;
    }

    @Override
    public Field<String> field4() {
        return SysMenuAction.SYS_MENU_ACTION.CODE;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getMenuId();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public String component4() {
        return getCode();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getMenuId();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public String value4() {
        return getCode();
    }

    @Override
    public SysMenuActionRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public SysMenuActionRecord value2(Long value) {
        setMenuId(value);
        return this;
    }

    @Override
    public SysMenuActionRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public SysMenuActionRecord value4(String value) {
        setCode(value);
        return this;
    }

    @Override
    public SysMenuActionRecord values(Long value1, Long value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysMenuActionRecord
     */
    public SysMenuActionRecord() {
        super(SysMenuAction.SYS_MENU_ACTION);
    }

    /**
     * Create a detached, initialised SysMenuActionRecord
     */
    public SysMenuActionRecord(Long id, Long menuId, String name, String code) {
        super(SysMenuAction.SYS_MENU_ACTION);

        setId(id);
        setMenuId(menuId);
        setName(name);
        setCode(code);
    }

    /**
     * Create a detached, initialised SysMenuActionRecord
     */
    public SysMenuActionRecord(com.agri.mis.db.tables.pojos.SysMenuAction value) {
        super(SysMenuAction.SYS_MENU_ACTION);

        if (value != null) {
            setId(value.getId());
            setMenuId(value.getMenuId());
            setName(value.getName());
            setCode(value.getCode());
        }
    }
}

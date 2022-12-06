/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables;


import com.agri.mis.db.Keys;
import com.agri.mis.db.Public;
import com.agri.mis.db.tables.records.CmsResourceRecord;

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
public class CmsResource extends TableImpl<CmsResourceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.cms_resource</code>
     */
    public static final CmsResource CMS_RESOURCE = new CmsResource();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CmsResourceRecord> getRecordType() {
        return CmsResourceRecord.class;
    }

    /**
     * The column <code>public.cms_resource.id</code>.
     */
    public final TableField<CmsResourceRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.cms_resource.name</code>.
     */
    public final TableField<CmsResourceRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.cms_resource.doc_type</code>.
     */
    public final TableField<CmsResourceRecord, String> DOC_TYPE = createField(DSL.name("doc_type"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.cms_resource.doc_url</code>.
     */
    public final TableField<CmsResourceRecord, String> DOC_URL = createField(DSL.name("doc_url"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.cms_resource.entity_id</code>.
     */
    public final TableField<CmsResourceRecord, Long> ENTITY_ID = createField(DSL.name("entity_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.cms_resource.entity_name</code>.
     */
    public final TableField<CmsResourceRecord, String> ENTITY_NAME = createField(DSL.name("entity_name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.cms_resource.created_at</code>.
     */
    public final TableField<CmsResourceRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.cms_resource.created_by</code>.
     */
    public final TableField<CmsResourceRecord, Long> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.cms_resource.created_user_id</code>.
     */
    public final TableField<CmsResourceRecord, Long> CREATED_USER_ID = createField(DSL.name("created_user_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.cms_resource.doc_ext</code>.
     */
    public final TableField<CmsResourceRecord, String> DOC_EXT = createField(DSL.name("doc_ext"), SQLDataType.VARCHAR(20), this, "");

    private CmsResource(Name alias, Table<CmsResourceRecord> aliased) {
        this(alias, aliased, null);
    }

    private CmsResource(Name alias, Table<CmsResourceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.cms_resource</code> table reference
     */
    public CmsResource(String alias) {
        this(DSL.name(alias), CMS_RESOURCE);
    }

    /**
     * Create an aliased <code>public.cms_resource</code> table reference
     */
    public CmsResource(Name alias) {
        this(alias, CMS_RESOURCE);
    }

    /**
     * Create a <code>public.cms_resource</code> table reference
     */
    public CmsResource() {
        this(DSL.name("cms_resource"), null);
    }

    public <O extends Record> CmsResource(Table<O> child, ForeignKey<O, CmsResourceRecord> key) {
        super(child, key, CMS_RESOURCE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<CmsResourceRecord, Long> getIdentity() {
        return (Identity<CmsResourceRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CmsResourceRecord> getPrimaryKey() {
        return Keys.CMS_RESOURCE_PKEY;
    }

    @Override
    public CmsResource as(String alias) {
        return new CmsResource(DSL.name(alias), this);
    }

    @Override
    public CmsResource as(Name alias) {
        return new CmsResource(alias, this);
    }

    @Override
    public CmsResource as(Table<?> alias) {
        return new CmsResource(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public CmsResource rename(String name) {
        return new CmsResource(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CmsResource rename(Name name) {
        return new CmsResource(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public CmsResource rename(Table<?> name) {
        return new CmsResource(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Long, String, String, String, Long, String, LocalDateTime, Long, Long, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function10<? super Long, ? super String, ? super String, ? super String, ? super Long, ? super String, ? super LocalDateTime, ? super Long, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function10<? super Long, ? super String, ? super String, ? super String, ? super Long, ? super String, ? super LocalDateTime, ? super Long, ? super Long, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}

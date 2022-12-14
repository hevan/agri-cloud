/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CmsResource;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CmsResourceRecord extends UpdatableRecordImpl<CmsResourceRecord> implements Record9<Long, String, String, String, Long, LocalDateTime, Long, Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.cms_resource.id</code>.
     */
    public CmsResourceRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.cms_resource.name</code>.
     */
    public CmsResourceRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.cms_resource.doc_type</code>.
     */
    public CmsResourceRecord setDocType(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.doc_type</code>.
     */
    public String getDocType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.cms_resource.doc_url</code>.
     */
    public CmsResourceRecord setDocUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.doc_url</code>.
     */
    public String getDocUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.cms_resource.blog_id</code>.
     */
    public CmsResourceRecord setBlogId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.blog_id</code>.
     */
    public Long getBlogId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.cms_resource.created_at</code>.
     */
    public CmsResourceRecord setCreatedAt(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.cms_resource.created_by</code>.
     */
    public CmsResourceRecord setCreatedBy(Long value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.created_by</code>.
     */
    public Long getCreatedBy() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.cms_resource.created_user_id</code>.
     */
    public CmsResourceRecord setCreatedUserId(Long value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.cms_resource.doc_ext</code>.
     */
    public CmsResourceRecord setDocExt(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.doc_ext</code>.
     */
    public String getDocExt() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, String, String, String, Long, LocalDateTime, Long, Long, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, String, Long, LocalDateTime, Long, Long, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CmsResource.CMS_RESOURCE.ID;
    }

    @Override
    public Field<String> field2() {
        return CmsResource.CMS_RESOURCE.NAME;
    }

    @Override
    public Field<String> field3() {
        return CmsResource.CMS_RESOURCE.DOC_TYPE;
    }

    @Override
    public Field<String> field4() {
        return CmsResource.CMS_RESOURCE.DOC_URL;
    }

    @Override
    public Field<Long> field5() {
        return CmsResource.CMS_RESOURCE.BLOG_ID;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return CmsResource.CMS_RESOURCE.CREATED_AT;
    }

    @Override
    public Field<Long> field7() {
        return CmsResource.CMS_RESOURCE.CREATED_BY;
    }

    @Override
    public Field<Long> field8() {
        return CmsResource.CMS_RESOURCE.CREATED_USER_ID;
    }

    @Override
    public Field<String> field9() {
        return CmsResource.CMS_RESOURCE.DOC_EXT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getDocType();
    }

    @Override
    public String component4() {
        return getDocUrl();
    }

    @Override
    public Long component5() {
        return getBlogId();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedAt();
    }

    @Override
    public Long component7() {
        return getCreatedBy();
    }

    @Override
    public Long component8() {
        return getCreatedUserId();
    }

    @Override
    public String component9() {
        return getDocExt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getDocType();
    }

    @Override
    public String value4() {
        return getDocUrl();
    }

    @Override
    public Long value5() {
        return getBlogId();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedAt();
    }

    @Override
    public Long value7() {
        return getCreatedBy();
    }

    @Override
    public Long value8() {
        return getCreatedUserId();
    }

    @Override
    public String value9() {
        return getDocExt();
    }

    @Override
    public CmsResourceRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CmsResourceRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CmsResourceRecord value3(String value) {
        setDocType(value);
        return this;
    }

    @Override
    public CmsResourceRecord value4(String value) {
        setDocUrl(value);
        return this;
    }

    @Override
    public CmsResourceRecord value5(Long value) {
        setBlogId(value);
        return this;
    }

    @Override
    public CmsResourceRecord value6(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public CmsResourceRecord value7(Long value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public CmsResourceRecord value8(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public CmsResourceRecord value9(String value) {
        setDocExt(value);
        return this;
    }

    @Override
    public CmsResourceRecord values(Long value1, String value2, String value3, String value4, Long value5, LocalDateTime value6, Long value7, Long value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CmsResourceRecord
     */
    public CmsResourceRecord() {
        super(CmsResource.CMS_RESOURCE);
    }

    /**
     * Create a detached, initialised CmsResourceRecord
     */
    public CmsResourceRecord(Long id, String name, String docType, String docUrl, Long blogId, LocalDateTime createdAt, Long createdBy, Long createdUserId, String docExt) {
        super(CmsResource.CMS_RESOURCE);

        setId(id);
        setName(name);
        setDocType(docType);
        setDocUrl(docUrl);
        setBlogId(blogId);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        setCreatedUserId(createdUserId);
        setDocExt(docExt);
    }

    /**
     * Create a detached, initialised CmsResourceRecord
     */
    public CmsResourceRecord(com.agri.mis.db.tables.pojos.CmsResource value) {
        super(CmsResource.CMS_RESOURCE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDocType(value.getDocType());
            setDocUrl(value.getDocUrl());
            setBlogId(value.getBlogId());
            setCreatedAt(value.getCreatedAt());
            setCreatedBy(value.getCreatedBy());
            setCreatedUserId(value.getCreatedUserId());
            setDocExt(value.getDocExt());
        }
    }
}

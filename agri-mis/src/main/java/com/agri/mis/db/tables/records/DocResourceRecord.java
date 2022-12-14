/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.DocResource;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DocResourceRecord extends UpdatableRecordImpl<DocResourceRecord> implements Record13<Long, String, String, String, String, Long, String, LocalDateTime, Long, String, Long, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.doc_resource.id</code>.
     */
    public DocResourceRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.doc_resource.name</code>.
     */
    public DocResourceRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.doc_resource.doc_type</code>.
     */
    public DocResourceRecord setDocType(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.doc_type</code>.
     */
    public String getDocType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.doc_resource.doc_url</code>.
     */
    public DocResourceRecord setDocUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.doc_url</code>.
     */
    public String getDocUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.doc_resource.show_image</code>.
     */
    public DocResourceRecord setShowImage(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.show_image</code>.
     */
    public String getShowImage() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.doc_resource.entity_id</code>.
     */
    public DocResourceRecord setEntityId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.entity_id</code>.
     */
    public Long getEntityId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.doc_resource.entity_name</code>.
     */
    public DocResourceRecord setEntityName(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.entity_name</code>.
     */
    public String getEntityName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.doc_resource.created_at</code>.
     */
    public DocResourceRecord setCreatedAt(LocalDateTime value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.doc_resource.corp_id</code>.
     */
    public DocResourceRecord setCorpId(Long value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(8);
    }

    /**
     * Setter for <code>public.doc_resource.group_name</code>.
     */
    public DocResourceRecord setGroupName(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.group_name</code>.
     */
    public String getGroupName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.doc_resource.created_user_id</code>.
     */
    public DocResourceRecord setCreatedUserId(Long value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return (Long) get(10);
    }

    /**
     * Setter for <code>public.doc_resource.doc_ext</code>.
     */
    public DocResourceRecord setDocExt(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.doc_ext</code>.
     */
    public String getDocExt() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.doc_resource.created_by</code>.
     */
    public DocResourceRecord setCreatedBy(String value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.doc_resource.created_by</code>.
     */
    public String getCreatedBy() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row13<Long, String, String, String, String, Long, String, LocalDateTime, Long, String, Long, String, String> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    @Override
    public Row13<Long, String, String, String, String, Long, String, LocalDateTime, Long, String, Long, String, String> valuesRow() {
        return (Row13) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return DocResource.DOC_RESOURCE.ID;
    }

    @Override
    public Field<String> field2() {
        return DocResource.DOC_RESOURCE.NAME;
    }

    @Override
    public Field<String> field3() {
        return DocResource.DOC_RESOURCE.DOC_TYPE;
    }

    @Override
    public Field<String> field4() {
        return DocResource.DOC_RESOURCE.DOC_URL;
    }

    @Override
    public Field<String> field5() {
        return DocResource.DOC_RESOURCE.SHOW_IMAGE;
    }

    @Override
    public Field<Long> field6() {
        return DocResource.DOC_RESOURCE.ENTITY_ID;
    }

    @Override
    public Field<String> field7() {
        return DocResource.DOC_RESOURCE.ENTITY_NAME;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return DocResource.DOC_RESOURCE.CREATED_AT;
    }

    @Override
    public Field<Long> field9() {
        return DocResource.DOC_RESOURCE.CORP_ID;
    }

    @Override
    public Field<String> field10() {
        return DocResource.DOC_RESOURCE.GROUP_NAME;
    }

    @Override
    public Field<Long> field11() {
        return DocResource.DOC_RESOURCE.CREATED_USER_ID;
    }

    @Override
    public Field<String> field12() {
        return DocResource.DOC_RESOURCE.DOC_EXT;
    }

    @Override
    public Field<String> field13() {
        return DocResource.DOC_RESOURCE.CREATED_BY;
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
    public String component5() {
        return getShowImage();
    }

    @Override
    public Long component6() {
        return getEntityId();
    }

    @Override
    public String component7() {
        return getEntityName();
    }

    @Override
    public LocalDateTime component8() {
        return getCreatedAt();
    }

    @Override
    public Long component9() {
        return getCorpId();
    }

    @Override
    public String component10() {
        return getGroupName();
    }

    @Override
    public Long component11() {
        return getCreatedUserId();
    }

    @Override
    public String component12() {
        return getDocExt();
    }

    @Override
    public String component13() {
        return getCreatedBy();
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
    public String value5() {
        return getShowImage();
    }

    @Override
    public Long value6() {
        return getEntityId();
    }

    @Override
    public String value7() {
        return getEntityName();
    }

    @Override
    public LocalDateTime value8() {
        return getCreatedAt();
    }

    @Override
    public Long value9() {
        return getCorpId();
    }

    @Override
    public String value10() {
        return getGroupName();
    }

    @Override
    public Long value11() {
        return getCreatedUserId();
    }

    @Override
    public String value12() {
        return getDocExt();
    }

    @Override
    public String value13() {
        return getCreatedBy();
    }

    @Override
    public DocResourceRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public DocResourceRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public DocResourceRecord value3(String value) {
        setDocType(value);
        return this;
    }

    @Override
    public DocResourceRecord value4(String value) {
        setDocUrl(value);
        return this;
    }

    @Override
    public DocResourceRecord value5(String value) {
        setShowImage(value);
        return this;
    }

    @Override
    public DocResourceRecord value6(Long value) {
        setEntityId(value);
        return this;
    }

    @Override
    public DocResourceRecord value7(String value) {
        setEntityName(value);
        return this;
    }

    @Override
    public DocResourceRecord value8(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public DocResourceRecord value9(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public DocResourceRecord value10(String value) {
        setGroupName(value);
        return this;
    }

    @Override
    public DocResourceRecord value11(Long value) {
        setCreatedUserId(value);
        return this;
    }

    @Override
    public DocResourceRecord value12(String value) {
        setDocExt(value);
        return this;
    }

    @Override
    public DocResourceRecord value13(String value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public DocResourceRecord values(Long value1, String value2, String value3, String value4, String value5, Long value6, String value7, LocalDateTime value8, Long value9, String value10, Long value11, String value12, String value13) {
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
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DocResourceRecord
     */
    public DocResourceRecord() {
        super(DocResource.DOC_RESOURCE);
    }

    /**
     * Create a detached, initialised DocResourceRecord
     */
    public DocResourceRecord(Long id, String name, String docType, String docUrl, String showImage, Long entityId, String entityName, LocalDateTime createdAt, Long corpId, String groupName, Long createdUserId, String docExt, String createdBy) {
        super(DocResource.DOC_RESOURCE);

        setId(id);
        setName(name);
        setDocType(docType);
        setDocUrl(docUrl);
        setShowImage(showImage);
        setEntityId(entityId);
        setEntityName(entityName);
        setCreatedAt(createdAt);
        setCorpId(corpId);
        setGroupName(groupName);
        setCreatedUserId(createdUserId);
        setDocExt(docExt);
        setCreatedBy(createdBy);
    }

    /**
     * Create a detached, initialised DocResourceRecord
     */
    public DocResourceRecord(com.agri.mis.db.tables.pojos.DocResource value) {
        super(DocResource.DOC_RESOURCE);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDocType(value.getDocType());
            setDocUrl(value.getDocUrl());
            setShowImage(value.getShowImage());
            setEntityId(value.getEntityId());
            setEntityName(value.getEntityName());
            setCreatedAt(value.getCreatedAt());
            setCorpId(value.getCorpId());
            setGroupName(value.getGroupName());
            setCreatedUserId(value.getCreatedUserId());
            setDocExt(value.getDocExt());
            setCreatedBy(value.getCreatedBy());
        }
    }
}

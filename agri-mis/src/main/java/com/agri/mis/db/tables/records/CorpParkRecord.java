/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.records;


import com.agri.mis.db.tables.CorpPark;

import java.time.LocalDate;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CorpParkRecord extends UpdatableRecordImpl<CorpParkRecord> implements Record9<Long, String, String, String, Long, Long, Double, Double, LocalDate> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.corp_park.id</code>.
     */
    public CorpParkRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.corp_park.name</code>.
     */
    public CorpParkRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.corp_park.description</code>.
     */
    public CorpParkRecord setDescription(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.corp_park.image_url</code>.
     */
    public CorpParkRecord setImageUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.image_url</code>.
     */
    public String getImageUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.corp_park.address_id</code>.
     */
    public CorpParkRecord setAddressId(Long value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.address_id</code>.
     */
    public Long getAddressId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.corp_park.corp_id</code>.
     */
    public CorpParkRecord setCorpId(Long value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.corp_id</code>.
     */
    public Long getCorpId() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>public.corp_park.area</code>.
     */
    public CorpParkRecord setArea(Double value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.area</code>.
     */
    public Double getArea() {
        return (Double) get(6);
    }

    /**
     * Setter for <code>public.corp_park.area_use</code>.
     */
    public CorpParkRecord setAreaUse(Double value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.area_use</code>.
     */
    public Double getAreaUse() {
        return (Double) get(7);
    }

    /**
     * Setter for <code>public.corp_park.created_at</code>.
     */
    public CorpParkRecord setCreatedAt(LocalDate value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.corp_park.created_at</code>.
     */
    public LocalDate getCreatedAt() {
        return (LocalDate) get(8);
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
    public Row9<Long, String, String, String, Long, Long, Double, Double, LocalDate> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, String, String, String, Long, Long, Double, Double, LocalDate> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return CorpPark.CORP_PARK.ID;
    }

    @Override
    public Field<String> field2() {
        return CorpPark.CORP_PARK.NAME;
    }

    @Override
    public Field<String> field3() {
        return CorpPark.CORP_PARK.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return CorpPark.CORP_PARK.IMAGE_URL;
    }

    @Override
    public Field<Long> field5() {
        return CorpPark.CORP_PARK.ADDRESS_ID;
    }

    @Override
    public Field<Long> field6() {
        return CorpPark.CORP_PARK.CORP_ID;
    }

    @Override
    public Field<Double> field7() {
        return CorpPark.CORP_PARK.AREA;
    }

    @Override
    public Field<Double> field8() {
        return CorpPark.CORP_PARK.AREA_USE;
    }

    @Override
    public Field<LocalDate> field9() {
        return CorpPark.CORP_PARK.CREATED_AT;
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
        return getDescription();
    }

    @Override
    public String component4() {
        return getImageUrl();
    }

    @Override
    public Long component5() {
        return getAddressId();
    }

    @Override
    public Long component6() {
        return getCorpId();
    }

    @Override
    public Double component7() {
        return getArea();
    }

    @Override
    public Double component8() {
        return getAreaUse();
    }

    @Override
    public LocalDate component9() {
        return getCreatedAt();
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
        return getDescription();
    }

    @Override
    public String value4() {
        return getImageUrl();
    }

    @Override
    public Long value5() {
        return getAddressId();
    }

    @Override
    public Long value6() {
        return getCorpId();
    }

    @Override
    public Double value7() {
        return getArea();
    }

    @Override
    public Double value8() {
        return getAreaUse();
    }

    @Override
    public LocalDate value9() {
        return getCreatedAt();
    }

    @Override
    public CorpParkRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CorpParkRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CorpParkRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CorpParkRecord value4(String value) {
        setImageUrl(value);
        return this;
    }

    @Override
    public CorpParkRecord value5(Long value) {
        setAddressId(value);
        return this;
    }

    @Override
    public CorpParkRecord value6(Long value) {
        setCorpId(value);
        return this;
    }

    @Override
    public CorpParkRecord value7(Double value) {
        setArea(value);
        return this;
    }

    @Override
    public CorpParkRecord value8(Double value) {
        setAreaUse(value);
        return this;
    }

    @Override
    public CorpParkRecord value9(LocalDate value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public CorpParkRecord values(Long value1, String value2, String value3, String value4, Long value5, Long value6, Double value7, Double value8, LocalDate value9) {
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
     * Create a detached CorpParkRecord
     */
    public CorpParkRecord() {
        super(CorpPark.CORP_PARK);
    }

    /**
     * Create a detached, initialised CorpParkRecord
     */
    public CorpParkRecord(Long id, String name, String description, String imageUrl, Long addressId, Long corpId, Double area, Double areaUse, LocalDate createdAt) {
        super(CorpPark.CORP_PARK);

        setId(id);
        setName(name);
        setDescription(description);
        setImageUrl(imageUrl);
        setAddressId(addressId);
        setCorpId(corpId);
        setArea(area);
        setAreaUse(areaUse);
        setCreatedAt(createdAt);
    }

    /**
     * Create a detached, initialised CorpParkRecord
     */
    public CorpParkRecord(com.agri.mis.db.tables.pojos.CorpPark value) {
        super(CorpPark.CORP_PARK);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
            setDescription(value.getDescription());
            setImageUrl(value.getImageUrl());
            setAddressId(value.getAddressId());
            setCorpId(value.getCorpId());
            setArea(value.getArea());
            setAreaUse(value.getAreaUse());
            setCreatedAt(value.getCreatedAt());
        }
    }
}

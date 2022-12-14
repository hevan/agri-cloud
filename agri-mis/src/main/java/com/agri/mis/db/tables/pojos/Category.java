/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String pathName;
    private String name;
    private String imageUrl;
    private Long parentId;
    private Long corpId;

    public Category() {}

    public Category(Category value) {
        this.id = value.id;
        this.pathName = value.pathName;
        this.name = value.name;
        this.imageUrl = value.imageUrl;
        this.parentId = value.parentId;
        this.corpId = value.corpId;
    }

    public Category(
        Long id,
        String pathName,
        String name,
        String imageUrl,
        Long parentId,
        Long corpId
    ) {
        this.id = id;
        this.pathName = pathName;
        this.name = name;
        this.imageUrl = imageUrl;
        this.parentId = parentId;
        this.corpId = corpId;
    }

    /**
     * Getter for <code>public.category.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.category.id</code>.
     */
    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.category.path_name</code>.
     */
    public String getPathName() {
        return this.pathName;
    }

    /**
     * Setter for <code>public.category.path_name</code>.
     */
    public Category setPathName(String pathName) {
        this.pathName = pathName;
        return this;
    }

    /**
     * Getter for <code>public.category.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.category.name</code>.
     */
    public Category setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.category.image_url</code>.
     */
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * Setter for <code>public.category.image_url</code>.
     */
    public Category setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    /**
     * Getter for <code>public.category.parent_id</code>.
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * Setter for <code>public.category.parent_id</code>.
     */
    public Category setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * Getter for <code>public.category.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.category.corp_id</code>.
     */
    public Category setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Category other = (Category) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.pathName == null) {
            if (other.pathName != null)
                return false;
        }
        else if (!this.pathName.equals(other.pathName))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        if (this.imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        }
        else if (!this.imageUrl.equals(other.imageUrl))
            return false;
        if (this.parentId == null) {
            if (other.parentId != null)
                return false;
        }
        else if (!this.parentId.equals(other.parentId))
            return false;
        if (this.corpId == null) {
            if (other.corpId != null)
                return false;
        }
        else if (!this.corpId.equals(other.corpId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.pathName == null) ? 0 : this.pathName.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.imageUrl == null) ? 0 : this.imageUrl.hashCode());
        result = prime * result + ((this.parentId == null) ? 0 : this.parentId.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Category (");

        sb.append(id);
        sb.append(", ").append(pathName);
        sb.append(", ").append(name);
        sb.append(", ").append(imageUrl);
        sb.append(", ").append(parentId);
        sb.append(", ").append(corpId);

        sb.append(")");
        return sb.toString();
    }
}

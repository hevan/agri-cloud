/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CmsTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CmsTag() {}

    public CmsTag(CmsTag value) {
        this.id = value.id;
        this.name = value.name;
    }

    public CmsTag(
        Long id,
        String name
    ) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for <code>public.cms_tag.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.cms_tag.id</code>.
     */
    public CmsTag setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.cms_tag.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.cms_tag.name</code>.
     */
    public CmsTag setName(String name) {
        this.name = name;
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
        final CmsTag other = (CmsTag) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.name == null) {
            if (other.name != null)
                return false;
        }
        else if (!this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CmsTag (");

        sb.append(id);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}

/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String path;
    private String iconUrl;
    private Long parentId;
    private Long corpId;
    private String code;

    public SysMenu() {}

    public SysMenu(SysMenu value) {
        this.id = value.id;
        this.name = value.name;
        this.path = value.path;
        this.iconUrl = value.iconUrl;
        this.parentId = value.parentId;
        this.corpId = value.corpId;
        this.code = value.code;
    }

    public SysMenu(
        Long id,
        String name,
        String path,
        String iconUrl,
        Long parentId,
        Long corpId,
        String code
    ) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.iconUrl = iconUrl;
        this.parentId = parentId;
        this.corpId = corpId;
        this.code = code;
    }

    /**
     * Getter for <code>public.sys_menu.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.sys_menu.id</code>.
     */
    public SysMenu setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.sys_menu.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.sys_menu.name</code>.
     */
    public SysMenu setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.sys_menu.path</code>.
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Setter for <code>public.sys_menu.path</code>.
     */
    public SysMenu setPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Getter for <code>public.sys_menu.icon_url</code>.
     */
    public String getIconUrl() {
        return this.iconUrl;
    }

    /**
     * Setter for <code>public.sys_menu.icon_url</code>.
     */
    public SysMenu setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    /**
     * Getter for <code>public.sys_menu.parent_id</code>.
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * Setter for <code>public.sys_menu.parent_id</code>.
     */
    public SysMenu setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * Getter for <code>public.sys_menu.corp_id</code>.
     */
    public Long getCorpId() {
        return this.corpId;
    }

    /**
     * Setter for <code>public.sys_menu.corp_id</code>.
     */
    public SysMenu setCorpId(Long corpId) {
        this.corpId = corpId;
        return this;
    }

    /**
     * Getter for <code>public.sys_menu.code</code>.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Setter for <code>public.sys_menu.code</code>.
     */
    public SysMenu setCode(String code) {
        this.code = code;
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
        final SysMenu other = (SysMenu) obj;
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
        if (this.path == null) {
            if (other.path != null)
                return false;
        }
        else if (!this.path.equals(other.path))
            return false;
        if (this.iconUrl == null) {
            if (other.iconUrl != null)
                return false;
        }
        else if (!this.iconUrl.equals(other.iconUrl))
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
        if (this.code == null) {
            if (other.code != null)
                return false;
        }
        else if (!this.code.equals(other.code))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.path == null) ? 0 : this.path.hashCode());
        result = prime * result + ((this.iconUrl == null) ? 0 : this.iconUrl.hashCode());
        result = prime * result + ((this.parentId == null) ? 0 : this.parentId.hashCode());
        result = prime * result + ((this.corpId == null) ? 0 : this.corpId.hashCode());
        result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysMenu (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(path);
        sb.append(", ").append(iconUrl);
        sb.append(", ").append(parentId);
        sb.append(", ").append(corpId);
        sb.append(", ").append(code);

        sb.append(")");
        return sb.toString();
    }
}

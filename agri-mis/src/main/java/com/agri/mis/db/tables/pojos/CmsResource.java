/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CmsResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String docType;
    private String docUrl;
    private Long blogId;
    private LocalDateTime createdAt;
    private Long createdBy;
    private Long createdUserId;
    private String docExt;

    public CmsResource() {}

    public CmsResource(CmsResource value) {
        this.id = value.id;
        this.name = value.name;
        this.docType = value.docType;
        this.docUrl = value.docUrl;
        this.blogId = value.blogId;
        this.createdAt = value.createdAt;
        this.createdBy = value.createdBy;
        this.createdUserId = value.createdUserId;
        this.docExt = value.docExt;
    }

    public CmsResource(
        Long id,
        String name,
        String docType,
        String docUrl,
        Long blogId,
        LocalDateTime createdAt,
        Long createdBy,
        Long createdUserId,
        String docExt
    ) {
        this.id = id;
        this.name = name;
        this.docType = docType;
        this.docUrl = docUrl;
        this.blogId = blogId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.createdUserId = createdUserId;
        this.docExt = docExt;
    }

    /**
     * Getter for <code>public.cms_resource.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.cms_resource.id</code>.
     */
    public CmsResource setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for <code>public.cms_resource.name</code>.
     */
    public CmsResource setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.doc_type</code>.
     */
    public String getDocType() {
        return this.docType;
    }

    /**
     * Setter for <code>public.cms_resource.doc_type</code>.
     */
    public CmsResource setDocType(String docType) {
        this.docType = docType;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.doc_url</code>.
     */
    public String getDocUrl() {
        return this.docUrl;
    }

    /**
     * Setter for <code>public.cms_resource.doc_url</code>.
     */
    public CmsResource setDocUrl(String docUrl) {
        this.docUrl = docUrl;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.blog_id</code>.
     */
    public Long getBlogId() {
        return this.blogId;
    }

    /**
     * Setter for <code>public.cms_resource.blog_id</code>.
     */
    public CmsResource setBlogId(Long blogId) {
        this.blogId = blogId;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.cms_resource.created_at</code>.
     */
    public CmsResource setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.created_by</code>.
     */
    public Long getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>public.cms_resource.created_by</code>.
     */
    public CmsResource setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return this.createdUserId;
    }

    /**
     * Setter for <code>public.cms_resource.created_user_id</code>.
     */
    public CmsResource setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
        return this;
    }

    /**
     * Getter for <code>public.cms_resource.doc_ext</code>.
     */
    public String getDocExt() {
        return this.docExt;
    }

    /**
     * Setter for <code>public.cms_resource.doc_ext</code>.
     */
    public CmsResource setDocExt(String docExt) {
        this.docExt = docExt;
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
        final CmsResource other = (CmsResource) obj;
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
        if (this.docType == null) {
            if (other.docType != null)
                return false;
        }
        else if (!this.docType.equals(other.docType))
            return false;
        if (this.docUrl == null) {
            if (other.docUrl != null)
                return false;
        }
        else if (!this.docUrl.equals(other.docUrl))
            return false;
        if (this.blogId == null) {
            if (other.blogId != null)
                return false;
        }
        else if (!this.blogId.equals(other.blogId))
            return false;
        if (this.createdAt == null) {
            if (other.createdAt != null)
                return false;
        }
        else if (!this.createdAt.equals(other.createdAt))
            return false;
        if (this.createdBy == null) {
            if (other.createdBy != null)
                return false;
        }
        else if (!this.createdBy.equals(other.createdBy))
            return false;
        if (this.createdUserId == null) {
            if (other.createdUserId != null)
                return false;
        }
        else if (!this.createdUserId.equals(other.createdUserId))
            return false;
        if (this.docExt == null) {
            if (other.docExt != null)
                return false;
        }
        else if (!this.docExt.equals(other.docExt))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.docType == null) ? 0 : this.docType.hashCode());
        result = prime * result + ((this.docUrl == null) ? 0 : this.docUrl.hashCode());
        result = prime * result + ((this.blogId == null) ? 0 : this.blogId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        result = prime * result + ((this.createdUserId == null) ? 0 : this.createdUserId.hashCode());
        result = prime * result + ((this.docExt == null) ? 0 : this.docExt.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CmsResource (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(docType);
        sb.append(", ").append(docUrl);
        sb.append(", ").append(blogId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(createdUserId);
        sb.append(", ").append(docExt);

        sb.append(")");
        return sb.toString();
    }
}

/*
 * This file is generated by jOOQ.
 */
package com.agri.mis.db.tables.pojos;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CmsVideo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Short status;
    private Short checkStatus;
    private String author;
    private Integer priseUp;
    private Integer priseDown;
    private Long categoryId;
    private LocalDateTime createdAt;
    private Short createdBy;
    private String tags;
    private String description;
    private Long createdUserId;
    private LocalDate publishAt;
    private String imageUrl;

    public CmsVideo() {}

    public CmsVideo(CmsVideo value) {
        this.id = value.id;
        this.title = value.title;
        this.status = value.status;
        this.checkStatus = value.checkStatus;
        this.author = value.author;
        this.priseUp = value.priseUp;
        this.priseDown = value.priseDown;
        this.categoryId = value.categoryId;
        this.createdAt = value.createdAt;
        this.createdBy = value.createdBy;
        this.tags = value.tags;
        this.description = value.description;
        this.createdUserId = value.createdUserId;
        this.publishAt = value.publishAt;
        this.imageUrl = value.imageUrl;
    }

    public CmsVideo(
        Long id,
        String title,
        Short status,
        Short checkStatus,
        String author,
        Integer priseUp,
        Integer priseDown,
        Long categoryId,
        LocalDateTime createdAt,
        Short createdBy,
        String tags,
        String description,
        Long createdUserId,
        LocalDate publishAt,
        String imageUrl
    ) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.checkStatus = checkStatus;
        this.author = author;
        this.priseUp = priseUp;
        this.priseDown = priseDown;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.tags = tags;
        this.description = description;
        this.createdUserId = createdUserId;
        this.publishAt = publishAt;
        this.imageUrl = imageUrl;
    }

    /**
     * Getter for <code>public.cms_video.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.cms_video.id</code>.
     */
    public CmsVideo setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.title</code>.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Setter for <code>public.cms_video.title</code>.
     */
    public CmsVideo setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.status</code>.
     */
    public Short getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.cms_video.status</code>.
     */
    public CmsVideo setStatus(Short status) {
        this.status = status;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.check_status</code>.
     */
    public Short getCheckStatus() {
        return this.checkStatus;
    }

    /**
     * Setter for <code>public.cms_video.check_status</code>.
     */
    public CmsVideo setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.author</code>.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Setter for <code>public.cms_video.author</code>.
     */
    public CmsVideo setAuthor(String author) {
        this.author = author;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.prise_up</code>.
     */
    public Integer getPriseUp() {
        return this.priseUp;
    }

    /**
     * Setter for <code>public.cms_video.prise_up</code>.
     */
    public CmsVideo setPriseUp(Integer priseUp) {
        this.priseUp = priseUp;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.prise_down</code>.
     */
    public Integer getPriseDown() {
        return this.priseDown;
    }

    /**
     * Setter for <code>public.cms_video.prise_down</code>.
     */
    public CmsVideo setPriseDown(Integer priseDown) {
        this.priseDown = priseDown;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.category_id</code>.
     */
    public Long getCategoryId() {
        return this.categoryId;
    }

    /**
     * Setter for <code>public.cms_video.category_id</code>.
     */
    public CmsVideo setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Setter for <code>public.cms_video.created_at</code>.
     */
    public CmsVideo setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.created_by</code>.
     */
    public Short getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Setter for <code>public.cms_video.created_by</code>.
     */
    public CmsVideo setCreatedBy(Short createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.tags</code>.
     */
    public String getTags() {
        return this.tags;
    }

    /**
     * Setter for <code>public.cms_video.tags</code>.
     */
    public CmsVideo setTags(String tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>public.cms_video.description</code>.
     */
    public CmsVideo setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.created_user_id</code>.
     */
    public Long getCreatedUserId() {
        return this.createdUserId;
    }

    /**
     * Setter for <code>public.cms_video.created_user_id</code>.
     */
    public CmsVideo setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.publish_at</code>.
     */
    public LocalDate getPublishAt() {
        return this.publishAt;
    }

    /**
     * Setter for <code>public.cms_video.publish_at</code>.
     */
    public CmsVideo setPublishAt(LocalDate publishAt) {
        this.publishAt = publishAt;
        return this;
    }

    /**
     * Getter for <code>public.cms_video.image_url</code>.
     */
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * Setter for <code>public.cms_video.image_url</code>.
     */
    public CmsVideo setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        final CmsVideo other = (CmsVideo) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.title == null) {
            if (other.title != null)
                return false;
        }
        else if (!this.title.equals(other.title))
            return false;
        if (this.status == null) {
            if (other.status != null)
                return false;
        }
        else if (!this.status.equals(other.status))
            return false;
        if (this.checkStatus == null) {
            if (other.checkStatus != null)
                return false;
        }
        else if (!this.checkStatus.equals(other.checkStatus))
            return false;
        if (this.author == null) {
            if (other.author != null)
                return false;
        }
        else if (!this.author.equals(other.author))
            return false;
        if (this.priseUp == null) {
            if (other.priseUp != null)
                return false;
        }
        else if (!this.priseUp.equals(other.priseUp))
            return false;
        if (this.priseDown == null) {
            if (other.priseDown != null)
                return false;
        }
        else if (!this.priseDown.equals(other.priseDown))
            return false;
        if (this.categoryId == null) {
            if (other.categoryId != null)
                return false;
        }
        else if (!this.categoryId.equals(other.categoryId))
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
        if (this.tags == null) {
            if (other.tags != null)
                return false;
        }
        else if (!this.tags.equals(other.tags))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.createdUserId == null) {
            if (other.createdUserId != null)
                return false;
        }
        else if (!this.createdUserId.equals(other.createdUserId))
            return false;
        if (this.publishAt == null) {
            if (other.publishAt != null)
                return false;
        }
        else if (!this.publishAt.equals(other.publishAt))
            return false;
        if (this.imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        }
        else if (!this.imageUrl.equals(other.imageUrl))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
        result = prime * result + ((this.status == null) ? 0 : this.status.hashCode());
        result = prime * result + ((this.checkStatus == null) ? 0 : this.checkStatus.hashCode());
        result = prime * result + ((this.author == null) ? 0 : this.author.hashCode());
        result = prime * result + ((this.priseUp == null) ? 0 : this.priseUp.hashCode());
        result = prime * result + ((this.priseDown == null) ? 0 : this.priseDown.hashCode());
        result = prime * result + ((this.categoryId == null) ? 0 : this.categoryId.hashCode());
        result = prime * result + ((this.createdAt == null) ? 0 : this.createdAt.hashCode());
        result = prime * result + ((this.createdBy == null) ? 0 : this.createdBy.hashCode());
        result = prime * result + ((this.tags == null) ? 0 : this.tags.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.createdUserId == null) ? 0 : this.createdUserId.hashCode());
        result = prime * result + ((this.publishAt == null) ? 0 : this.publishAt.hashCode());
        result = prime * result + ((this.imageUrl == null) ? 0 : this.imageUrl.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CmsVideo (");

        sb.append(id);
        sb.append(", ").append(title);
        sb.append(", ").append(status);
        sb.append(", ").append(checkStatus);
        sb.append(", ").append(author);
        sb.append(", ").append(priseUp);
        sb.append(", ").append(priseDown);
        sb.append(", ").append(categoryId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(tags);
        sb.append(", ").append(description);
        sb.append(", ").append(createdUserId);
        sb.append(", ").append(publishAt);
        sb.append(", ").append(imageUrl);

        sb.append(")");
        return sb.toString();
    }
}

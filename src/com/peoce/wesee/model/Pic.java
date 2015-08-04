package com.peoce.wesee.model;

public class Pic {
	String photoId;
	String photoUrl;
	int upCount;
	int createBy;
	String picCreateTime;
	String tag;
	
	public Pic(String photoId, String photoUrl, int upCount, int createBy,
			String picCreateTime, String tag) {
		super();
		this.photoId = photoId;
		this.photoUrl = photoUrl;
		this.upCount = upCount;
		this.createBy = createBy;
		this.picCreateTime = picCreateTime;
		this.tag = tag;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public int getUpCount() {
		return upCount;
	}
	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public String getPicCreateTime() {
		return picCreateTime;
	}
	public void setPicCreateTime(String picCreateTime) {
		this.picCreateTime = picCreateTime;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + createBy;
		result = prime * result + ((photoId == null) ? 0 : photoId.hashCode());
		result = prime * result
				+ ((photoUrl == null) ? 0 : photoUrl.hashCode());
		result = prime * result
				+ ((picCreateTime == null) ? 0 : picCreateTime.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		result = prime * result + upCount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pic other = (Pic) obj;
		if (createBy != other.createBy)
			return false;
		if (photoId == null) {
			if (other.photoId != null)
				return false;
		} else if (!photoId.equals(other.photoId))
			return false;
		if (photoUrl == null) {
			if (other.photoUrl != null)
				return false;
		} else if (!photoUrl.equals(other.photoUrl))
			return false;
		if (picCreateTime == null) {
			if (other.picCreateTime != null)
				return false;
		} else if (!picCreateTime.equals(other.picCreateTime))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		if (upCount != other.upCount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pic [photoId=" + photoId + ", photoUrl=" + photoUrl
				+ ", upCount=" + upCount + ", createBy=" + createBy
				+ ", picCreateTime=" + picCreateTime + ", tag=" + tag + "]";
	}
	
	
}

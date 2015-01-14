package com.cdp.testing5;

public class Picture {
	private long id;
	private int views;

	public Picture(long id, int views) {
		this.id = id;
		this.views = views;
	}

	public long getId() {
		return id;
	}
	
	public void markAsViewed() {
		views++;
	}
	
	public int getViews() {
		return views;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + views;
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
		Picture other = (Picture) obj;
		if (id != other.id)
			return false;
		if (views != other.views)
			return false;
		return true;
	}
}

package com.cdp.testing5;

import java.util.List;

public interface PictureDao {
	Picture get(long id);
	
	List<Picture> getAll();
	
	Picture save(Picture picture);
	
	void delete(Picture picture);
}

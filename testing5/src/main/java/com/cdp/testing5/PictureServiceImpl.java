package com.cdp.testing5;

import java.util.List;

public class PictureServiceImpl {
	private PictureDao pictureDao;
	
	public void setPictureDao(PictureDao dao) {
		pictureDao = dao;
	}
	
	public Picture get(long id) {
		Picture picture = pictureDao.get(id);
		picture.markAsViewed();
		return picture;
	}
	
	public List<Picture> getAll() {
		return pictureDao.getAll();
	}
	
	public Picture save(Picture picture) {
		return pictureDao.save(picture);
	}
	
	public void delete(Picture picture) {
		pictureDao.delete(picture);
	}
	
	public void deleteAll(List<Picture> pictures) {
		for (Picture pic : pictures) {
			pictureDao.delete(pic);
		}
	}
}

package com.cdp.testing5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Lists;

public class PictureServiceTest {
	private PictureServiceImpl service;
	private PictureDao dao;
	
	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery();
	
	@Before
	public void before() {
		service = new PictureServiceImpl();

		dao = context.mock(PictureDao.class);
		service.setPictureDao(dao);
	}
	
	@Test
	public void get_Ok() {		
		final long id = 2;
		final int views = 3;
		final Picture pic = new Picture(id, views);
		
		context.checking(new Expectations() {{
			oneOf(dao).get(id);
			will(returnValue(pic));
		}});
		
		service.get(id);
		assertThat(pic.getViews(), equalTo(views + 1));
	}
	
	@Test(expected = PictureDaoException.class)
	public void get_NoSuchPicture_PictureServiceException() {
		final long id = 2;
		
		context.checking(new Expectations() {{
			oneOf(dao).get(id);
			will(throwException(new PictureDaoException()));
		}});
		
		service.get(id);
	}
	
	@Test
	public void delete_Ok() {
		final long id = 2;
		final int views = 3;
		final Picture pic = new Picture(id, views);
		
		context.checking(new Expectations() {{
			oneOf(dao).delete(with(pic));
		}});
		
		service.delete(pic);
	}
	
	@Test
	public void deleteAll_Ok() {
		final List<Picture> pics = Lists.newArrayList(
				new Picture(1, 2), new Picture(2, 1), new Picture(5, 34));
		
		context.checking(new Expectations() {{
			exactly(pics.size()).of(dao).delete(with(any(Picture.class)));
		}});
		
		service.deleteAll(pics);
	}
}

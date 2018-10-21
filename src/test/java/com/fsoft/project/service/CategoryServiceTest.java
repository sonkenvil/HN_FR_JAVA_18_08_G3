/**
 * 
 */
package com.fsoft.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fsoft.project.dao.impl.CategoryDaoImpl;
import com.fsoft.project.entity.Category;
import com.fsoft.project.service.impl.CategoryServiceImpl;

/**
 * @author hungcoutinho
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	@InjectMocks
	private CategoryServiceImpl categoryService;

	@Mock
	private CategoryDaoImpl categoryDao;

	@Test
	public void testGetCategoryByIdSuccess() {
		Category category = new Category(1, "");
		Mockito.when(categoryDao.getCategoryById(1)).thenReturn(category);
		assertEquals(1, categoryService.getCategoryById(1).getId());
	}

	@Test
	public void testGetCategoryByIdFail() {
		Mockito.when(categoryDao.getCategoryById(1)).thenReturn(null);
		assertEquals(null, categoryService.getCategoryById(1));
	}

	@Test
	public void testGetListCategorySuccess() {
		List<Category> listC = new LinkedList<>();
		listC.add(new Category(1, "Ca"));
		listC.add(new Category(2, "Ca"));
		listC.add(new Category(3, "Ca"));
		Mockito.when(categoryService.getListCategory()).thenReturn(listC);
		assertEquals(3, categoryService.getListCategory().size());
	}

	@Test
	public void testGetListCategoryFail() {
		List<Category> listC = null;
		Mockito.when(categoryService.getListCategory()).thenReturn(listC);
		assertEquals(null, categoryService.getListCategory());
	}
	
	@Test
	public void testGetCategoryId() {
		int expected = 0;
		int actual = categoryService.getCategoryId("a");
		assertTrue(expected == actual);
	}
	
}

/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.impl.CategoryDaoImpl;
import com.fsoft.project.dao.impl.ManuFacturerDaoImpl;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.CategoryService;
import com.fsoft.project.service.ManuFacturerService;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.CategoryServiceImpl;
import com.fsoft.project.service.impl.ManuFacturerServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author hungcoutinho
 *
 */
public class AddProductAction {

	private List<ManuFacturer> listManu;
	private List<Category> listCategory;
	private Product product;
	private ProductService productService;
	private ManuFacturerService manuService;
	private CategoryService categoryService;
	private boolean exitsProductName = false;

	public String loadData() {
		manuService = new ManuFacturerServiceImpl(new ManuFacturerDaoImpl());
		categoryService = new CategoryServiceImpl(new CategoryDaoImpl());
		try {
			listManu = manuService.getListManuFacturerService();
			listCategory = categoryService.getListCategory();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String exitsProduct() {
		System.out.println("ProductName " + product.getProductName());
		exitsProductName = true;
		return Action.SUCCESS;
	}

	public List<ManuFacturer> getListManu() {
		return listManu;
	}

	public void setListManu(List<ManuFacturer> listManu) {
		this.listManu = listManu;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public boolean isExitsProductName() {
		return exitsProductName;
	}

	public void setExitsProductName(boolean exitsProductName) {
		this.exitsProductName = exitsProductName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

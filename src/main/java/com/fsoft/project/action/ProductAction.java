/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.base.BaseAction;
import com.fsoft.project.dao.impl.ImageDetailDaoImpl;
import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.ImageDetail;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ImageDetailService;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ImageDetailServiceImpl;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author hungcoutinho
 *
 */
public class ProductAction extends BaseAction implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5903240637301411070L;
	private int productId;
	private ProductService productService;
	private ImageDetailService imageDetailService;
	private Product product;
	private List<ImageDetail> listImageDetail;
	private List<Product> listRelateProduct;
	
	@Override
	public void prepare() throws Exception {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		imageDetailService = new ImageDetailServiceImpl(new ImageDetailDaoImpl());
	}

	public String execute() throws SQLException {
		if(productId == 0) productId = (int) getSession().get(Constants.PRODUCT);
		product = productService.getProductById(productId);
		listImageDetail = imageDetailService.getListImageDetailByProductId(productId);
		listRelateProduct = productService.getListProductRelated(product);
		getSession().put(Constants.PRODUCT, productId);
		getSession().put(Constants.PAGE_INDEX, Constants.PRODUCT_DETAIL);
		return Action.SUCCESS;
	}
	
	public String productDetail() throws SQLException {
		Object object = getSession().get(Constants.PRODUCT);
		if(object != null) {
			int productId = (int) object;
			product = productService.getProductById(productId);
			listImageDetail = imageDetailService.getListImageDetailByProductId(productId);
			listRelateProduct = productService.getListProductRelated(product);
			return Action.SUCCESS;
		}
		return Action.SUCCESS;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ImageDetail> getListImageDetail() {
		return listImageDetail;
	}

	public void setListImageDetail(List<ImageDetail> listImageDetail) {
		this.listImageDetail = listImageDetail;
	}

	public List<Product> getListRelateProduct() {
		return listRelateProduct;
	}

	public void setListRelateProduct(List<Product> listRelateProduct) {
		this.listRelateProduct = listRelateProduct;
	}
}

/**
 * 
 */
package com.fsoft.project.action;

import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fsoft.project.dao.ProductDao;
import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;
import com.fsoft.project.entity.UploadEntity;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.StorageUtils;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hungcoutinho
 *
 */
public class ProductAction extends ActionSupport{


	private static final long serialVersionUID = 1L;
	private int id;
	private int hidden;

	private ProductService productService;

	private Product product;
	private String productName;
	private String imagePath;
	private File myFile;
	private String myFileFileName;
	private String myFileContentType;

	List<Product> listProduct = null;
	private boolean noData = false;
	private int manuFacturerId;
	private int categoryId;
	private String color;
	private Double price;
	private ProductDao productDao;
	private int result;
	private String msg;
	private String submitType;

	private ManuFacturer manuFacturer;
	private Category category;
	private Date createDate;




	// private ManuFacturer manuFacturer;
	// private Category category;

	public String execute() throws SQLException {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		product = productService.getProductById(product.getId());
		return Action.SUCCESS;
	}

	public String addProduct() throws SQLException {

		Product product = new Product();

		product.setMyFileContentType(myFileContentType);
		product.setMyFile(myFile);
		product.setImagePath(myFileFileName);

		product.setProductName(productName);
		product.setManuFacturerId(manuFacturerId);
		product.setCategoryId(categoryId);
		product.setColor(color);
		product.setCreateDate(createDate);
		product.setPrice(price);

		productDao = new ProductDaoImpl();
		productService = new ProductServiceImpl(productDao);
		result = productService.addProduct(product);

		if (result > 0) {
			msg = "success";
		} else {
			msg = "false";
		}
		return WebConstants.ADD_PRODUCT;
	}

	public String allProduct() throws SQLException {

		productDao = new ProductDaoImpl();
		productService = new ProductServiceImpl(productDao);

		listProduct = productService.allProduct();
		if (listProduct.size() == 0) {
			noData = false;
		} else {
			noData = true;
		}
		return WebConstants.ALL_PRODUCT;
	}

	public String fetchProduct() throws SQLException {
		
		productDao = new ProductDaoImpl();
		productService = new ProductServiceImpl(productDao);
		product =  productService.fetchProduct(id);
		return WebConstants.UPDATE_PRODUCT;
	}
	
	
	public String updateProduct() throws Exception {

		productDao = new ProductDaoImpl();
		productService = new ProductServiceImpl(productDao);
		
				String idStr = ServletActionContext.getRequest().getParameter("id");
				
				Product product = new Product();
				
				if (idStr != null) {
					System.out.println(idStr);
					product = productDao.getProductById(id);
					product.setMyFileContentType(myFileContentType);
					product.setMyFile(myFile);
					product.setImagePath(myFileFileName);
					
				}

//			product.setMyFileContentType(myFileContentType);
//			product.setMyFile(myFile);
//			product.setImagePath(myFileFileName);

			product.setProductName(productName);
			product.setManuFacturerId(manuFacturerId);
			product.setCategoryId(categoryId);
			product.setColor(color);
			product.setCreateDate(createDate);
			product.setHidden(hidden);
			product.setPrice(price);

			System.out.println(myFileFileName+ productName +color);

			productService.updateProduct(product);
		

		return WebConstants.UPDATE_PRODUCT;
	}






	public String deleteProduct() throws SQLException, Exception {

		productDao = new ProductDaoImpl();

		productService = new ProductServiceImpl(productDao);
		int isDeleted = productService.deleteProduct(id);
		if (isDeleted > 0) {
			msg = "Record deleted successfully";
		} else {
			msg = "Some error";
		}
		return WebConstants.DELETE_PRODUCT;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getManuFacturerId() {
		return manuFacturerId;
	}

	public void setManuFacturerId(int manuFacturerId) {
		this.manuFacturerId = manuFacturerId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ManuFacturer getManuFacturer() {
		return manuFacturer;
	}

	public void setManuFacturer(ManuFacturer manuFacturer) {
		this.manuFacturer = manuFacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}




	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}




}

//package com.fsoft.project.action;
//
//import java.io.File;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.struts2.interceptor.ServletRequestAware;
//
//import com.fsoft.project.db.DbHelper;
//import com.fsoft.project.entity.ImageDetail;
//import com.fsoft.project.entity.Product;
//import com.fsoft.project.utils.constants.QueryConstants;
//import com.fsoft.project.utils.constants.WebConstants;
//import com.opensymphony.xwork2.ActionSupport;
//
//public class ImageDetailAction extends ActionSupport implements ServletRequestAware{
//
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private int id;
//	//	private String imagePath;
//	private Product product;
//	private int ProductId;
//
//
//	private File[]  imageDetailFileName;
//	private String[] imageDetail;
//	private String[] imageDetailContentType;
//	private HttpServletRequest servletRequest;
//
//	@Override
//	public void setServletRequest(HttpServletRequest servletRequest) {
//
//		this.servletRequest=servletRequest;
//
//	}
//
//	public String doUploadImage() {
//
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		ImageDetail imageDetail= new ImageDetail();
//		CallableStatement cs=null;
//		Connection conn=null;
//
//
//		try {
//			conn = DbHelper.getConnection();
//
//			for (int i = 0; i < imageDetailFileName.length; i++) {
//				String filePath = servletRequest.getServletContext().getRealPath("/imagesdetail");
//				File fileToCreate = new File(filePath, this.imageDetail[i]);
//				FileUtils.copyFile(this.imageDetailFileName[i], fileToCreate);
//
//				ps = conn.prepareStatement(QueryConstants.GET_ID_DETAIL,Statement.RETURN_GENERATED_KEYS);
//				ps.setInt(1, imageDetail.getId());
//				ps.setString(2, imageDetail.getImageDetail()[i]);
//				ps.executeUpdate();
//
//			}
//		} catch (Exception e) {
//			return INPUT;
//		}
//		return WebConstants.ADD_PRODUCT;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public int getProductId() {
//		return ProductId;
//	}
//
//
//	public void setProductId(int productId) {
//		ProductId = productId;
//	}
//
//
//	public File[] getImageDetailFileName() {
//		return imageDetailFileName;
//	}
//
//
//	public void setImageDetailFileName(File[] imageDetailFileName) {
//		this.imageDetailFileName = imageDetailFileName;
//	}
//
//
//	public String[] getImageDetail() {
//		return imageDetail;
//	}
//
//
//	public void setImageDetail(String[] imageDetail) {
//		this.imageDetail = imageDetail;
//	}
//
//
//	public String[] getImageDetailContentType() {
//		return imageDetailContentType;
//	}
//
//
//	public void setImageDetailContentType(String[] imageDetailContentType) {
//		this.imageDetailContentType = imageDetailContentType;
//	}
//
//
//	public Product getProduct() {
//		return product;
//	}
//
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//
//	public HttpServletRequest getServletRequest() {
//		return servletRequest;
//	}
//
//
//
//}

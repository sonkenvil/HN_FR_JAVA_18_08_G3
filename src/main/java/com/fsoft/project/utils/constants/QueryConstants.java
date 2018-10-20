/**
 * 
 */
package com.fsoft.project.utils.constants;

import java.io.File;
import java.sql.Date;

import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;

/**
 * @author hungcoutinho
 *
 */
public class QueryConstants {

	public static final String SELECT_NEW_PRODUCT = "SELECT TOP(5) Id,ProductName,ImagePath,ManuFacturerId,CategoryId,Createdate,Color,Price FROM PRODUCT ORDER BY CreateDate DESC";

	public static final String SELECT_PRODUCT = "SELECT TOP(8) Id,ProductName,ImagePath,ManuFacturerId,CategoryId,Createdate,Color,Price FROM PRODUCT WHERE Id > ?";

	public static final String SELECT_PRODUCT_BY_ID = "SELECT Id,ProductName,ImagePath,ManuFacturerId,CategoryId,Createdate,Color,Price FROM PRODUCT WHERE Id = ?";

	public static final String SEARCH_PRODUCT = "SELECT P.Id, P.ProductName,P.ImagePath,P.ManuFacturerId,P.CategoryId,P.CreateDate,P.Color,P.Price"
			+ " FROM PRODUCT P INNER JOIN CATEGORY C ON P.CategoryId = C.Id INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id"
			+ " WHERE P.ProductName LIKE ? OR C.Name LIKE ? OR M.Name LIKE ?";

	public static final String SELECT_TOTAL_PRODUCT = "SELECT COUNT(*) AS Number FROM PRODUCT";

	public static final String SELECT_CATEGORY_BY_ID = "SELECT Id,Name FROM CATEGORY WHERE Id = ?";

	public static final String SELECT_MANUFACTURER_BY_ID = "SELECT Id,Name FROM MANUFACTURER WHERE Id = ?";

	public static final String GET_MEMBER = "SELECT Id, Email, Role FROM Member WHERE Email = ? AND Password = ?";


	/**
	 * @author trong 
	 * register member 
	 */
	public static final String REGISTER_MEMBER="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?)";


	/**
	 * category
	 */
	public static final String ADD_CATEGORY="INSERT INTO CATEGORY VALUES(?)";

	public static final String ALL_CATEGORY="SELECT Name FROM CATEGORY";

	public static final String UPDATE_CATEGORY="UPDATE CATEGORY SET Name=? WHERE Name=?";
	public static final String DELETE_CATEGORY="DELETE FROM CATEGORY WHERE Name=?";

	public static final String ID_CATEGORY="SELECT * FROM CATEGORY";

	public static final String ID_MANUFACTURER="SELECT * FROM MANUFACTURER";


	public static final String ADD_MANUFACTURER="INSERT INTO MANUFACTURER VALUES(?)";

	public static final String ALL_MANUFACTURER="SELECT Name FROM MANUFACTURER";

	public static final String UPDATE_MANUFACTURER="UPDATE MANUFACTURER SET Name=? WHERE Name=?";
	public static final String DELETE_MANUFACTURER="DELETE FROM MANUFACTURER WHERE Name=?";
	public static final String ADD_PRODUCT="INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?)";
	public static final String UPDATE_PRODUCT="UPDATE PRODUCT SET  ProductName =?, ImagePath=? , ManuFacturerId=? , CategoryId=?,CreateDate=?,  Color=?, Price=? WHERE Id=?";
	public static final String DELETE_PRODUCT="DELETE FROM PRODUCT WHERE Id=?";
	
	public static final String PRE_SELECT_UPDATE_PRODUCT="SELECT* FROM PRODUCT WHERE Id=?";
	
	public static final String ALL_PRODUCT="SELECT Id,ProductName,ImagePath,ManuFacturerId,CategoryId,CreateDate,Color,Price FROM PRODUCT";

	public static final String GET_ID_DETAIL="INSERT INTO IMAGEDETAIL VALUES(?,?)";
	
	
	public static final String ADD="INSERT INTO upload VALUES(?)";
	
	public static final String CHECK_EMAIL_EXISTS="SELECT* FROM MEMBER WHERE Email=?";

}

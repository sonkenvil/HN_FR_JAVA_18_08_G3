/**
 * 
 */
package com.fsoft.project.utils.constants;

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
	
	public static final String CURRENT_ORDER = " SELECT IDENT_CURRENT ('Order_Product') AS Current_Identity";
}

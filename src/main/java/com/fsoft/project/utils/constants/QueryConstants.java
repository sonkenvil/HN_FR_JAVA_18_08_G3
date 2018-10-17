/**
 * 
 */
package com.fsoft.project.utils.constants;

/**
 * @author hungcoutinho
 *
 */
public class QueryConstants {

	public static final String SELECT_NEW_PRODUCT = "SELECT TOP(?) P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.Description AS 'ManuFacturerDescription', C.Id AS 'CategoryId', C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.Description AS 'ProductDescription',P.ImagePath FROM PRODUCT P INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id INNER JOIN CATEGORY C ON P.CategoryId = C.Id ORDER BY P.CreateDate DESC";

	public static final String SELECT_PRODUCT = "SELECT TOP(?) P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.Description AS 'ManuFacturerDescription', C.Id AS 'CategoryId', C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.Description AS 'ProductDescription',P.ImagePath FROM PRODUCT P INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id AND P.Id > ? INNER JOIN CATEGORY C ON P.CategoryId = C.Id";

	public static final String SELECT_PRODUCT_BY_ID = "SELECT P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.Description AS 'ManuFacturerDescription', C.Id AS 'CategoryId', C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.Description AS 'ProductDescription',P.ImagePath FROM PRODUCT P INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id AND P.Id = ? INNER JOIN CATEGORY C ON P.CategoryId = C.Id";

	public static final String SEARCH_PRODUCT = "SELECT P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.Description AS 'ManuFacturerDescription', C.Id AS 'CategoryId', C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.Description AS 'ProductDescription',P.ImagePath"
			+ " FROM PRODUCT P INNER JOIN CATEGORY C ON P.CategoryId = C.Id INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id"
			+ " WHERE P.ProductName LIKE ? OR C.Name LIKE ? OR M.Name LIKE ?";

	public static final String SELECT_PRODUCT_RELATED = "{CALL GET_LIST_RELATE_PRODUCT(?,?,?,?)}";

	public static final String SEARCH_PRODUCT_BY_VALUE = "SELECT P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.Description AS 'ManuFacturerDescription', C.Id AS 'CategoryId', C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.Description AS 'ProductDescription',P.ImagePath"
			+ " FROM PRODUCT P INNER JOIN CATEGORY C ON P.CategoryId = C.Id INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id ";

	public static final String SELECT_TOTAL_PRODUCT_SELECT_BY_VALUE = "SELECT COUNT(*) AS 'Number' FROM PRODUCT P INNER JOIN CATEGORY C ON P.CategoryId = C.Id ";

	public static final String SELECT_TOTAL_PRODUCT = "SELECT COUNT(*) AS 'Number' FROM PRODUCT";

	public static final String SELECT_CATEGORY_BY_ID = "SELECT Id,Name FROM CATEGORY WHERE Id = ?";

	public static final String SELECT_CATEGORY = "SELECT Id,Name FROM CATEGORY";
	
	public static final String SELECT_MANUFACTURER_BY_ID = "SELECT Id,Name,Description FROM MANUFACTURER WHERE Id = ?";

	public static final String SELECT_MANUFACTURER = "SELECT Id,Name,Description FROM MANUFACTURER";
	
	public static final String GET_MEMBER = "SELECT Id, Email, Role FROM Member WHERE Email = ? AND Password = ?";

	public static final String SELECT_IMAGE_BY_PRODUCT = "SELECT I.Id AS 'ImageId', I.ImagePath AS 'ImageDetailPath',P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.[Description] AS 'ManuFacturerDescription',C.Id AS 'CategoryId',C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.[Description] AS 'ProductDescription',P.ImagePath FROM IMAGEDETAIL I INNER JOIN PRODUCT P ON I.ProductId = P.Id AND I.ProductId = ? INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id INNER JOIN CATEGORY C ON P.CategoryId = C.Id";

	public static final String SELECT_IMAGE_BY_ID = "SELECT I.Id AS 'ImageId', I.ImagePath AS 'ImageDetailPath',P.Id AS 'ProductId',P.ProductName,M.Id AS 'ManuFacturerId',M.Name AS 'ManuFacturerName',M.[Description] AS 'ManuFacturerDescription',C.Name AS 'CategoryId',C.Name AS 'CategoryName',P.CreateDate,P.Color,P.Price,P.[Description] AS 'ProductDescription',P.ImagePath FROM IMAGEDETAIL I INNER JOIN PRODUCT P ON I.ProductId = P.Id AND I.Id = ? INNER JOIN MANUFACTURER M ON P.ManuFacturerId = M.Id INNER JOIN CATEGORY C ON P.CategoryId = C.Id";
}

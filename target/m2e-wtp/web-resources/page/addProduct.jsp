<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="vi">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap-admin.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/css/font-awesome-admin.min.css" rel="stylesheet" type="text/css">

    <!-- DEFIND CSS -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style-admin.css">
</head>

<body>

    <div id="wrapper">

        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Product<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <!-- <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li> -->

                                <li>
                                    <a href="allProduct.html"><i class="fa fa-table fa-fw"></i> allProduct</a>
                                </li>
                                <li>
                                    <a href="addProduct.html"><i class="fa fa-edit fa-fw"></i> addProduct</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <!-- <li>
                            <a href="allProduct.html"><i class="fa fa-table fa-fw"></i> allProduct</a>
                        </li>
                        <li>
                            <a href="addProduct.html"><i class="fa fa-edit fa-fw"></i> addProduct</a>
                        </li> -->
                        <li>
                            <a href="login.html">Login Page</a>
                        </li>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">
                        <marquee width="50%" behavior="alternate" bgcolor="pink">Add Product Database</marquee></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form role="form" class="add-product-form">
	                            <div class="row row-form">
	                                <div class="col-lg-7">
	                                   <div class="form-group">
	                                       <label>Product name</label>
	                                       <input class="form-control" id="txtName" type="text" name="product.productName" placeholder="Enter product name" required>
	                                   </div>
	                                   <div class="form-group">
	                                       <label>Price</label>
	                                       <input class="form-control" type="number" name="product.price" placeholder="Enter price" required>
	                                   </div>
	                                   
	                                   <div class="form-group form-group-file">
	                                       <label>Image</label>
	                                       <input type="file" name="fileImageMain" accept="image/*" required>
	                                   </div>
	                                   
	                                   <div class="form-group">
	                                       <label>Description</label>
	                                       <textarea class="form-control" rows="3" name="product.description"></textarea>
	                                   </div>
	                                   
	                                   <div class="form-group">
	                                       <label>Select Manufacturer</label>
	                                       <select class="form-control" name="product.manuFacturer.id" required>
		                                       	<s:iterator value="listManu" var="manu">
		                                       		<option value='<s:property value="id"/>'><s:property value="name"/></option>
		                                       	</s:iterator>
	                                       </select>
	                                       <button style="margin-top:10px" class="btn btn-info">Add Manufacturer</button>
	                                   </div>
	                                   
	                                   <div class="form-group">
	                                       <label>Select Category</label>
	                                       <select class="form-control" name="product.category.id" required>
		                                       	<s:iterator value="listCategory" var="manu">
		                                       		<option value='<s:property value="id"/>'><s:property value="name"/></option>
		                                       	</s:iterator>
		                                       	<option>Hello</option>
	                                       </select>
	                                       <button style="margin-top:10px" class="btn btn-info">Add Category</button>
	                                   </div>
	                                   
	                                   <button type="submit" class="btn btn-default btn_submit_button">Submit Button</button>
                                	   <button type="reset" class="btn btn-default">Reset Button</button>
		                           </div>
	                                <div class="col-lg-5 form_image_multil">
	                                     <div class="div-img">
	                                     	<img style="width:auto;height:100%"/>
	                                     </div>
	                                     <div class="list-image-detail">
	                                     	<p><b>Add list image detail</b></p>
	                                     	<p><input type="file" name="listImageDetails" accept="image/*" multiple/></p>
	                                     	<div class="grid">
	                                     	</div>
	                                     </div>
	                                </div>
                                </form>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/js/jquery-admin.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap-admin.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/js/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/js/sb-admin-2.js"></script>
    
    <!-- Jquery validate -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
    <!-- /Jquery validate -->
    
    <!-- Custom js validate form -->
    <script type="text/javascript">
    	$(document).ready(function(){
    		let productName;
    		$("#txtName").change(function(){
    			productName = $(this).val();
    		})
    		$(".add-product-form").validate({
    			rules:{
	    			'product.productName': {
	    				maxlength: 255,
	    				remote: {
	    					url: 'checkProductNameExits',
	    					type: 'get',
	    					dataType: 'json',
	    					data: {
	    						'product.productName': productName
	    					},
    						success: function(result){
    							let exitsProductName = result.exitsProductName;
    							console.log(exitsProductName);
    							if(exitsProductName)
    								return "fuck";
    							return true;
    						}
	    				}
	    			},
	    			'product.price': {
	    				min: 0
	    			}
    			},
    			messages:{
    				'product.productName' : $.validator.format("{0} is exits"),
    				'product.price': "price is lange 0"
    			}
    		})
    	})
    </script>
    <!-- /Custom js validate form -->
    
    <!-- custom js load image -->
    <script type="text/javascript" defer>
       	$(document).ready(function(){
       		$(".form-group-file input").change(function(){
       			let files = this.files;
       			if(files.length > 0){
       				let reader = new FileReader();
       				reader.readAsDataURL(files[0]);
       				reader.onload = function(data){
       					$(".form_image_multil .div-img img").attr('src',data.target.result);
       					$(".list-image-detail").css('display','block');
       				}
       			}
       		})
       		$(".list-image-detail input").change(function(){
       			let files = this.files;
       			if(files.length > 0){
       				let reader = new FileReader();
       				for(let i=0;i<files.length;i++){
       					reader.readAsDataURL(files[i]);
       					reader.onload = function(data){
       						$(".form_image_multil .list-image-detail .grid").append("<div><img src='" + data.target.result + "'/></div>");
       					}
       				}
       			}
       		})
       	})
   </script>
   <!-- /custom js load image -->

</body>

</html>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>


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

<div class="container text-center text-center">
            <form class="form-horizontal" role="form">
              <center>  <h2>Registration Form</h2>  </center>
			    
				
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">First Name</label>
                    <div class="col-sm-4">
                        <input type="text" id="firstName" placeholder="Full Name" class="form-control" autofocus>
                       
                    </div>
                </div>
				<div class="form-group">
                    <label for="lastName" class="col-sm-3 control-label">Last Name</label>
                    <div class="col-sm-4">
                        <input type="text" id="firstName" placeholder="Full Name" class="form-control" autofocus>
                       
                    </div>
                </div>
				<div class="form-group">
                    <label for="ID Number" class="col-sm-3 control-label">ID NUMBER</label>
                    <div class="col-sm-4">
                        <input type="text" id="firstName" placeholder="ID NUMBER" class="form-control" autofocus>
                       
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-4">
                        <input type="password" id="password" placeholder="Password" class="form-control">
                    </div>
                </div>
				                <div class="form-group">
                    <label for="Confirm Password" class="col-sm-3 control-label">Confirm Password</label>
                    <div class="col-sm-4">
                        <input type="password" id="Confirm Password" placeholder="Confirm Password" class="form-control">
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="type" class="col-sm-3 control-label">Type</label>
                    <div class="col-sm-4">
                        <select id="Select" class="form-control">
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                        </select>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <label class="control-label col-sm-3">Gender</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-6">
                                <label class="radio-inline">
                                    <input type="radio" id="femaleRadio" value="Female">Female
                                </label>
								<label class="radio-inline">
                                    <input type="radio" id="maleRadio" value="Male">Male
                                </label>
								<label class="radio-inline">
                                    <input type="radio" id="uncknownRadio" value="Unknown">Others
                                </label>
                            </div>
                           
                            </div>
                            
                                
                            
                        </div>
                    </div>
             
				<div class="form-group">
                    <label for="Address" class="col-sm-3 control-label">Address</label>
                    <div class="col-sm-4">
                        <textarea class="form-control"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2 col-sm-offset-3">
                        <button type="submit" class="btn btn-info">Submit</button>
                    </div>
                </div>
            </form> <!-- /form -->
        </div> <!-- ./container -->
		
	
		
		</body>
		</html>

<script src="<%=request.getContextPath() %>/js/jquery-admin.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap-admin.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/js/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/js/sb-admin-2.js"></script>
	
</body>
</html>
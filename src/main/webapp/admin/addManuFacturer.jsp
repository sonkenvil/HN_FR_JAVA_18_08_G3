<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="vi">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<jsp:include page="head.jsp"></jsp:include>

<style type="text/css">
.error {
	color: red;
}

.label {
	display: inline-block;
	max-width: 100%;
	margin-bottom: 5px;
	font-weight: 400;
	color: black;
	font-size: 15px;
	margin-right: 20px;
}

#name {
	display: block;
	width: 230%;
	height: 43px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}

#submit {
	border: 1px solid gray;
	border-radius: 10%;
	margin-top: 30px;
	margin-left: 80px;
	background-color: #ecf5e8;
}
</style>

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

			<jsp:include page="header.jsp"></jsp:include>

			<jsp:include page="left.jsp"></jsp:include>
		</nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						<marquee width="50%" behavior="alternate" bgcolor="pink">Add
							Factory Database</marquee>
					</h1>

					<s:url var="indexEN" namespace="/" action="locale">
						<s:param name="request_locale">en</s:param>
					</s:url>
					<s:url var="indexES" namespace="/" action="locale">
						<s:param name="request_locale">es</s:param>
					</s:url>
					<s:url var="indexFR" namespace="/" action="locale">
						<s:param name="request_locale">fr</s:param>
					</s:url>

					<s:a href="%{indexEN}">English</s:a>
					<s:a href="%{indexES}">Spanish</s:a>
					<s:a href="%{indexFR}">France</s:a>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-body">
							<s:form role="form" id="add_ManuFacturer">
								<div class="row">
									<div class="col-lg-7">

										<!-- <div class="form-group"> -->
										<s:textfield name="name" id="name" key="global.name" size="20" />

										<!-- </div> -->

										<!-- <button type="submit"
											class="btn btn-default btn_submit_button">Submit
											Button</button> -->

										<s:submit name="submit" id="submit" key="global.submit" />

										<!-- <button type="reset" class="btn btn-default">Reset
											Button</button> -->

										<div class="text-center" id="responseCategory"
											style="margin-top: 14px;"></div>

									</div>
									<!-- /.row (nested) -->
								</div>

							</s:form>
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
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>

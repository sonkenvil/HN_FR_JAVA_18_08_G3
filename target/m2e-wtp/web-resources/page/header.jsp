
<!-- HEADER -->
<header>
	<!-- TOP HEADER -->
	<div id="top-header">
		<div class="container">
			<ul class="header-links pull-left">
				<li><a href="#"><i class="fa fa-phone"></i> +0167-245-2209</a></li>
				<li><a href="#"><i class="fa fa-envelope-o"></i>
						fresher@gmail.com</a></li>
				<li><a href="#"><i class="fa fa-map-marker"></i> Hoa Lac,
						Ha Noi, Viet Nam</a></li>
			</ul>
			<ul class="header-links pull-right">
				<li><a href="#"><i class="fa fa-dollar"></i> VND</a></li>
				<li><a href="<%=request.getContextPath()%>/page/login.jsp"><i class="fa fa-user-o"></i> My Account</a></li>
			</ul>
		</div>
	</div>
	<!-- /TOP HEADER -->

	<!-- MAIN HEADER -->
	<div id="header">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- LOGO -->
				<div class="col-md-3">
					<div class="header-logo">
						<a href="<%=request.getContextPath() %>/page/index.jsp" class="logo">JAVA 1808</a>
					</div>
				</div>
				<!-- /LOGO -->

				<!-- SEARCH BAR -->
				<div class="col-md-6">
					<div class="header-search">
						<div>
							<input class="input" placeholder="Product, Category or Manufacturer">
							<ul class="list-product"></ul>
						</div>
					</div>
				</div>
				<!-- /SEARCH BAR -->

				<!-- ACCOUNT -->
				<div class="col-md-3 clearfix">
					<div class="header-ctn">

						<!-- Cart -->
						<div>
							<a href="shopping-cart" id="cart"> <i class="fa fa-shopping-cart"></i> <span>Your
									Cart</span>
								<div id="cartNumber" class="qty">${session.CART_NUMBER}</div>
							</a>
						</div>
						<!-- /Cart -->
					</div>
				</div>
				<!-- /ACCOUNT -->
			</div>
			<!-- row -->
		</div>
		<!-- container -->
	</div>
	<!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

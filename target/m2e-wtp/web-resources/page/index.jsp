<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="vi">

<head>

<title>Fresher Academy - Fresher Java 08</title>

<s:include value="/page/common_head.jsp"></s:include>

<!-- custom css -->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/home.css" />

<!-- Jquery ui css -->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.min.css" />
</head>
<body>
	<!-- Header -->
	<s:include value="/page/header.jsp"></s:include>
	<!-- End Header -->
	<!-- Carousel -->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="<%=request.getContextPath()%>/img/carousel-1.png"
						alt="Los Angeles">
				</div>

				<div class="item">
					<img src="<%=request.getContextPath()%>/img/carousel-2.png"
						alt="Chicago">
				</div>

				<div class="item">
					<img src="<%=request.getContextPath()%>/img/carousel-3.png"
						alt="New York">
				</div>
			</div>

			<!-- Left and right controls -->
			<a id="prev" class="left carousel-control" href="#myCarousel"
				data-slide="prev"> <span><i class="fas fa-chevron-left"></i></span>
			</a> <a id="next" class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span><i class="fas fa-chevron-right"></i></span>
			</a>
		</div>
		<!-- /Carousel-->
	</div>

	<!-- NAVIGATION -->
	<nav id="navigation">
		<!-- container -->
		<div class="container">
			<!-- responsive-nav -->
			<div id="responsive-nav">
				<!-- NAV -->
				<ul class="main-nav nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Hot Deals</a></li>
					<li><a href="#">Categories</a></li>
					<li><a href="#">Laptops</a></li>
					<li><a href="#">Smartphones</a></li>
					<li><a href="#">Cameras</a></li>
					<li><a href="#">Accessories</a></li>
				</ul>
				<!-- /NAV -->
			</div>
			<!-- /responsive-nav -->
		</div>
		<!-- /container -->
	</nav>
	<!-- /NAVIGATION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">

				<!-- Products tab & slick -->
				<div class="col-md-12">
					<p id="new-product-tile">New Product</p>
					<div class="row">
						<div class="products-tabs">
							<!-- tab -->
							<div id="tab1" class="tab-pane active">
								<div class="products-slick" data-nav="#slick-nav-1">
									<s:iterator value="listNewProduct">
										<s:url action="product" var="productAction">
											<s:param name="productId">
												<s:property value="id" />
											</s:param>
										</s:url>
										<!-- product -->
										<div class="product new-product">
											<div class="product-img">
												<img src="${imagePath }" alt="">
												<div class="product-label">
													<span class="sale">-30%</span> <span class="new">NEW</span>
												</div>
											</div>
											<div class="product-body">
												<p class="product-category">
													<s:property value="category.name" />
												</p>
												<h3 class="product-name">
													<a href="${productAction }"><s:property
															value="productName" /></a>
												</h3>
												<h4 class="product-price">
													<s:property value="price" />
													VND
												</h4>
												<div class="product-rating">
													<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
														class="fa fa-star"></i> <i class="fa fa-star"></i> <i
														class="fa fa-star"></i>
												</div>
												<div class="add-cart">
													<button class="btn btn-info btn-detail test">
														<a class="a-detail" href="${productAction }"><i
															class="fa fa-info-circle" aria-hidden="true"></i> Detail</a>
													</button>
													<button class="btn btn-warning btn-cart"
														data-id='<s:property value="id"/>'>
														<a class="a-add-cart"><i class="fa fa-shopping-cart"></i>
															Add to cart</a>
													</button>
												</div>
											</div>
										</div>
										<!-- /product -->
									</s:iterator>
								</div>
								<div id="slick-nav-1" class="products-slick-nav"></div>
							</div>
							<!-- /tab -->
						</div>
					</div>
				</div>
				<!-- Products tab & slick -->
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">

			<div class="row">
				<!-- section title -->
				<div class="col-md-12">
					<div class="section-title">
						<p id="new-product-tile">List Product</p>
						<div class="section-nav">
							<ul class="section-tab-nav tab-nav">
								<li class="active"><a data-toggle="tab" href="#tab2">IPhone</a></li>
								<li><a data-toggle="tab" href="#tab2">Samsung</a></li>
								<li><a data-toggle="tab" href="#tab2">Oppo</a></li>
								<li><a data-toggle="tab" href="#tab2">Nokia</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- /section title -->
			</div>

			<div class="row search-by-type">
				<div class="col-md-3 sort">
					<label>Sort By Name (a -> z) </label><input type="checkbox" name="sortByName" value="sortByName"/>
					<label>Sort By Price (min -> max) </label><input type="checkbox" name="sortByPrice" value="sortByPrice"/>
				</div>
				<div class="col-md-4 rangePrice">
					<label>Range price </label> <select name="price-range">
						<option value="0">Default</option>
						<option value="1">1000000-10000000</option>
						<option value="2">10000000-20000000</option>
						<option value="3">20000000-30000000</option>
					</select>
				</div>
				<div class="col-md-3 btn">
					<input type="button" value="Search" class="btn-search"/>
				</div>
			</div>
			<script type="text/javascript">
				$(document).ready(function(){
					let sortByName,sortByPrice,minPrice,maxPrice;
					$(".search-by-type .sort input[name='sortByName']").change(function(){
						if(this.checked == true)
							sortByName = true;
					})
					$(".search-by-type .sort input[name='sortByPrice']").change(function(){
						if(this.checked == true)
							sortByPrice = true;
					})
					$(".search-by-type .rangePrice selece").change(function(){
						let value = $(this).val();
						if(value === '0'){
							minPrice = 0;
							maxPrice = 30000000;
						}
						else if(value === '1'){
							minPrice = 1000000;
							maxPrice = 10000000;
						}
						else if(value === '2'){
							minPrice = 10000000;
							maxPrice = 20000000;
						}
						else{
							minPrice = 20000000;
							maxPrice = 30000000;
						}
					})
					$(".search-by-type .btn-search").click(function(){
						if(typeof sortByName !== 'undefined' || typeof sortByPrice !== 'undefined' || minPrice !== 'undefined' || maxPrice !== 'undefined'){
							if(typeof sortName === 'undefined')
								sortByName = false;
							if(typeof sortByPrice === 'undefined')
								sortByPrice = false;
							if(typeof minPrice === 'undefined')
								minPrice = 0;
							if(typeof maxPrice === 'undefined')
								maxPrice = 30000000;
							$.ajax({
								
							})
						}
					})
				})
			</script>
			<div class="div-grid-product">
				<p class="img-gif">
					<img src="<%=request.getContextPath()%>/img/magnify.gif" />
				</p>
				<div class="grid-product">
					<div class="lam-mo"></div>
					<s:iterator value="listProduct">
						<s:url action="product" var="productAction">
							<s:param name="productId">
								<s:property value="id" />
							</s:param>
						</s:url>
						<!-- product -->
						<div class="product">
							<div class="product-img">
								<img src="${imagePath }" alt="">
								<div class="product-label">
									<span class="sale">-30%</span> <span class="new">NEW</span>
								</div>
							</div>
							<div class="product-body">
								<p class="product-category">
									<s:property value="productName" />
								</p>
								<h3 class="product-name">
									<a href="${productAction }"><s:property value="productName" /></a>
								</h3>
								<h4 class="product-price">
									<s:property value="price" />
									VND
								</h4>
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="add-cart">
									<button class="btn btn-info btn-detail">
										<a class="a-detail" href="${productAction }"><i
											class="fa fa-info-circle" aria-hidden="true"></i> Detail</a>
									</button>
									<button class="btn btn-warning btn-cart"
										data-id='<s:property value="id"/>'>
										<a><i class="fa fa-shopping-cart"></i> Add to cart</a>
									</button>
								</div>
							</div>
						</div>
						<!-- /product -->
					</s:iterator>
				</div>
				<!-- /Grid-product -->
			</div>
			<!-- Pagination -->
			<ul class="pagination">
				<li class="disabled"><a id="previous" href="#" data-index="-1">Previous</a></li>
				<s:iterator begin="1" end="totalPages">
					<s:if test="top == 1">
						<li class="active"><a href="#"
							data-index='<s:property value="top"/>'><s:property
									value="top" /></a></li>
					</s:if>
					<s:else>
						<li><a href="#" data-index='<s:property value="top"/>'><s:property
									value="top" /></a></li>
					</s:else>
				</s:iterator>
				<li><a id="next" href="#" data-index="1">Next</a></li>
			</ul>
			<!-- /Pagination -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-4 col-xs-6">
					<div class="section-title">
						<h4 class="title">Top selling</h4>
						<div class="section-nav">
							<div id="slick-nav-3" class="products-slick-nav"></div>
						</div>
					</div>

					<div class="products-widget-slick" data-nav="#slick-nav-3">
						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product07.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product08.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product09.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- product widget -->
						</div>

						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product01.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product02.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product03.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- product widget -->
						</div>
					</div>
				</div>

				<div class="col-md-4 col-xs-6">
					<div class="section-title">
						<h4 class="title">Top selling</h4>
						<div class="section-nav">
							<div id="slick-nav-4" class="products-slick-nav"></div>
						</div>
					</div>

					<div class="products-widget-slick" data-nav="#slick-nav-4">
						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product04.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product05.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product06.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- product widget -->
						</div>

						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product07.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product08.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product09.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- product widget -->
						</div>
					</div>
				</div>

				<div class="clearfix visible-sm visible-xs"></div>

				<div class="col-md-4 col-xs-6">
					<div class="section-title">
						<h4 class="title">Top selling</h4>
						<div class="section-nav">
							<div id="slick-nav-5" class="products-slick-nav"></div>
						</div>
					</div>

					<div class="products-widget-slick" data-nav="#slick-nav-5">
						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product01.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product02.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product03.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- product widget -->
						</div>

						<div>
							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product04.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product05.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- /product widget -->

							<!-- product widget -->
							<div class="product-widget">
								<div class="product-img">
									<img src="<%=request.getContextPath()%>/img/product06.png"
										alt="">
								</div>
								<div class="product-body">
									<p class="product-category">Category</p>
									<h3 class="product-name">
										<a href="#">product name goes here</a>
									</h3>
									<h4 class="product-price">
										$980.00
										<del class="product-old-price">$990.00</del>
									</h4>
								</div>
							</div>
							<!-- product widget -->
						</div>
					</div>
				</div>

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- NEWSLETTER -->
	<div id="newsletter" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<div class="newsletter">
						<p>
							Sign Up for the <strong>NEWSLETTER</strong>
						</p>
						<form>
							<input class="input" type="email" placeholder="Enter Your Email">
							<button class="newsletter-btn">
								<i class="fa fa-envelope"></i> Subscribe
							</button>
						</form>
						<ul class="newsletter-follow">
							<li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-instagram"></i></a></li>
							<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /NEWSLETTER -->

	<!-- Footer -->
	<s:include value="/page/common_footer.jsp"></s:include>
	<!-- /Footer -->

	<!-- Jquery ui js -->
	<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>

	<!-- cart js -->
	<script src="<%=request.getContextPath()%>/js/cart.js"></script>

	<!-- Load list product -->
	<script type="text/javascript" defer>
		let currentPage = 1;
		$(document).ready(function(){
			$(".pagination li a").click(function(event){
				event.preventDefault();
				let isDisabled = $(this).parent().attr('class');
				if(isDisabled !== 'disabled'){
					$(".grid-product .lam-mo").css({
						"z-index" : 10,
						"opacity" : 0.7
					});
					$(".img-gif").css({
						"display" : "block"
					});
					$(".pagination li a").parent().removeClass('active');
					$(this).parent().addClass('active');
					let id = $(this).attr('id');
					if(id === 'previous' || id === 'next')
						currentPage += parseInt($(this).attr('data-index'));
					else
						currentPage = parseInt($(this).attr('data-index'));
					if(currentPage === 1)
						$("#previous").parent().addClass('disabled');
					else
						$("#previous").parent().removeClass('disabled');
					$.ajax({
						url: 'getListProductAction',
						type: 'get',
						dataType: 'json',
						data: {
							currentPage: currentPage
						},
						success: function(result){
							$(".grid-product .product").css('display','none');
							let listProduct = result.listProduct;
							console.log(listProduct.length);
							let listCurrentProduct = $(".grid-product .product");
							if(listProduct.length > 0){
								for(let i=0;i<listProduct.length;i++){
									$(listCurrentProduct[i]).find('.product-img img').attr('src',"<%=request.getContextPath()%>/img/product01.png");
									$(listCurrentProduct[i]).find('.product-category').text(listProduct[i].category.name);
									$(listCurrentProduct[i]).find('.product-name a').text(listProduct[i].productName);
									$(listCurrentProduct[i]).find('.product-name a').attr('href','product.action?id=' + listProduct[i].id);
									$(listCurrentProduct[i]).find('.product-name .a-detail').attr('href','product.action?id=' + listProduct[i].id);
									$(listCurrentProduct[i]).css('display','block');
								}
							}
							$(".grid-product .lam-mo").css({
								"z-index" : -1,
								"opacity": 0
							});
							$(".img-gif").css({
								"display" : "none"
							})
						}
					})
				}
			})
		})
	</script>
	<!-- /Load list product -->

</body>

</html>
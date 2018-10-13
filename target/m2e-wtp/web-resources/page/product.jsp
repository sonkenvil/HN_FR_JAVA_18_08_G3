<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="vi">
<head>

<title>Product</title>
<s:include value="/page/common_head.jsp"></s:include>

<!-- file css defind -->

<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/product.css" />

<!-- tich hop wow js -->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/animate.css">

<!-- Jquery ui css -->
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery-ui.min.css" />


</head>
<body>
	<s:include value="/page/header.jsp"></s:include>

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
				<!-- Product main img -->
				<div class="col-md-4 col-md-push-2 wow fadeInDown"
					data-wow-duration="1s">
					<div class="btn-group">
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#product">Infomation Product</button>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#company">Information Company</button>
					</div>
					<div id="product-main-img">
						<div class='product-preview'>
							<img src="${product.imagePath }" />
						</div>
					</div>
				</div>
				<!-- modal information product-->

				<div id="product" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Information Product</h4>
							</div>
							<div class="modal-body">

								<h3>
									Product name:
									<s:property value="product.productName" />
								</h3>
								<p>
									Price:
									<s:property value="product.price" />
								</p>
								<p>
									Create date:
									<s:property value="product.createDate" />
								</p>
								<p>
									Color: <span
										style="display:inline-block;width:50px;height:50px;background-color:${product.color }"></span>
								</p>
								<p>
									Description:
									<s:property value="product.description" />
								</p>

							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				<!-- end  -->

				<!-- modal information company-->

				<div id="company" class="modal fade" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Informaion company</h4>
							</div>
							<div class="modal-body">
								<h3>
									Manufacturer:
									<s:property value="product.manuFacturer.name" />
								</h3>
								<p>
									Description:
									<s:property value="product.manuFacturer.description" />
								</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- end -->
				<div class="col-md-2  col-md-pull-4 wow fadeInLeft"
					data-wow-duration="1s">
					<div id="product-imgs">
						<div class='product-preview'>
							<img src="${product.imagePath }" />
						</div>
					</div>

					<!-- Product details -->
					<div class="col-md-6 wow fadeInRight" data-wow-duration="1s">
						<div class="product-details">

							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star-o"></i>
								</div>

								<h2 class="product-name">
									<s:property value="product.productName" />
								</h2>
							</div>
							<h3 class="product-price">
									<span style="color: black">Price: </span>
									<s:property value="product.price" />
									VND
							</h3>

							<p class="freeShip">
								<img src="<%=request.getContextPath()%>/img/4B6MEO.png" /> Free
								ship
							</p>
							<div class="product-options">

								<label>
									<p class="color_image">Color:</p>
									<div>

										<button class="colorOption_3imj"
											style="background-color: ${product.color}"></button>
									</div>
								</label>
							</div>

							<div class="add-to-cart">
								<div class="qty-label">
									Quantity
									<div class="input-number">
										<input type="number" value="1" disabled> <span
											class="qty-up">+</span> <span class="qty-down">-</span>
									</div>
								</div>
								<div class="add-cart">
									<button class="btn btn-warning btn-cart">
										<a><i class="fa fa-shopping-cart"></i> Add to cart</a>
									</button>
									<button class="btn btn-danger">
										<a href="<%=request.getContextPath()%>/page/checkout.jsp"><i
											class="fa fa-usd"></i> Buy now</a>
									</button>
								</div>
							</div>

						</div>
					</div>
					<!-- /Product details -->
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->

		<div class="col-md-12 wow fadeInDown">
			<div class="section-title text-center">
				<h3>Related Infomation</h3>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Qui
					ducimus eius, est magni! Voluptatem fugiat quaerat praesentium est
					minus, dolorem accusantium non neque tenetur in impedit
					necessitatibus distinctio similique, nemo eveniet sit, suscipit
					maxime ratione. Totam, soluta quaerat molestias, inventore
					asperiores sequi explicabo dicta at in maxime earum fuga dolorum,
					natus eos sit consequatur non est consectetur debitis! Quaerat
					error distinctio esse earum, nostrum minus culpa odit dolores ipsa
					veritatis? Eius repudiandae magnam voluptatem esse! Laboriosam sit
					harum illum voluptas saepe totam eveniet velit impedit non,
					inventore dicta consequatur minus vel doloremque architecto
					praesentium quis eos illo laborum deserunt. Sunt deleniti
					quibusdam, nobis eius nisi aperiam eligendi cum laudantium maxime
					reprehenderit illum suscipit distinctio, error ducimus doloremque
					fugit velit. Illo ducimus facilis eligendi ipsum, error dicta
					laborum dolore soluta omnis qui, aperiam illum praesentium corporis
					voluptates consequatur, laudantium, nam. Amet magnam corporis
					consequuntur, nulla odit, architecto consequatur quidem commodi
					delectus!</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Veniam aliquam in quidem laborum quia dolor id alias aspernatur
					sint, ipsa accusantium deleniti, distinctio perspiciatis sapiente
					eligendi velit impedit nulla ab? Itaque laboriosam, eius velit
					numquam est sint ea saepe fuga libero nesciunt? Vero quo, molestiae
					placeat deserunt laboriosam voluptatum esse similique sunt velit
					officiis nostrum blanditiis, tenetur delectus eveniet, atque nam
					porro aliquam. Odio repellat necessitatibus dolorem atque porro
					earum, consequatur sequi facilis sunt quam officiis quidem, numquam
					distinctio quas placeat cum culpa expedita doloremque iusto autem
					illo. Hic eaque possimus saepe amet laborum tempora soluta, eum
					voluptatem deserunt, aut?</p>
			</div>
		</div>
		<!-- Section -->
		<div class="section wow fadeInDown">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-12">
						<div class="section-title text-center">
							<h3 class="title">Related Products</h3>
						</div>
					</div>

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="<%=request.getContextPath()%>/img/product01.png"
									alt="">
								<div class="product-label">
									<span class="sale">-30%</span>
								</div>
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
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="add-cart">
									<button class="btn btn-info btn-detail test">
										<i class="fa fa-info-circle" aria-hidden="true"></i> DetailA
									</button>
									<button class="btn btn-warning btn-cart">
										<i class="fa fa-shopping-cart"></i> Add to cart
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /product -->

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
							<div class="product-img">
								<img src="<%=request.getContextPath()%>/img/product02.png"
									alt="">
								<div class="product-label">
									<span class="new">NEW</span>
								</div>
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
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="add-cart">
									<button class="btn btn-info btn-detail test">
										<i class="fa fa-info-circle" aria-hidden="true"></i> DetailA
									</button>
									<button class="btn btn-warning btn-cart">
										<i class="fa fa-shopping-cart"></i> Add to cart
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /product -->

					<div class="clearfix visible-sm visible-xs"></div>

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
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
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="add-cart">
									<button class="btn btn-info btn-detail test">
										<i class="fa fa-info-circle" aria-hidden="true"></i> DetailA
									</button>
									<button class="btn btn-warning btn-cart">
										<i class="fa fa-shopping-cart"></i> Add to cart
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /product -->

					<!-- product -->
					<div class="col-md-3 col-xs-6">
						<div class="product">
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
								<div class="product-rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
								<div class="add-cart">
									<button class="btn btn-info btn-detail test">
										<i class="fa fa-info-circle" aria-hidden="true"></i> DetailA
									</button>
									<button class="btn btn-warning btn-cart">
										<i class="fa fa-shopping-cart"></i> Add to cart
									</button>
								</div>
							</div>
						</div>
					</div>
					<!-- /product -->

				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /Section -->

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

		<!-- FOOTER -->
		<s:include value="/page/common_footer.jsp"></s:include>
		<!-- /FOOTER -->

		<!-- wow js -->
		<script src="<%=request.getContextPath()%>/js/wow.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/custom.js"></script>
		<!-- custom js -->
		<script src="<%=request.getContextPath()%>/js/cart.js"></script>

		<!-- Jquery ui js -->
		<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>

		<!-- Load ImageDetail -->
		<script type="text/javascript">
		let val;
		window.location.search.split('&').forEach(function(item){
			if(item.indexOf('productId') != -1){
				val = parseInt((item.split('='))[1]);
			}
		})
		$(document).ready(function(){
			$.ajax({
				url: 'getListImageDetail',
				type: 'get',
				dataType: 'json',
				data: {
					productId: val
				},
				success: function(result){
					let listImageDetail = result.listImageDetail;
					if(listImageDetail.length > 0){
						let mainImage = $("#product-main-img");
						let mainImageDetails = $("#product-imgs");
						let descriptionImageDetails = $(".description-imagedetail");
						for(let imageDetail of listImageDetail){
							let div = $("<div class='product-preview'></div>");
							let img = $("<img/>").attr('src',imageDetail.imagePath);
							$(div).append(img);
							$(mainImage).append(div);
							$(mainImageDetails).append(div);
							let description_imageDetail = $(".description-imagedetail");
							let p = $("<p></p>").text(imageDetail.description);
							$(p).css('display','none');
							$(div_image_description).append(p);
						}
					}
				}
			})
		})
	</script>
		<!-- /Load ImageDetail -->

		<!-- Custom input number -->
		<script type="text/javascript">
		$(document).ready(function() {
			$(".qty-up").click(function() {
				let input = $(".input-number input");
				let val = parseInt($(input).attr('value')) + 1;
				$(input).attr('value', val);
			})
			$(".qty-down").click(function() {
				let input = $(".input-number input");
				let val = parseInt($(input).attr('value')) - 1;
				if (val >= 0)
					$(input).attr('value', val);
			})
		})
	</script>
		<!-- /Custom input number -->

		<script>
		new WOW().init();
	</script>
</body>
</html>

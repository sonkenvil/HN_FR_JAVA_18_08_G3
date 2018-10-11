$(document).ready(function() {
	$(window).scroll(function(event) {
		/* Act on the event */
		if ($(document).scrollTop() >= 10) {
			$("#header").addClass('navbar-fixed-top');
			$("#header").css("z-index","50");
		} else {
			$("#header").removeClass('navbar-fixed-top');
		}
	});
	$(".search-btn").click(function(){
		let val  = $(".header-search .input").val();
		if(val !== ''){
			$.ajax({
				url: 'searchProductByValue',
				type: 'get',
				dataType: 'json',
				data: {
					val : val
				},
				success: function(result){
					let listProduct = result.listProduct;
					if(listProduct != null && listProduct.length > 0){
						let ul = $(".header-search .list-product");
						for(let product of listProduct){
							$(ul).append("<li><span class='img'><img src='" + product.imagePath + "'/></span><span class='name'>" + product.productName + "'</span></li>");
						}
					}
				}
			})
		}
	})
})
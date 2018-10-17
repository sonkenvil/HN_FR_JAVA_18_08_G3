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
	$(".header-search .input").keyup(function(){
		let val  = $(this).val();
		let ul = $(".header-search .list-product");
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
					console.log(listProduct.length);
					if(listProduct != null && listProduct.length > 0){
						let text = '';
						for(let product of listProduct){
							text += "<li><span class='img'><img src='" + product.imagePath + "'/></span><a class='name' href='product?productId=" + product.id + "'>" + product.productName + "</a></li>";
						}
						$(ul).html(text);
						$(ul).css('display','block');
					}
				}
			})
		}
		$(ul).css('display','none');
	})
	$(".header-search .input").focusout(function(){
		$(".header-search .list-product").css('display','none');
	})
})
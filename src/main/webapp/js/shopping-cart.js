$(document).ready(function(){
	var sum = 0;
	$(".total").each(function(){
		sum += parseFloat($(this).text());
	});
	$("div > .total-price").text(sum.toFixed(2));
	var name = '<%= session.getAttribute("CART_NUMBER") %>';
	console.log(name);
	$("#cart > tbody > tr").on("click",".input-number-product", function(e){
		var row = $(this).closest('tr');
		var total_line_item = row.find(".price-product").text() * row.find(".input-number-product").val();
		var total = (row.find("td:eq(3)"));
		total.text(total_line_item); 
		$(".total").each(function(){
			sum += parseFloat($(this).text());
		});
		$("div > .total-price").text(sum.toFixed(2));
		$.ajax({
			type : 'POST',
			url : 'editNumberProduct',
			data : {
				'productId' : row.find('td.NoneDisplay').text(),
				'number' : row.find(".input-number-product").val()
			},
			dataType : 'json',
			success : function(data) {
				console.log("success");
			}
		});
		
	})
	
	$("#cart > tbody > tr").on("click",".btn-remove-item",function(){
		var row = $(this).closest('tr');
		var total = row.find("td:eq(3)").text();
		var currentValue = parseFloat($(".total-price").text()) - parseFloat(total); 	
		$(".total-price").text(currentValue.toFixed(2));
		$.ajax({
			type : 'POST',
			url : 'removeProduct',
			data : {
				'productId' : row.find('td.NoneDisplay').text(),
			},
			dataType : 'json',
			success : function(data) {
				$("#cartNumber").html(data.refreshNumberCart);
			}
		});
		row.remove();
	})
})
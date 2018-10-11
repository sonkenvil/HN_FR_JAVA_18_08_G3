$(document).ready(function(){
	$("#cart").on("click",".input-number-product", function(e){
		
		var row = $(this).closest('tr');
		var total_line_item = row.find(".price-product").text() * row.find((".input-number-product")).val();
		var total = (row.find("td:eq(3)"));
		total.text(total_line_item); // display  price product
		var sum = 0;
		$(".total").each(function(){
			sum += parseFloat($(this).text());
		});

		$(".total-price").text(sum.toFixed(2));
		
	})
	
	$("#cart").on("click",".btn-remove-item",function(){
		var row = $(this).closest('tr');
		var total = row.find("td:eq(3)").text();
		var currentValue = parseFloat($(".total-price").text()) - parseFloat(total); 	
		$(".total-price").text(currentValue.toFixed(2));
		row.remove();
	})
	
	
		
})
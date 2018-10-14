$(document).ready(function() {
	var sum = 0;
	$(".order-products > .order-col > .total-price").each(function() {
		$(this).text("$"+convertFormatNumber($(this).text()));
	})
	$(".order-products > .order-col > .total-price").each(function() {
		sum += parseInt(convertTypeMoney($(this).html()));
	})
	$(".order-col > div > .order-total").text("$"+convertFormatNumber(sum.toString()));

	function convertFormatNumber(input){
		var length = input.length;
		var count = 0;
		var result="";
		for( var i = length -1 ; i >= 0 ; i--){
			count++;
			result += input[i];
			if(count % 3 === 0 && count !== 0){
				result += ".";
			}
		}
		console.log(reverse);
		return reverse(result);
	}
	
	function reverse(input){
		var result="";
		for(var i = input.length-1 ; i >= 0 ; i--){
			result += input[i];
		}
		if(result[0] === ".") {
			result = result.substr(1);
		}
		return result;
	}
	
	function convertTypeMoney(input){
		var result ="";
		input = input.toString();
		console.log(input);
		input = input.substr(1);
		console.log(input);
		for(var i = 0 ; i < input.length ; i++){
			if(input[i] !== '.'){
				result += input[i];
			}
		}
		return result;
	}
})
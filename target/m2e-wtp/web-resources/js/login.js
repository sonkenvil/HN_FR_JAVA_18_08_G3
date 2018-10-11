$("#loginform").validate({
	rules: {
		email:{
			required: true,
 			email: true
		},
		password: {
			required: true
		}
	}
	,submitHandler: function(form){
		$("label.error").hide();
		 form.submit();
	}
})
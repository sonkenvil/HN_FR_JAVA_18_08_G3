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
})
$(document).ready(function() {
	$('#addCart').click(function() {
		var quantity = $('#quantity').val();
		var product = $('#productId').val();
		$.ajax({
			url : "cart/add",
			method : 'POST',
			data:{
				quantity : quantity,
				productId:product
			},
			success:function(response) {
				window.location.href = 'cart';
			}
		}).done(function() {
			
		});

	});

});
$( document ).ready(function() {
	// Handler for .ready() called.
	$.ajax({
		  url: "home/loadProducts",
		  dataType : 'json',
		  method: 'GET'
		}).done(function(data) {
		  console.log(data)
		  var showProductElement = $('#showProduct');
		  for(var i=0;i<data.length;i++){
			  var elementData = data[i];
			  var elementProduct = '<div class="col-lg-4">';
			  elementProduct += '<img class="rounded-circle" src="'+elementData.image;
			  elementProduct += '" width="140" height="140">';
			  elementProduct += '<h2>'+elementData.name+'</h2>';
			  elementProduct += '<p>'+elementData.decription+'</p>';
			  elementProduct +='<p><a class="btn btn-secondary" '
				 + 'href=viewDetail?productId='+elementData.idProduct+'>View details &raquo;</a></p>';
			  elementProduct += '</div>';
			  showProductElement.append(elementProduct);
			  
		  }
		});
});
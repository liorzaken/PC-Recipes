
var searchItem = ["cheese","choclate","Bamba","chicken"];
$(document).ready(function() {
	$('#addProd').click(function() {
		var newProd = $('input[name=addItem]').val();
		$('.listProd').append('<div class="item">'+newProd+ '</div>');
		$('input[name=addItem]').val("");


		
/*		
		$.ajax({
		    url: "/FilterProd",
		    type: "GET",
		    data: newProd,
		    success: function(data){ 
		    	
		        //handle returned arrayList
		    },
		    error: function(e){  
		        //handle error
		    } 
		});
*/
	});
});

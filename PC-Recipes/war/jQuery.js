var searchItem = ["cheese","choclate","Bamba","chicken"];
$(document).ready(function() {
    $('button').click(function() {
    	$('#mainFrame p').html("תוצאות חיפוש");
    	for(var i=0; i<searchItem.length; i++){
    		$('#mainFrame').append("<p>" +searchItem[i]+ "</p><hr/>");
    	}
    	$(this).remove();
    });
});
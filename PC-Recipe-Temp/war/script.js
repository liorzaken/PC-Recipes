


//מחפש האם מוצר קיים במערכת
var prods = [];
var ans = [];
$(document).ready(function() {
	$('#addProd').click(function() {

		var newProd = $('input[name=addItem]').val();
		var dataString = "value=" + newProd;
		$.ajax({
			url: "/FilterProd",
			type: "GET",
			data: dataString,
			success: function(ret){ 
				if(ret=="0"){
					alert(newProd + " לא קיים במערכת");
				}
				else{
					prods.push(newProd);
					$('.listProd').append('<div class="item">'+newProd+ '</div>');
				}
				$('input[name=addItem]').val("");
				//handle returned arrayList
			},
			error: function(e){  
				alert("error");
				//handle error
			} 
		});

	});
});


//לכתוב את הפונקציה השניה שמציגה את הסינון
$(document).ready(function() {
	var newAns="";
//	$('.ans_choice').click(function() {
		$('#ans1').click(function() {
			newAns = $(this).text();
			ans.push(newAns);
			alert(ans);
		});
		$('#ans2').click(function() {
			newAns = $(this).text();
			ans.push(newAns);
			alert(ans);
		});
		$('#ans3').click(function() {
			newAns = $(this).text();
			ans.push(newAns);
			alert(ans);
		});
		$('#ans4').click(function() {
			newAns = $(this).text();
			ans.push(newAns);
			alert(ans);
		});
		
		$('#ans5').click(function() {
			newAns = $(this).text();
			alert(ans);
		});
		
//	});
});


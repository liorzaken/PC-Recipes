
$(document).ready( function() {
	$('.listRecipe').append('<div id=RecipesView></div>');
//	$('#RecipeView').text("");
	$.ajax({
		url: "/FirstLoad",
		type: "GET",
//		data: dataString,
		success: function(ret){ 
			if(ret=="0"){
				alert(newRecipe + " לא קיים במערכת");
			}
			else{
				var recipeArr = ret.split(',');
				$('#RecipesView').remove();
				for ( var i = 0; i < recipeArr.length; i = i + 1 ) {
					recipe.push(recipeArr[i]);
					$('.listRecipe').append('<div id=RecipesView></div>');
					$('#RecipesView').append('<div id="itemRec"><a href="/Search?SearchItem='+recipeArr[i]+'" target="_blank">'+recipeArr[i]+'</a></div>');
				}
			}
//			$('input[name=SearchItem1]').val("");
			//handle returned arrayList
		},
		error: function(e){  
			alert("error");
			//handle error
		} 
	});
	
	
});

//מחפש האם מוצר קיים במערכת
var prods = [];
var ans = [];
var recipe = [];
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




//מחפש מתכונים

$(document).ready(function() {
	$('#searchButton1').click(function() {
		var newRecipe = $('input[name=SearchItem1]').val();
		var dataString = "value=" + newRecipe;
		$.ajax({
			url: "/FilterRecipeName",
			type: "GET",
			data: dataString,
			success: function(ret){ 
				if(ret=="0"){
					alert(newRecipe + " לא קיים במערכת");
				}
				else{
					var recipeArr = ret.split(',');
					$('#RecipesView').remove();
					for ( var i = 0; i < recipeArr.length; i = i + 1 ) {
						recipe.push(recipeArr[i]);
						$('.listRecipe').append('<div id=RecipesView></div>');
						$('#RecipesView').append('<div id="itemRec"><a href="/Search?SearchItem='+recipeArr[i]+'">'+recipeArr[i]+'</a></div>');
					}
				}
				$('input[name=SearchItem1]').val("");
				//handle returned arrayList
			},
			error: function(e){  
				alert("error");
				//handle error
			} 
		});

	});


});

$(document).ready(function() {
	$('#itemRec').click(function() {

		var recipeToSearch = $(this).text();
		var dataString = "recipeSearch=" + recipeToSearch;
		$.ajax({
			url: "/Search",
			type: "GET",
			data: dataString,
			success: function(ret){ 
				//if(ret=="0"){
					alert(newProd + " לא קיים במערכת");
				//}
				
			},
			error: function(e){  
				alert("error");
				//handle error
			} 
		});

	});
});
var recipe = [];
var prods = [];
var categorys = [];
var i=0;
var recipeProd = [];
var recipeCategory = [];

var x=0;
//first load list from all recipes
$(document).ready( function() {

	$('.listProd').append('<div id=ProdsView></div>');
	$('.listRecipe').append('<div id=RecipesView></div>');

	$.ajax({
		url: "/FirstLoad",
		type: "GET",
		success: function(ret){ 
			if(ret=="0"){
				alert(newRecipe + " לא קיים במערכת");
			}
			else{
				recipe = ret.split(',');
				display(recipe);
			}
		},
		error: function(e){  
			//handle error
		} 
	});

//	search by products
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

					$('#ProdsView').append('<div class="item">'+newProd+ '</div>');
					searchByProd();
				}
				$('input[name=addItem]').val("כתוב כאן");
				//handle returned arrayList
			},
			error: function(e){  
				//handle error
			} 
		});

		//find all recipes with all products
		function  searchByProd(){
			var str ="";
			for(var t=0; t<prods.length; t= t+1){
				str +=prods[t]+",";
			}
			var dataString = "Prod=" + str;
			$.ajax({
				type: "GET", 
				url:  "/FilterRecipeByProd",
				data: dataString,
				success: function(ret){

					recipeProd = ret.split(',');
					intersection();

				}
			});
		}
	});


//	answer handler
	var newAns="";
	$('#ans1').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
	});
	$('#ans2').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
	});
	$('#ans3').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
	});
	$('#ans4').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
	});
	$('#ans5').click(function() {
		//	newAns = $(this).text();
		searchByCategory();
	});

	function  searchByCategory(){
		var str ="";
		for(var t=0; t<categorys.length; t= t+1){
			str +=categorys[t]+",";
		}
		var dataString = "Category=" + str;
		$.ajax({
			type: "GET", 
			url:  "/FilterByCategory",
			data: dataString,
			success: function(ret){

				recipeCategory = ret.split(',');
				intersection();
			}
		});
	}



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
					display(recipeArr);
				}
				prods=[];
				categorys=[];
				$('#ProdsView').remove();
				$('.listProd').append('<div id=ProdsView></div>');
				$('input[name=SearchItem1]').val("כתוב כאן");
				//handle returned arrayList
			},
			error: function(e){  
				//handle error
			} 
		});
	});

	function  intersection(){
				
		var catStr ="";
		for(var t=0; t < recipeCategory.length; t= t+1){
			catStr += recipeCategory[t]+",";
		}
		var prodsStr ="";
		for(var t=0; t < recipeProd.length; t= t+1){
			prodsStr += recipeProd[t]+",";
		}
		var dataString = {catVal:  catStr , prodVal:prodsStr};
		$.ajax({
			type: "GET", 
			url:  "/Intersection",
			data: dataString,
			success: function(ret){
				if(ret=="1"){
					display(recipe);
				}
				else if(ret=="2"){
					display(recipeProd);
				}
				else if(ret=="3"){
					display(recipeCategory);
				}
				else{
					var newArr = ret.split(',');
					display(newArr);
				}
			},
			error: function(e){  
				//handle error
			} 
		});

	}


});





function display(array){

	$('#RecipesView').remove();
	$('.listRecipe').append('<div id=RecipesView></div>');
	for ( var t = 0; t < array.length; t = t + 1 ) {
		$('#RecipesView').append('<div id="itemRec"><a href="/Search?SearchItem='+array[t]+'">'+array[t]+'</a></div>');
	}
}







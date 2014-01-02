var recipe = [];
var prods = [];
var categorys = [];
var recipeProd = [];
var recipeCategory = [];
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
			for(var i=0; i<prods.length; i= i+1){
				str +=prods[i]+",";
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
//		changeQeustion();
	});
	$('#ans2').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
//		changeQeustion();
	});
	$('#ans3').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
//		changeQeustion();
	});
	$('#ans4').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
//		changeQeustion();
	});
	$('#ans5').click(function() {
		//	newAns = $(this).text();
		searchByCategory();
//		changeQeustion();
	});

	function  searchByCategory(){
		var str ="";
		for(var i=0; i<categorys.length; i= i+1){
			str +=categorys[i]+",";
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
				recipeProd = [];
				recipeCategory = [];
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
		for(var i=0; i < recipeCategory.length; i= i+1){
			catStr += recipeCategory[i]+",";
		}
		var prodsStr ="";
		for(var i=0; i < recipeProd.length; i= i+1){
			prodsStr += recipeProd[i]+",";
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
	$('#clearSearch').click(function() {
		prods = [];
		categorys = [];
		recipeProd = [];
		recipeCategory = [];
		$('#ProdsView').remove();
		$('.listProd').append('<div id=ProdsView></div>');
		$('input[name=SearchItem1]').val("כתוב כאן");
		display(recipe);
	});
	$('#clearProds').click(function() {
		prods = [];
		recipeProd = [];
		$('#ProdsView').remove();
		$('.listProd').append('<div id=ProdsView></div>');
		$('input[name=SearchItem1]').val("כתוב כאן");
		intersection();
	});




});

function changeQeustion (){
/*	$.ajax({
		type: "POST", 
		url:  "/displayQuestion",
		success: function(ret){

		},
	error: function(e){
	}
	});
	
	*/
}



function display(array){

	$('#RecipesView').remove();
	$('.listRecipe').append('<div id=RecipesView></div>');
	for ( var i = 0; i < array.length; i = i + 1 ) {
		$('#RecipesView').append('<div id="itemRec"><a href="/Search?SearchItem='+array[i]+'" target="_blank">'+array[i]+'</a></div>');
	}
}







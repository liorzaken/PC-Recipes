var recipe = [];
var prods = [];
var categorys = [];
var recipeProd = [];
var recipeCategory = [];
var QFinish = [];
var currentQuest=0;
//var QuestArr = [];
//first load list from all recipes

$(document).ready( function() {
	hideAns();

	$('.listProd').append('<div id=ProdsView></div>');
	$('.listRecipe').append('<div id=RecipesView></div>');
	QFinish.push(0);
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
					prods.push(ret);
					$('#ProdsView').append('<div class="item">'+ret+ '</div>');
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
	$('#ansr1').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
		changeQeustion();		
	});
	$('#ansr2').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
		changeQeustion();
	});
	$('#ansr3').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
		changeQeustion();
	});
	$('#ansr4').click(function() {
		newAns = $(this).text();
		categorys.push(newAns);
		searchByCategory();
		changeQeustion();
	});
	$('#ansr5').click(function() {
		changeQeustion();
	});


	//$("ul#answer li:contains('undefined')").hide();

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
			},
			error: function(e){  
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
			} 
		});
	}
	$('#clearSearch').click(function() {
		clear();
	});
	$('#endOfQuestion').click(function() {
		clear();
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


function clear(){
	prods = [];
	categorys = [];
	recipeProd = [];
	recipeCategory = [];
	QFinish = [];
	QFinish.push(0);
	showAns();
	$('#question').text("מהו סוג הבישול הרצוי?");
	$('#ansr1').text("אפייה");
	$('#ansr2').text("טיגון");
	$('#ansr3').text("בישול");
	$('#ansr4').text("");
	$('#ansr5').text("דלג שאלה");
	hideAns();

	$('#ProdsView').remove();
	$('.listProd').append('<div id=ProdsView></div>');
	$('input[name=SearchItem1]').val("כתוב כאן");
	display(recipe);
}

function changeQeustion (){
	var QFinishStr ="";
	for(var i=0; i < QFinish.length; i= i+1){
		QFinishStr += QFinish[i]+",";
	}
	var dataString = "str=" + QFinishStr;
	$.ajax({
		type: "GET", 
		url:  "/DisplayQuestion",
		data: dataString,
		success: function(ret){
			if(ret=="0"){
				$('#endOfQuestion').show();
				$('#ansr1').hide();
				$('#ansr2').hide();
				$('#ansr3').hide();
				$('#ansr4').hide();
				$('#ansr5').hide();
				currentQuest = 0;
			}
			else{
				showAns();
				var QuestArr = ret.split(',');
				$('#question').text(QuestArr[0]);
				$('#ansr1').text(QuestArr[1]);
				$('#ansr2').text(QuestArr[2]);
				$('#ansr3').text(QuestArr[3]);
				$('#ansr4').text(QuestArr[4]);
				$('#ansr5').text(QuestArr[5]);
				hideAns();
				currentQuest = parseInt(QuestArr[6]);
				QFinish.push(currentQuest);
			}
		},
		error: function(e){
		}
	});
}
function showAns(){
	$('#endOfQuestion').hide();
	$('#ansr1').show();
	$('#ansr2').show();
	$('#ansr3').show();
	$('#ansr4').show();
	$('#ansr5').show();
}
function hideAns(){
	if($.trim($('#ansr1').text()) == "")
		$('#ansr1').hide();
	if($.trim($('#ansr2').text()) == "")
		$('#ansr2').hide();
	if($.trim($('#ansr3').text()) == "")
		$('#ansr3').hide();
	if($.trim($('#ansr4').text()) == "")
		$('#ansr4').hide();
	if($.trim($('#ansr5').text()) == "")
		$('#ansr5').hide();
}
function display(array){

	$('#RecipesView').remove();
	$('.listRecipe').append('<div id=RecipesView></div>');
	for ( var i = 0; i < array.length; i = i + 1 ) {
		$('#RecipesView').append('<hr><div id="itemRec"><a href="/Search?SearchItem='+array[i]+'" target="_blank">'+array[i]+'</a></div>');
	}
}

function validate(){
	$(".requiredAttr").each(function(){
		if($(this).val().length < 1){
			alert("נא למלא את כל השדות");
			$(this).focus();
			return false;
		}
		else{
			return true;
		}
	});

	return false;
}
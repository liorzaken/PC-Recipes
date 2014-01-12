var recipe = [];
var prods = [];
var categorys = [];
var recipeByName = [];
var recipeProd = [];
var recipeCategory = [];
var QuestArr=[];
var QFinish = [];
var currentQuest=0;
$(document).ready( function() {
	QFinish.push(0);
	/**display all recipes at loading main page*/
	$.ajax({
		url: "/FirstLoad",
		type: "GET",
		success: function(ret){ 
			if(ret!="0"){
				recipe = ret.split(',');
				$('#RecipesView').hide();
				display(recipe);
			}
		},
		error: function(e){  
		} 
	});

	/**search recipes by name*/
	$('#searchButton').click(function() {
		var newRecipe = $('input[name=SearchItem]').val();
		var dataString = "value=" + newRecipe;
		$.ajax({
			url: "/FilterRecipeName",
			type: "POST",
			data: dataString,
			success: function(ret){ 
				if(ret=="0" || ret==""){
					alert(newRecipe + " לא קיים במערכת");
				}
				else{
					clear();
					recipeByName = ret.split(',');
					$('#titleResult').text("תוצאות חיפוש: " +newRecipe);
					intersection();
				}
				$('input[name=SearchItem]').val("כתוב כאן");
			},
			error: function(e){  
			} 
		});
	});


	/**search by products*/
	$('#addProd').click(function() {
		var newProd = $('input[name=addItem]').val();
		var dataString = "value=" + newProd;
		$.ajax({
			url: "/SearchProdInDB",
			type: "POST",
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
			},
			error: function(e){  
			} 
		});
	});


	/**	click answer handler*/
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

	/**clear search*/
	$('#clearSearch').click(function() {
		clear();
		intersection();
	});
	$('#endOfQuestion').click(function() {
		clear();
		intersection();
	});

	/**clear prod list*/
	$('#clearProds').click(function() {
		prods = [];
		recipeProd = [];
		$('#ProdsView').remove();
		$('.listProd').append('<div id=ProdsView></div>');
		$('input[name=SearchItem1]').val("כתוב כאן");
		
		showAns();
		if(currentQuest==0)
			$('#question').text("מהו סוג הבישול הרצוי?");
		else
			$('#question').text(QuestArr[0]);
		hideAns();
		
		intersection();
	});
});

function  searchByProd(){
	var str ="";
	for(var i=0; i<prods.length; i= i+1){
		if(prods[i]!="")
			str +=prods[i]+",";
	}
	var dataString = "Prod=" + str;
	$.ajax({
		type: "POST", 
		url:  "/FilterRecipeByProd",
		data: dataString,
		success: function(ret){
			recipeProd = ret.split(',');
			if(recipeProd.length<=1){
				alert("אין תוצאות");
				clear();
			}
			intersection();
		}
	});
}

function  searchByCategory(){
	var str ="";
	for(var i=0; i<categorys.length; i= i+1){
		if(categorys[i]!="")
			str +=categorys[i]+",";
	}
	var dataString = "Category=" + str;
	$.ajax({
		type: "POST", 
		url:  "/FilterByCategory",
		data: dataString,
		success: function(ret){
			recipeCategory = ret.split(',');
			if(recipeCategory.length<=1){
				alert("אין תוצאות");
				clear();
			}
			intersection();
		}
	});
}

function  intersection(){

	var catStr ="";
	for(var i=0; i < recipeCategory.length; i= i+1){
		if(recipeCategory[i]!="")
			catStr += recipeCategory[i]+",";
	}
	var prodsStr ="";
	for(var i=0; i < recipeProd.length; i= i+1){
		if(recipeProd[i]!="")
			prodsStr += recipeProd[i]+",";
	}
	var recipeByNameStr="";
	for(var i=0; i < recipeByName.length; i= i+1){
		if(recipeByName[i]!="")
			recipeByNameStr += recipeByName[i]+",";
	}

	var dataString = {catVal:  catStr , prodVal:prodsStr , nameVal:recipeByNameStr};
	$.ajax({
		type: "POST", 
		url:  "/Intersection",
		data: dataString,
		success: function(ret){
			if(ret==""){
				alert("אין תוצאות");
			}
			if(ret=="all"){
				display(recipe);
			}
			else if(ret=="prod"){
				display(recipeProd);
			}
			else if(ret=="category"){
				display(recipeCategory);
			}
			else if(ret=="name"){
				display(recipeByName);
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
function clear(){
	$('#titleResult').text("תוצאות חיפוש:");
	recipeByName = [];
	prods = [];
	categorys = [];
	recipeProd = [];
	recipeCategory = [];
	QFinish = [];
	QFinish.push(0);
	currentQuest = 0;
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
}

function changeQeustion (){
	var QFinishStr ="";
	for(var i=0; i < QFinish.length; i= i+1){
		QFinishStr += QFinish[i]+",";
	}
	var dataString = "str=" + QFinishStr;
	$.ajax({
		type: "POST", 
		url:  "/DisplayQuestion",
		data: dataString,
		success: function(ret){
			if(ret=="0"){
				$('#question').text("סוף מאגר השאלות");
				$('#endOfQuestion').show();
				$('#endOfQuestion').text("חפש מחדש");
				$('#ansr1').hide();
				$('#ansr2').hide();
				$('#ansr3').hide();
				$('#ansr4').hide();
				$('#ansr5').hide();
				currentQuest = 0;
			}
			else{
				showAns();
				QuestArr = ret.split(',');
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

	if(array.length <= 5){
		$('#question').text("לא מצאת את מה שחיפשת?");
		$('#endOfQuestion').show();
		$('#endOfQuestion').text("חפש מחדש");
		$('#ansr1').hide();
		$('#ansr2').hide();
		$('#ansr3').hide();
		$('#ansr4').hide();
		$('#ansr5').hide();
	}
	$('#RecipesView').remove();
	$('.listRecipe').append('<div id=RecipesView></div>');
	$( "#RecipesView" ).hide();
	$( "#RecipesView" ).fadeIn(  );
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

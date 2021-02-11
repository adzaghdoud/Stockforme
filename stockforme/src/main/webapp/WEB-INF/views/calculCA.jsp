<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="/resources/inc/stylecreatecommande.css" %>
</style>
<meta charset="utf-8" />
<title>Insert title here</title>
</head>
<body>
<form method="post" action="CalculCA">
<div>

<fieldset>
<legend>Saisie date recherche Chiffre d'affaire</legend>
<label for="datedebut">Date Début :</label>
 <input type="date" id="datecommandedebut" name="datecommandedebut" min="2019-01-01" max="3020-12-31">         
<br/>
<label for="datefin">Date Fin :</label>
 <input type="date" id="datecommandefin" name="datecommandefin" min="2019-01-01" max="3020-12-31">         
<br/>
<label for="Chiffreaffaire">Chiffre d'affaire Euros:</label>
 <input type="text"  name="totalca" value=${ ca }>         
<br/>
<input type="submit" value="Générer"/>  <span class="erreur">${erreur['datedebutvide']}</span>  <span class="erreur">${erreur['datefinvide']}</span> <span class="erreur">${erreur['intervallevide']}</span> 
 <br/>
</fieldset>

</div>

</form>
</body>
</html>
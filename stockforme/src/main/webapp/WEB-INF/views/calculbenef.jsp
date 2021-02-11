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
<form method="post" action="CalculBenef">
<div>

<fieldset>
<legend>Saisie date recherche bénéfice </legend>
<label for="datedebut">Date Début :</label>
 <input type="date" id="datecommandedebut" name="datecommandedebut" min="2019-01-01" max="3020-12-31">         
<br/>
<label for="datefin">Date Fin :</label>
 <input type="date" id="datecommandefin" name="datecommandefin" min="2019-01-01" max="3020-12-31">         
<br/>

<label for="nbvente">Nombre de vente:</label>
 <input type="text"  name="totalbenef" value=${ nbvente } >         
<br/>
<label for="benefice">Bénéfice Euros:</label>
 <input type="text"  name="totalbenef" value=${ benef } >         
<br/>
<input type="submit" value="Générer"/>  <span class="erreur">${erreur['datedebutvide']}</span>  <span class="erreur">${erreur['datefinvide']}</span> <span class="erreur">${erreur['intervallevide']}</span> 
 <br/>
</fieldset>

</div>

</form>
</body>
</html>
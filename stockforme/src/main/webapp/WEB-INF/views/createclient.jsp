<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<style>
label
{
	display: block;
	width: 150px;
	float: left;
}
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}

input[type=text] ,input[type=date], input[type=email],select {
  width: 10%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit],input[type=reset] {
  width: 10%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit],input[type=reset]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>
<meta charset="utf-8" />
<title>Creation nouveau client</title>
<link type="text/css" rel="stylesheet" href="inc/style.css">

</head>
<body>
  
 <form method="post" action="Servletcreateuser">
<div>
<fieldset>
<legend><h3>Creation Nouveau Client </h3></legend>
<label for="nom"> <b> Nom : </b> </label>
<input type="text" name="nom" id="nom" />
</br>
<label for="prenom"> <b> Prenom : </b> </label>
<input type="text" name="prenom" id="prenom" />
</br>
 <label for="email"> <b> Email :</b> </label> 
 <input type="email" name="email"/> <span class="erreur">${erreurs['emailerror']}</span>
 </br>
<label for="adresse"> <b> Adresse : </b> </label>
<input type="text" name="adresse" id="adresse" />
</br>

<label for="tel"> <b> Tel : </b> </label>
<input type="text" name="tel" id="tel" />
</br>

 <input type="submit" value="enregistrer"/>  <input type="reset" value="reset"/>
 </br>
 </form>
 </table>
  <p class="${empty erreurs ? 'succes' :'erreur'}">${resultat}</p>
 </fieldset> 
 </div>  


</div>
</body>
</html>
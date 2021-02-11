<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Chercher Fournisseur</title>
</head>
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

input[type=text] ,input[type=email], select {
  width: 10%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 10%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.erreur {
color: #900;
}
</style>
<body>
 <form method="post" action="fournisseur">
<div>
<label for="id">id :</label>
<select  name="id">
  <option value=""></option>
  
  <c:forEach var="fournisseur" items="${ fournisseurs }">
    
<option value="${fournisseur.id}"> <c:out value="${fournisseur.id}--${fournisseur.nom}"/> </option>  
 </c:forEach>  
</select>  <span class="erreur"> ${erreurchoix} </span> 
 <br/>
 <input type="submit" value="rechercher"/>
 <br/>
 </div>
 <div>
 
 <table>
  <tr>
    <th>Id Fournisseur </th>
    <th>Nom </th>
    <th>Adresse</th>
    <th>tel</th>
    <th>Iban</th>
    <th>Siret</th>
  </tr>
         <tr>
           <td><b>${fourn.id}</b></td>   
           <td><b>${fourn.nom}</b></td>
           <td><b>${fourn.adresse}</b></td>
           <td><b>${fourn.tel}</b></td>
           <td><b>${fourn.iban}</b></td>
           <td><b>${fourn.siret}</b></td>
           </tr>
 
</table>
 
 
 </div>
 
 
 
 </form>
</body>
</html>
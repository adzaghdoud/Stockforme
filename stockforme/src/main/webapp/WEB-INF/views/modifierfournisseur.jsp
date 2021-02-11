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

<script>
function update_row() {
   var t = document.getElementById("tablefournisseur"); // This have to be the ID of your table, not the tag
   var numfourajax = document.getElementById ('numf').innerText;
   var nomfourajax = t.rows[1].cells[1].getElementsByTagName('input')[0].value;
   var adresseajax = t.rows[1].cells[2].getElementsByTagName('input')[0].value;
   var telajax = t.rows[1].cells[3].getElementsByTagName('input')[0].value;
   var ibanajax = t.rows[1].cells[4].getElementsByTagName('input')[0].value;
   var siretajax = t.rows[1].cells[5].getElementsByTagName('input')[0].value;
   try {
   var xhttp  = new XMLHttpRequest();
   xhttp.open("POST", "saveupdate", false);
   xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
   var params = "numfourajax="+numfourajax+"&nomfourajax="+nomfourajax+"&adresseajax="+adresseajax+"&telajax="+telajax+"&ibanajax="+ibanajax+"&siretajax="+siretajax
   xhttp.send(params);
   alert("Modification Fournisseur ok")
   } catch(err) {
	    alert(err.message);
   }     
   } 
   

  
</script>
<body>
 <form method="post" action=viewsaveupdate>
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
 
 <table id="tablefournisseur">
  <tr>
    <th>Id Fournisseur </th>
    <th>Nom </th>
    <th>Adresse</th>
    <th>tel</th>
    <th>Iban</th>
    <th>Siret</th>
    <th>Action </th>
  </tr>
         <tr>
           <td id="numf"><b>${fourn.id}</b></td>   
           <td> <input type="text"  style="width: 60%;" value="<c:out value="${fourn.nom}"/>"/> </td>
           <td> <input type="text"  style="width: 60%;"  value="<c:out value="${fourn.adresse}"/>"/> </td>
           <td> <input type="text"  style="width: 60%;" value="<c:out value="${fourn.tel}"/>"/> </td>
           <td> <input type="text"  style="width: 60%;" value="<c:out value="${fourn.iban}"/>"/> </td>
           <td> <input type="text"  style="width: 60%;"  value="<c:out value="${fourn.siret}"/>"/> </td>
           <td><a href="" onclick="update_row()"> <img src="${pageContext.request.contextPath}/resources/images/save.ico"style="width: 20px;"alt="save"/> </a> </td>
           </tr>
 
</table> 
 </div>
 
 
 
 </form>
</body>
</html>
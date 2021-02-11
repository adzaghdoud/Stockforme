<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Modifier Stock</title>
</head>
<style>
<%@include file="/resources/inc/stylecreatecommande.css" %>
</style>
<script>
function update_row() {
   var t = document.getElementById("tablestock"); // This have to be the ID of your table, not the tag
   var codeproduitajax = document.getElementById ('cproduit').innerText;
   var stockajax = t.rows[1].cells[2].getElementsByTagName('input')[0].value;
   try {
   var xhttp  = new XMLHttpRequest();
   xhttp.open("POST", "savemodifstock", false);
   xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
   var params = "codeproduitajax="+codeproduitajax+"&stockajax="+stockajax;
   xhttp.send(params);
   alert("Modification ok")
   } catch(err) {
	    alert(err.message);
   }     
   } 
</script>
<body>
 <form method="post" action="viewupdatestock">
<div>
<label for="codeproduit">Codeproduit : </label>
<select  name="cp">
  <option value=""></option>
  
  <c:forEach var="stock" items="${ detail }">
    
<option value="${stock.codeproduit}"> <c:out value="${stock.codeproduit}--${stock.libproduit}"/> </option>  
 </c:forEach>  
</select>
 <br/>
 <input type="submit" value="rechercher"/><span class="erreur"> ${erreur} </span> 
 <br/>

 </div>
 </form>
<div>

<table ID="tablestock">
  <tr>
    <th>Code produit </th>
    <th>libellé </th>
    <th>Stock</th>
    <th>Action </th>
  </tr>
           <tr> 	
           <td id="cproduit"> <b><c:out value="${listestock.codeproduit}" /> </b> </td>  
           <td> <b><c:out value="${listestock.libproduit}" /> </b> </td>
           <td> <input type="text"  style="width: 30%;" name="stock"  value="<c:out value="${listestock.stock}"/>"/> </td>
           <td><a href="" onclick="update_row()"> <img src="${pageContext.request.contextPath}/resources/images/save.ico"style="width: 20px;"alt="save"/> </a> </td>
           </tr>
</table>
</div>
</body>
</html>
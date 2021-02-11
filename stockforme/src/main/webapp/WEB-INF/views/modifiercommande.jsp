<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Chercher Commande</title>
</head>
<style type="text/css">
<%@include file="/resources/inc/stylecreatecommande.css" %>
</style>
<script>
function update_row() {
   var t = document.getElementById("tablescommande"); // This have to be the ID of your table, not the tag
   var numcommandeajax = document.getElementById ('nuc').innerText;
   var montantajax = t.rows[1].cells[2].getElementsByTagName('input')[0].value;
   var modepaiementajax = t.rows[1].cells[3].getElementsByTagName('input')[0].value;
   var statuspaiementajax = t.rows[1].cells[4].getElementsByTagName('input')[0].value;
   var modelivraisonajax = t.rows[1].cells[5].getElementsByTagName('input')[0].value;
   var statuslivraisonajax = t.rows[1].cells[6].getElementsByTagName('input')[0].value;
   try {
   var xhttp  = new XMLHttpRequest();
   xhttp.open("POST", "savemodifcommande", false);
   xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
   var params = "numcommandeajax="+numcommandeajax+"&montantajax="+montantajax+"&modepaiemenajax="+modepaiementajax+"&statuspaiementajax="+statuspaiementajax+"&modelivraisonajax="+modelivraisonajax+"&statuslivraisonajax="+statuslivraisonajax
   xhttp.send(params);
   alert("Modification Commande ok")
   } catch(err) {
	    alert(err.message);
   }     
   } 
</script>
<body>
 <form method="post" action="viewcommandetomodify">
<div>
<label for="numcommande">Num Commande : </label>
<input type="text" name="numcommande" id="numcommade" />
<br/>
<label for="numclient">Num Client :</label>
<input type="text" name="numclient" id="numclient" />
<br/>
<label for="datecommande">Date Commande :</label>
 <input type="date" id="datecommande" name="datecommande" min="2018-01-01" max="2023-12-31">         
<br/>
 <input type="submit" value="rechercher"/><span class="erreur"> ${erreurchoix} </span> 
 <br/>
 <span class="erreur"> ${noresult} </span>
 <span class="success"> ${nbresult} </span>
 <br/>
 </div>
 </form>
<div>

<table ID="tablescommande">
  <tr>
    <th>Num Commande </th>
    <th>Num Client</th>
    <th>Montant</th>
    <th>Mode De Paiement</th>
    <th>Status De Paiement</th>
    <th>Mode De Livraison</th>
    <th>Status De Livraison</th>
    <th>Date De Commande</th>
    <th>Action </th>
  </tr>
  

 <c:forEach var="commande" items="${ commandes }">
           <tr> 	
           <td id="nuc"> <b><c:out value="${commande.numcommande}" /> </b> </td>  
           <td> <b><c:out value="${commande.numclient}" /> </b> </td>
           <td> <input type="text"  style="width: 60%;" name="montantcommande"  value="<c:out value="${commande.montant}"/>"/> </td>
           <td> <input type="text"  style="width: 60%;" name="modepaiement" value="<c:out value="${commande.modePaiement}"/>"/></td>
           <td>  <input type="text"  style="width: 60%;" name="statupaiement" value="<c:out value="${commande.statutPaiement}" />"/> </td>
           <td> <input type="text"  style="width: 60%;" name="modelivraison" value="<c:out value="${commande.modeLivraison}" />"/></td>
           <td> <input type="text"  style="width: 60%;" name="statulivraison" value="<c:out value="${commande.statutLivraison}" />"/></td>
           <td> <c:out value="${commande.date}" /></td>
           <td><a href="" onclick="update_row()"> <img src="${pageContext.request.contextPath}/resources/images/save.ico"style="width: 20px;"alt="save"/> </a> </td>
           </tr>
        </c:forEach>
</table>
</div>
</body>
</html>
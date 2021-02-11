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
<body>
 <form method="post" action="getcmd">
<div>
<label for="numcommande">Num Commande :</label>
<input type="text" name="numcommande" id="numcommade" />
<br/>
<label for="numclient">Num Client :</label>
<input type="text" name="numclient" id="numclient" />
<br/>
<label for="datecommande">Date Commande :</label>
 <input type="date" id="datecommande" name="datecommande" min="2018-01-01" max="2023-12-31">         
<br/>
 <input type="submit" value="rechercher"/>  <span class="erreur"> ${erreurchoix} </span> 
 <br/>
 <span class="erreur"> ${noresult} </span>
 <span class="success"> ${nbresult} </span>
 <br/>
 </div>
 </form>
<div>

<table>
  <tr>
    <th>Num Commande </th>
    <th>Num Client</th>
    <th>Montant</th>
    <th>Mode De Paiement</th>
    <th>Status De Paiement</th>
    <th>Mode De Livraison</th>
    <th>Status De Livraison</th>
     <th>Date De Commande</th>
  </tr>
  

 <c:forEach var="commande" items="${ commandes }">
           <tr> 
           <td> <b><c:out value="${commande.numcommande}" /></b> </td>
           <td> <b><c:out value="${commande.numclient}" /> </b> </td>   
           <td> <b><c:out value="${commande.montant}" /></b></td>
           <td> <b><c:out value="${commande.modePaiement}" /></b></td>
           <td> <b><c:out value="${commande.statutPaiement}" /> </b></td>
           <td> <b><c:out value="${commande.modeLivraison}" /></b></td>
           <td> <b><c:out value="${commande.statutLivraison}" /></b></td>
           <td> <b><c:out value="${commande.date}" /></b></td>
           </tr>
        </c:forEach>
 
</table>
</div>
</body>
</html>
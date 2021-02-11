<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@include file="/resources/inc/stylecreatecommande.css" %>
</style>
<meta charset="utf-8" />
<title>Creation Commande</title>

</head>
<script>
function generateinvoice() {
try {
	   var nclient = document.getElementById("numclient").value;
	   var codep = document.getElementById("codeproduit").value;
	   var modep = document.getElementById("modePaiement").value;
	   var modliv = document.getElementById("modeLivraison").value;
	   var quant = document.getElementById("quantite").value;
	   
	   var xhttp  = new XMLHttpRequest();
	   xhttp.open("POST", "invoice", false);
	   xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	   var params = "numclientajax="+nclient+"&codeproduitajax="+codep+"&modepaiemenajax="+modep+"&modelivraisonajax="+modliv+"&quantiteajax="+quant;
	   xhttp.send(params);
	   alert("Generation facture ok")
	   } catch(err) {
		    alert(err.message);
	   }     
	    
 }
</script>

<body>
  
 <form method="post" action="createcommande">
<div>
<fieldset>
<legend>Creation nouvelle commande </legend>


<label for="numclient"> <b> client : </b> </label>

<select  name="numclient" id ="numclient">
  <option value=""></option>
  
  <c:forEach var="client" items="${ listeclient }">
    
<option value="${client.id}"> <c:out value="${client.id}--${client.email}"/> </option>  
 </c:forEach>
  </select> <span class="erreur">${erreurs['numclient']}</span>
<br />

 
<label for="codeproduit"><b>Code produit</b></label>
<select  name="codeproduit" id="codeproduit">
  <option value=""></option>
  
  <c:forEach var="produit" items="${ listeproduit }">
    
<option value="${produit.codeproduit}"> <c:out value="${produit.codeproduit}--${produit.libproduit}"/> </option>  
 </c:forEach>
  
</select>  <span class="erreur">${erreurs['codeproduit']}</span>
<br/>

<label for="quantite"> <b> Quantite : </b></label>
 <select  name="quantite" id ="quantite">
  <option value=""></option>
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
</select> 
<br />

<label for="modePaiement"> <b> Mode Paiement : </b></label>
<!--  <input type="text" name="modePaiement" id="modePaiement" /> -->
 <select  name="modePaiement" id ="modePaiement">
  <option value=""></option>
  <option value="cash">Cash</option>
  <option value="virement">Virement</option>
  <option value="cheque">Cheque</option>
</select>  <span class="erreur">${erreurs['modepaiement']}</span>
<br />

<label for="modeLivraison"><b>Mode Livraison</b></label>
<select  name="modeLivraison" id ="modeLivraison" >
  <option value=""></option>
  <option value="relais">Point relais</option>
  <option value="chronopost">Chronpost</option>
</select>  <span class="erreur">${erreurs['modelivraison']}</span>
<br/>
 <input type="submit" value="enregistrer"/>  <!--  <input type="button" value="facture" onclick="generateinvoice()"/>-->
 <br/>
 <p class="${empty erreurs ? 'succes' :'erreur'}">${resultat} <span class="erreur">${erreurs['quantitecheck']}</span>  <span class="erreur">${erreurs['reducequantite']}</span>  <span class="erreur">${erreurs['erreucreate']}</span></p> 
 </fieldset> 
 </div>  
</form>

</body>
</html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
  <%@include file="/resources/inc/stylecreatecommande.css" %>
</style>
<meta charset="utf-8" />
<title>Creation nouveau client</title>

</head>
<body>
  
 <form method="post" action="Servletcreateproduct">
<div>
<fieldset>
<legend> <h3> Creation Nouveau produit </h3></legend>
<label for="libproduit"> <b>libellé produit</b> </label>
<input type="text" name="libproduit" id="libproduit" /> <span class="erreur">${erreurs['lib']}</span>
<br/>
<label for="stock"> <b> Quantité intiale produit : </b> </label>
<input type="text" name="stock" id="stock" />  <span class="erreur">${erreurs['stock']}</span>
<br/>
 <label for="pua"> <b> Prix achat unitaire :</b> </label> 
 <input type="text" name="pua"/> <span class="erreur">${erreurs['pua']}</span>
 <br/>
 <label for="puv"> <b> Prix vente unitaire :</b> </label> 
 <input type="text" name="puv"/> <span class="erreur">${erreurs['puv']}</span>
 <br/>
 
 <label for="founisseur"> <b> Fournisseur :</b> </label> 
 <select  name="id">
  <option value=""></option>
  
  <c:forEach var="fournisseur" items="${ fournisseurs }">
    
<option value="${fournisseur.id}"> <c:out value="${fournisseur.id}--${fournisseur.nom}"/> </option>  
 </c:forEach>  
</select>  <span class="erreur"> ${erreurs['Fournisseur']}</span>  
 <!--  <input type="text" name="Fournisseur"/> <span class="erreur">${erreurs['Fournisseur']}</span>  -->
 <br/>
 
 <input type="submit" value="enregistrer"/>  <input type="reset" value="reset"/>
 <br/>
 <c:choose>
    <c:when test="${empty erreurs}">
        <span class="succes">${msg}</span>
    </c:when>
    <c:otherwise>
        <span class="erreur">${erreurs['msg']}</span>
    </c:otherwise>
    

</c:choose>
 
 
 </fieldset> 
 </div>  
 </form>
</body>
</html>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
</head>
<style type="text/css">
<%@include file="/resources/inc/stylecreatecommande.css" %>
</style>
<body>
 <form method="post" action="uploadcommande" enctype="multipart/form-data">
 <fieldset>
<legend><h3>Traitement de Masse Commande </h3></legend>
 <div>
 <label> Choisir le fichier </label>
 <input type="file" name="file"/> 
 <br/>
 <input type="submit" value="upload"/> <span class="erreur"> ${erreur} </span> <span class="success"> ${succes} </span>
 <br/>
 </div>
 </fieldset>
 </form>
</body>
</html>
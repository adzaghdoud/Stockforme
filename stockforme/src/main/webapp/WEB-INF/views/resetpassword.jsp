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

input[type=text] ,input[type=date], input[type=email],select ,input[type=password]  {
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

.erreur {
color: #900;
}
.succes {
color: #090;
}
</style>
<meta charset="utf-8" />
<title>Reset password</title>
<link type="text/css" rel="stylesheet" href="inc/style.css">
</head>
<script type="text/javascript">
   function refresh() {                         
        //Refresh page implementation here
        window.opener.location.reload();
       // window.close();
    }
</script>
<body>
  
 <form method="post" action="Servletresetpassword">
<div>
<fieldset>
<legend> <h3> Reset password </h3></legend>
<label for="login"> login </label>
<input type="text" name="login">  <span class="erreur">${confirmlogin}</span>
<br/>
 
 <label for="nvpassword"> Nouveau password </label>
<input type="password" placeholder="Entrer nouveau Password" name="nvpassword" required> 
<br/>

<label for="cnvpassword"> Confirmer Nouveau password </label>
<input type="password" placeholder="Confirmer nouveau Password" name="cnvpassword" required>  <span class="erreur">${confirmerror}</span>
<br/>

<input type="submit" value="enregistrer"/>  <input type="submit" value="reset"/>
 <br/>
 <c:choose>
    <c:when test="${empty erreurs}">
        <span class="succes">${confirmsave}</span>
    </c:when>
    <c:otherwise>
        <span class="erreur">${erreurs['resetpassword']}</span>
    </c:otherwise>
    

</c:choose>
 
 
 </fieldset> 
 </div>  
 </form>
</body>
</html>
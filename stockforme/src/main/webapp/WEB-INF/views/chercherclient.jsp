<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Chercher client</title>
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
.succes {
color: #090;
}

</style>
<body>
 <form method="post" action="Servletrecherche">
<div>
<label for="nom">Nom :</label>
<input type="text" name="nom" id="nom" />
<br/>
 <label for="email">Email :</label> 
 <input type="email" name="email"/>
 <br/>
 <input type="submit" value="rechercher"/>  <span class="erreur"> ${erreurchoix} </span> 
 <br/>
 </div>
 </form>
<div>

<table>
  <tr>
    <th>Id </th>
    <th>Nom</th>
    <th>Email</th>
    <th>Date souscription</th>
    <th>Adresse</th>
    <th>Num Tel</th>
  </tr>
  
 <c:forEach var="utilisateur" items="${ utilisateurs }">
           <tr> 
           <td> <b><c:out value="${utilisateur.id}" /> </b></td>	
           <td> <b><c:out value="${utilisateur.nom}" /> </b> </td>   
           <td> <b><c:out value="${utilisateur.email}" /></b></td>
           <td> <b><c:out value="${utilisateur.datesouscr}" /></b></td>
           </tr>
        </c:forEach>
 
</table>


</div>
</body>
</html>
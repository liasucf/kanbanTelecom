<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="style/theme1.css"/>  
 
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Tache</title>
</head>
<h1>Ajout d'une Tache</h1>
<body>
<form action="ajoutTache" method="post">
<c:if test="${not empty errorMessage}">
   <c:out value="${errorMessage}"/>
</c:if>
<table>
   <tr>                          
		<td><label for="Lnom">Projet:</label>
		<td><label for="projet" >${projet.id}</label><br>
	 </tr>
	 <tr> 
	<td><label for="Lcol">Colonne:</label>
	 <td><label >${colonne.nom}</label><br>
	 <input name="idcol" value="${colonne.id}" style="display:none">
	
	 <tr> 
	<td><label for="Ltype">Type de Tache:</label>
	<td>
	
	<select name="typeTache">
	 <c:forEach items="${typeTaches}" var="typeTache">
	  <option value="${typeTache.id}"> ${typeTache.nom} </option>
	</c:forEach>
	</select>
	 </tr>
	 <tr>
 	<td> <label for="Lintitulé:">Intitulé:</label> 
 	<td><textarea rows="4" cols="50" name="intitule"></textarea>
 	 </tr>
 	 
 	  <tr>
 	<td> <label for="Ldeveloppeurs">Developpeurs:</label>
 	 <td> 
 	 <select multiple class="form-control"  name="developpeur">
 	<c:forEach items="${developpeurs}" var="developpeur">
     <option value="${developpeur.id}" > ${developpeur.prenom} </option>
     </c:forEach>
      </select>
 	</tr>
 	 <tr>
 	<td> <label for="Lheures"> Nombre d'heures provisoires: </label> 
 	<td><input type="number" name="heures">
 	 
 	</tr>

 </table>
  <input type="submit" value="Ajouter">
</form>
</body>
</html>
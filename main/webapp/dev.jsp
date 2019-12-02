<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="style/theme1.css"/>  
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 
<meta charset="ISO-8859-1">

<title>List Developpeurs</title>
</head>
<body>
<a href="index" class="w3-button" style="float:right">Home</a>
<h1>List Developpeurs</h1>
<div class="w3-container">


<br>
<table class="w3-table-all w3-hoverable">
       <tr class="w3-light-grey">
            <td>Nom:</td>
            <td>Prenom:</td>
            <td>Email:</td>
            <td>Start Date:</td>
        </tr>
	    <c:forEach items="${pageDedeveloppeurs.content}" var="developpeur">
		    <tr>      
		        <td>${developpeur.nom}</td>
		        <td>${developpeur.prenom}</td>
		      	<td>${developpeur.email}</td>
		        <td>${developpeur.dateDebutContrat}</td>
		    </tr>
		</c:forEach>
    </table> 
<div class="w3-bar">
<c:if test="${!pageDedeveloppeurs.first}">
<a href="?page=0" class="w3-button">Primeire pag</a>
<a href="?page=${pageDedeveloppeurs.number-1}" class="w3-button">Pag precedente</a>
</c:if>

<a href="?page=${pageDedeveloppeurs.number+1}" class="w3-button">Pag suivante</a>
</div>
</div>
</body>
</html>
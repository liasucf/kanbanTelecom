<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="style/theme1.css"/>  
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> 
 
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
       		
            <td>Nom <a href="?sort=nom"><i class="fa fa-sort-up"></i></a> <a href="?sort=nom,desc"><i class="fa fa-sort-down"></i></a></td>
            <td>Prenom <a href="?sort=prenom"><i class="fa fa-sort-up"></i></a> <a href="?sort=prenom,desc"><i class="fa fa-sort-down"></i></a></td>
            <td>Email <a href="?sort=email"><i class="fa fa-sort-up"></i></a> <a href="?sort=email,desc"><i class="fa fa-sort-down"></i></a></td>
            <td>Date Debut Contrat<a href="?sort=dateDebutContrat"><i class="fa fa-sort-up"></i></a> <a href="?sort=dateDebutContrat,desc"><i class="fa fa-sort-down"></i></a></td>
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
<a href="?page=0" class="w3-button">Page 1</a>
<a href="?page=${pageDedeveloppeurs.number-1}" class="w3-button"><i class="fa fa-arrow-left"></i></a>
</c:if>
<c:if test="${pageDedeveloppeurs.hasNext()}">
<a href="?page=${pageDedeveloppeurs.number+1}" class="w3-button"><i class="fa fa-arrow-right"></i></a>
<a href="?page=${pageDedeveloppeurs.getTotalPages()- 1}" class="w3-button"><i class="fa fa-fast-forward"></i></a>
</c:if>
<p> Développeurs -- de ${pageDedeveloppeurs.content.size()} sur ${pageDedeveloppeurs.getTotalElements()} </p>
</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="style/theme1.css"/>  
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Tableau Kanban</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
<div  style="background-color: #f2f2f2; padding:15px"  >
<a href="developpeurs" class="w3-button" style="float:right" >Liste des developpeurs</a>
<h2>Tableau Kanban: Projet 1</h2>
</div>

<table id="all" >
<tr>
<c:forEach items="${colonnes}" var="colonne">
	
	<td><center style="margin:18px"><b >${colonne.nom}    <a href="tache?ID1=${colonne.id}" style="color:blue"><span >&#43;</span></a><b></center></td>         
</c:forEach>
</tr>
	
<c:if test="${taches.isEmpty() eq false}">
	<c:forEach items="${taches}" var="tache">
		
		<c:if test="${tache.colonneActuelle.id eq 1}">
	<tr class="line">
  		<td >
    		<div class="card" id="card${tache.typeTache.id}">
	        <span >${tache.intitule}</span><br>
	        <c:forEach items="${tache.developpeurs}" var="dev">
	        	<span>${dev.prenom} ${dev.nom}</span>,
	        </c:forEach>
	        <br>
	              <a href="moveCard?IDC=${tache.colonneActuelle.id +1}&IDT=${tache.id}">&gt</i></a>
	         </div>
	    </td>
	  </tr>
	   </c:if>	   
	   <c:if test="${tache.colonneActuelle.id eq 2}">
	<tr class="line">
		<td></td>
  		<td >
    		<div class="card" id="card${tache.typeTache.id}">
	        <span >${tache.intitule}</span><br>
	        <c:forEach items="${tache.developpeurs}" var="dev">
	        	<span>${dev.prenom} ${dev.nom}</span>,
	        </c:forEach>
	        <br>
	         <a href="moveCard?IDC=${tache.colonneActuelle.id - 1}&IDT=${tache.id}">&lt</i></a>    <a href="moveCard?IDC=${tache.colonneActuelle.id +1}&IDT=${tache.id}">&gt</a>
	      </div>
	    </td>
	  
	  </tr>
	   </c:if>	  
	   	   <c:if test="${tache.colonneActuelle.id eq 3}">
	<tr class="line">
		<td></td>
		<td></td>
  		<td >
    		<div class="card" id="card${tache.typeTache.id}">
	        <span >${tache.intitule}</span><br>
	        <c:forEach items="${tache.developpeurs}" var="dev">
	        	<span>${dev.prenom} ${dev.nom}</span>,
	        </c:forEach>
	        <br>
	         <a href="moveCard?IDC=${tache.colonneActuelle.id - 1}&IDT=${tache.id}">&lt</a>    <a href="moveCard?IDC=${tache.colonneActuelle.id +1}&IDT=${tache.id}">&gt</a>
	     	</div>
	    </td>	
	  	
	  </tr>
	   </c:if>	  
	   	   <c:if test="${tache.colonneActuelle.id eq 4}">
	<tr class="line">
		<td></td>
		<td></td>	
	  	<td></td>	
  		<td>
    		<div class="card" id="card${tache.typeTache.id}">
	        <span >${tache.intitule}</span><br>
	        <c:forEach items="${tache.developpeurs}" var="dev">
	        	<span>${dev.prenom} ${dev.nom}</span>,
	        	<br>
	        </c:forEach>
	        <br>
	         <a href="moveCard?IDC=${tache.colonneActuelle.id - 1}&IDT=${tache.id}">&lt</a>     
	      </div>
	    </td>
	  </tr>
	   </c:if>	   
	</c:forEach>
	 </c:if>

	
</table>
 
 <c:forEach items="${histories}" var="history">
 		<span>The tache ${history.tache.intitule} was moved to the colum ${history.colonne.nom} at ${history.date} </span>
 </c:forEach>
 

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="style/theme1.css"/>  
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  
 <script src="<c:url value="js/main.js" />"></script>
 
 
<meta charset="UTF-8">
<title>Tableau Kanban</title>
<script>
function allowDrop(ev) {
  ev.preventDefault();
}

function drag(ev) {
  ev.dataTransfer.setData("text", ev.target.id);
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  ev.target.appendChild(document.getElementById(data));
   
}
</script>
</head>
<body>
<div  style="background-color: #f2f2f2; padding:15px"  >
<a href="developpeurs" class="w3-button" style="float:right" >Liste des developpeurs</a>
<h2>Tableau Kanban: Projet 1</h2>
</div>
<div id="all">
<c:forEach items="${colonnes}" var="colonne">
	<div  id="div1" ondrop="drop(event)" ondragover="allowDrop(event)">
	<center style="margin-top:18px"><b >${colonne.nom}    <a href="tache?ID1=${colonne.id}" style="color:blue"><span >&#43;</span></a><b></center>
	
	<hr style="border-top: 2px solid white; margin:0px">	          
	
	<c:forEach items="${taches}" var="tache">
	<div id="block">
	
		<c:if test="${tache.getColonneActuelle() == colonne}">
	
		<div draggable="true" ondragstart="drag(event)" id="drag1" >	
	        <span >${tache.intitule}</span><br>
	        <span>${tache.getDeveloppeurs()}</span>
	        
	      </div>
	    
	    </c:if>
	    </div>	
	     <hr style="border-top: 2px solid white ; margin:0px">
	</c:forEach>
	

	</div>    
	</c:forEach>
</div>
 
  
  
  
  










<%-- <div class="w3-bar">

<c:if test="${!pageDeTaches.first}">
<a href="index?page=0" class="w3-button" >Primeire pag</a>
<a href="index?page=${pageDeTaches.number-1}" class="w3-button">Pag precedente</a>
</c:if>

<a href="index?page=${pageDeTaches.number+1}" class="w3-button">Pag suivante</a>

</div> --%>
<br>

</body>
</html>
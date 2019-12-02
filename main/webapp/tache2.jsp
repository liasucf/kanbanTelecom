<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST"
          action="addTache" modelAttribute="tache">
             <table>
                <tr>
                    <td><form:label path="projet">Projet</form:label></td>
                    <td><form:input path="projet"/></td>
                </tr>
                <tr>
                    <td><form:label path="colonne">Colonne:</form:label></td>
                    <td><form:input path="colonne"/></td>
                </tr>
                <tr>
                    <td><form:label path="typeTache: ">
                      Type de Tache: </form:label></td>
                    <td><form:input path="typeTache"/></td>
                </tr>
                 <tr>
                    <td><form:label path="intitule: ">
                      Intitulé: </form:label></td>
                    <td><form:input path="intitule"/></td>
                </tr>
                	   <tr>
                    <td><form:label path="developpeurs: ">
                      Developpeurs: </form:label></td>
                    <td><form:input path="developpeurs"/></td>
                </tr>
                <tr>
                    <td><form:label path="heuresProvisoires: ">
                      Nombre d'heures provisoires: </form:label></td>
                    <td><form:input path="heuresProvisoires"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
        
<c:forEach items="${Projet}" var="projet">

<li>${tache.} (${tache.dateCreation})</li>

  Projet: <output name="txtprojet">
  <c:forEach items="${Projet}" var="projet">
   ${projet.nom}
</c:forEach>
  </output><br>
  
  Colonne:<output name="txtcolonne" >
    <c:forEach items="${Colonnes}" var="colonne">
   ${colonne.nom}
</c:forEach>
  </output><br>
  
  </output><br>
  Type de Tache: 
  <select>
 <c:forEach items="${typeTaches}" var="typeTache">
   ${typeTache.nom}
</c:forEach>
</select>
  <br>
  Intitulé: <textarea rows="4" cols="50">
  
  </textarea>
  <br>
  Developpeurs: <input type="text" name="txtdev"><br>
  Nombre d'heures provisoires: 
  
  <% for(int i = 0; i < 5; i+=1) { %>
        <select>      
            <option><%= i %> </option>
        </select>
    <% } %>
 
  <br>
    </body>
</html>

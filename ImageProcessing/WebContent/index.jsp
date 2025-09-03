
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ page import="com.example.util.Util"%>
<%@ page import="com.example.vo.Filter"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Image Processing</title>
	<script type="text/javascript" src="resources/js/util.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css"/>
</head>

<body>

	<div id="divFilter">
		<label>Filter</label>
	  	<select id="filterId">
		  	<c:forEach items="<%=Util.getFiltersList()%>" var="filter">
				  <option value="${filter.id}">${filter.name}</option>
		  	</c:forEach>
	 		</select>
		<button onclick="filterImage();">Transform</button>
	</div>
	
	<c:if test="${!empty error}"><p class=error><c:out value="${error}"/></p></c:if>
	
 	<div id="divOriginalImage">
  		<img id="originalImage" src="${pageContext.request.contextPath}/resources/images/fruits.png"/>
  	</div>
  	
  	<div id="divFilteredImage">
  		<img id="filteredImage" src=""/>
  	</div>
  	
</body>
</html>

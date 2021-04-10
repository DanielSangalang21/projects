<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ include file="includeTag.jsp"%>
<%@ taglib prefix="rental" uri="/table" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<rental:table action="inquire" doer="soundEquipmentImplem" method="getEquipments"/>

	 <c:if test="${not empty daniel}"><h1>${daniel[0].brand}</h1></c:if>
	<h1>Daniel Sangalang!</h1>
	<h2 id="placeHolder"></h2>
	<p>Your name is: </p>
	<h2 id="name"></h2>
	<button id="button">Check Data</button>
	<button id="btn">Check Name</button> 

<%-- Server Version: <%= application.getServerInfo() %><br>
Servlet Version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>
JSP Version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> <br> --%>
</body>
</html>
<script type="text/javascript">
$("#button").click(function(){
	  $.ajax({
		  	type : "GET",
		    url : "${pageContext.request.contextPath}/equipment",
		    dataType: "json",
		    contentType: 'application/json',
		    //dataType:"json" , 
		    /* data : {
		        "id" : ${articleCount}
		    }, */
		    success: function(data){
			   // alert(data.brand);
		        $('#placeHolder').html(data.brand);
		    }
	  });
	  
	 });

$("#btn").click(function(){
	  $.ajax({
		  	type : "GET",
		    url : "name",
		    dataType: "text",
		    //dataType:"json" , 
		    /* data : {
		        "id" : ${articleCount}
		    }, */
		    success: function(data){
			    if (data % 2 === 0) $('#name').html(data + "even");
			    else $('#name').html(data + "odd");
		    }
	  });
	  
	 });
</script>
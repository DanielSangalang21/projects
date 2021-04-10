<%@include file="includeTag.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<form:form  method="post" commandName = "soundEquipmentBean" id="soundEquipmentBean" enctype="multipart/form-data">
<form:input path="brand" id="brand" />
<form:button type="button"  id="button">Submit</form:button>
<input type="file" name="pictureFile"/>
</form:form>

<c:if test="${not empty fileUploadedPath}">
<img alt="image not available" src="${fileUploadedPath}">
</c:if>
<img alt="image not available" src="C:\Users\Daniel\Documents\workspace-spring-tool-suite-4-4.8.0.RELEASE\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\rentalApplication\WEB-INF\uploads\IMG_20210216_162759.jpg">
</body>
</html>
<script type="text/javascript">
document.getElementById("button").onclick = function(){
    $("#soundEquipmentBean").submit();
}
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin Profile Page</title>
	</head>
<body>
	<h1>${msg}</h1> <br>
		
	<security:authorize access="isAuthenticated()">
      <a href="<%=request.getContextPath()%>/antiquedata/login?logout=true">Logout</a>
    </security:authorize>
</body>
</html>
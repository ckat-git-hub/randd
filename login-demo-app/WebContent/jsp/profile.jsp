<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Profile Page</title>
	</head>
	<body>
	<h1>Welcome ${role}</h1> <br>
	
	 <table>
        <tr>
            <td>
                NAME: ${role}
            </td>
</tr>
<tr>
            <td>
                RS.1000 FUNDED BY: ${role}
            </td>
            </tr>

            <security:authorize access="hasRole('ADMIN')">

              <tr>
                <td>
                    FUND ACCUMULATED : RS.2000
                </td>
</tr>
            </security:authorize>
        
    </table> <br><br>
	
	<security:authorize access="isAuthenticated()">
	  <a href="<%=request.getContextPath()%>/antiquedata/home">Home</a> <br><br>
      <a href="<%=request.getContextPath()%>/antiquedata/login?logout=true">Logout</a>
    </security:authorize> 
    
	</body>
</html>
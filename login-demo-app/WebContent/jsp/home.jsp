<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home Page</title>
</head>

<body>

    <h1>Home Page</h1>

    <table>
        <tr>
            <td>
                <a href="#">CREATE</a>
            </td>

            <td>
                <a href="#">READ</a>
            </td>

            <security:authorize access="hasRole('ADMIN')">

                <td>
                    <a href="#">UPDATE</a>
                </td>

                <td>
                    <a href="#">DELETE</a>
                </td>

            </security:authorize>

        </tr>
    </table> <br><br>

    Admin or User: <a href="<%=request.getContextPath()%>/antiquedata/user/profile">Go to User Profile</a>  <br><br>

    
    Only Admin ( 403 Error for User ): <a href="<%=request.getContextPath()%>/antiquedata/admin/profile">Go to Admin Profile</a>  <br><br>

    <security:authorize access="isAuthenticated()">
        <a href="<%=request.getContextPath()%>/antiquedata/login?logout=true">Logout</a>
    </security:authorize>

</body>

</html>
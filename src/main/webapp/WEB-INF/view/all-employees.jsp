<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>all-employees</title>
</head>
<body>

<h2>All Employees</h2>
<br>
<br>

<table>
         <%-- строка таблицы <tr>--%>
    <tr>
        <%-- шапка таблицы <th>--%>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>
             <%-- var - временная переменная, items - наш список --%>
    <c:forEach var="emp" items="${allEmps}">
        <tr>
                <%-- ячейка в таблице <td>--%>
            <td>${emp.name}</td>
            <td>${emp.surName}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
        </tr>
    </c:forEach>

</table>
<br>

<input type="button" value="Add" onclick="window.location.href = 'addNewEmployee'"/>



</body>
</html>

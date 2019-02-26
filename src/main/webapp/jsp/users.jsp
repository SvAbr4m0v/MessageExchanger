<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <table>
        <c:forEach items ="${usersFromDb}" var = "user">
            <tr>
                <td>
                    ${user}
                </td>
            </tr>
        </c:forEach>
    </table>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,br.edu.insper.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista</title>
</head>
<body>
<h1>Sua lista de tarefas de hoje:</h1>
<h3>Não esqueça de realizar todas até o final de hoje!!!!!</h3>
<table border='1'>

<c:forEach var="pessoas" items="${pessoas}"> 

<tr>
<td> ${pessoas.task} </td>

<td>
<form action='remove' method='post'>
<input type='hidden' name='id' value='${pessoas.id}'>
<input type='submit' value='remover'>

</form>
<form action='atualiza' method='get'>
<input type='hidden' name='id' value='${pessoas.id}'>
<input type='hidden' name='nome' value='${pessoas.task}'>
<input type='submit' value='atualizar'>

</form>
</td>
</tr>

</c:forEach>

</table>
</body>
</html>
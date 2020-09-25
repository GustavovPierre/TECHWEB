<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualiza</title>
</head>
<body>
<h1>Atualize a tarefa desejada:</h1>
<form action='atualiza' method='post'>
Task: <input type='text' name='task' value='${param.task}'><br>
<input type='hidden' name='id' value='${param.id}'>
<input type='submit' value='atualizar'>
</form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 03/06/2022
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <title>Cadastro de produtos</title>
</head>
<body>
<h1>Editar produto</h1>
<form name ="frmProduto" action="update">
    <table>
        <tr>
            <td><input type="text" name="id" id="caixa2" readonly value="<%out.print(request.getAttribute("id"));%>"></td>
        </tr>
        <tr>
            <td><input type="text" name="codigo" class="caixa1" value="<%out.print(request.getAttribute("codigo"));%>"></td>
        </tr>
        <tr>
            <td><input type="text" name="nome"  class="caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
        </tr>
        <tr>
        <td><input type="text" name="categoria" class="caixa1" value="<%out.print(request.getAttribute("categoria"));%>"></td>
        </tr>
        <tr>
            <td><input type="text" name="valor" class="caixa1" value="<%out.print(request.getAttribute("valor"));%>"></td>
        </tr>
        <tr>
            <td><input type="text" name="quantidade" class="caixa1" value="<%out.print(request.getAttribute("quantidade"));%>"></td>
        </tr>
    </table>
    <input type="button" value="Cadastrar" class="botao1" onclick="validar()">
</form>
<script src="scripts/validador.js"></script>
</body>
</html>

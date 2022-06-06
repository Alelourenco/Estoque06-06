<%--
  Created by IntelliJ IDEA.
  User: alexa
  Date: 01/06/2022
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList"%>
<%
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<html lang="pt-br">
<head>
<link rel="stylesheet" href="style.css">
<meta charset="utf-8">
    <title>Produto</title>
</head>
<body>
    <h1>Produto</h1>
    <a href= "novo.html" class="botao1">Novo Produto</a>
    <table id="tabela">
        <thead>
            <tr>
                <th>Id</th>
                <th>Codigo</th>
                <th>Nome</th>
                <th>Categoria</th>
                <th>Valor</th>
                <th>Quantidade</th>
                <th>Opções</th>
            </tr>
        </thead>
        <tbody>
            <%for (int i = 0; i <lista.size(); i++) { %>
                <tr>
                    <td><%=lista.get(i).getId()%></td>
                    <td><%=lista.get(i).getCodigo()%></td>
                    <td><%=lista.get(i).getNome()%></td>
                    <td><%=lista.get(i).getCategoria()%></td>
                    <td><%=lista.get(i).getValor()%></td>
                    <td><%=lista.get(i).getQuantidade()%></td>
                    <td><a href="select?id=<%=lista.get(i).getId()%>"
                           class="botao1">Editar</a>
                        <a href="javascript: confirmar(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
                    </td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <script src="scripts/confirmador.js"></script>
</body>
</html>

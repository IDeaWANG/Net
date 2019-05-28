<%--
  Created by IntelliJ IDEA.
  User: wangbowangbo
  Date: 2019/5/20
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="product.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>

<body class="container mt-3">
<form  action="productionServlet?action=findbyname"  method="POST" target="_blank">
<div class="card boder-success"></div>
<div class="card-header bg-success">
    <button class="btn btn-danger float-right" style="color: aqua"><a href="productAdd.jsp">添加产品</a></button>
    <form action="productionServlet">
        <input type="text" name="name" value="" />
        <input type="submit" class="btn btn-danger float-left " value="查找"/>
    </form>
</div>

<jsp:useBean id="productDao" class="product.dao.ProductDao" scope="application"></jsp:useBean>
<table class="table table-condensed">
    <tr>
        <td>ID</td>
        <td>名称</td>
        <td>单价</td>
        <td>生产日期</td>
        <td>操作</td>
    </tr>
        <%
    List<Product> product = (List<Product>)request.getAttribute("products");
    for (Product p:product) {
        int id = p.getId();
        String name = p.getName();
        Float price = p.getPrices();
        Date date = p.getDate();
    %>
    <div>
        <tr>
            <td><%=id%>
            </td>
            <td><%=name%>
            </td>
            <td><%=price%>
            </td>
            <td><%=date%>
            </td>
            <td><a href="productEdit.jsp?action=Update&id=<%=id%>&name=<%=name%>&price=<%=price%>&date=<%=date%>"
                   role="button">修改/</a>
                <a href="productionServlet?action=delete&id=<%=id%>&name=<%=name%>&price=<%=price%>&date=<%=date%>"
                   role="button">删除</a>
            </td>
        </tr>
    </div>
        <%
    }
%>
</body>
</html>

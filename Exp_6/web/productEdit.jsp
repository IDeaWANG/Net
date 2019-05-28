<%--
  Created by IntelliJ IDEA.
  User: wangbowangbo
  Date: 2019/5/20
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>产品编辑()</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>

<jsp:useBean id="productDao" class="product.dao.ProductDao" scope="application"></jsp:useBean>
<body class="container mt-3">
<input type="hidden" name="isSubmit" value="whatever"/>
<div class="card border-primary">
    <div class="card-header bg-primary">修改产品</div>
    <div class="card-body">
        <div class="form-group">
            <label>名称</label>
            <input type="text" class="form-control" name="name" value="<%=request.getParameter("name")%>"/>
        </div>
        <div class="form-group">
            <label>单价</label>
            <input class="form-control" name="price" value="<%=request.getParameter("price")%>"/>
        </div>
        <div class="form-group">
            <label>生产日期</label>
            <input class="form-control" name="date"value="<%=request.getParameter("date")%>"/>
        </div>
    </div>
    <div class="card-footer">
        <%--<input type="submit" class="btn btn-primary float-right" value="修改"/>--%>
        <a href="productionServlet?action=Update" class="btn btn-primary float-right" role="button">修改</a>
    </div>
</div>
</body>
</body>
</html>

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
    <title>产品增加！！</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>

<body class="container mt-3">
<form  action="productionServlet"  method="POST" target="_blank">
    <div class="card border-primary">
        <div class="card-header bg-primary">添加产品</div>
        <div class="card-body">
            <div class="form-group">
                <label>名称</label>
                <input type="text" class="form-control" name="name" value=""/>
            </div>
            <div class="form-group">
                <label>单价</label>
                <input type="text" class="form-control" name="price" value=""/>
            </div>
            <div class="form-group">
                <label>生产日期</label>
                <input type="text" class="form-control" name="date" value=""/>
            </div>
            <div class="form-group">
                <%--<label>生产日期</label>--%>
                <input  type="text" class="form-control" name="action" value="add"/>
            </div>
        </div>
        <div class="card-footer">
            <input type="submit" class="btn btn-primary float-right" value="添加"/>
            <%--<a href="productionServlet?action=add&price=<%=request.getParameter("price")%>&name=<%=request.getParameter("name")%>&date=<%=request.getParameter("date")%>"  class="btn btn-primary float-right" role="button">添加</a>--%>
        </div>
    </div>
<%--</form>--%>
</body>
</html>

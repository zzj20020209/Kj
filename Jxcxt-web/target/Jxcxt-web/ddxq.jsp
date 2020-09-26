<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/4
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单商品详情</title>
</head>
<body>
<table id="ddspxq"></table>
<script type="text/javascript">
    $(function () {
        var id = $("#cgdb").datagrid("getSelected").cgddid;
        var param = {
            url: 'ddbcx',
            queryParams: {"cgddid": id},
            columns: [[
                {field: 'ck', title: '全选', checkbox: true, width: 100},
                {field: 'ddid', title: '订单ID', width: 100},
                {field: 'spname', title: '商品', width: 100},
                {field: 'spjg', title: '商品价格', width: 100},
                {field: 'spsl', title: '商品数量', width: 100}
            ]],
            fitColumns: true,
            striped: true,   //是否显示斑马线效果
            pagination: true,  //则在DataGrid控件底部显示分页工具栏。
            rownumbers: true,   //如果为true，则显示一个行号列。
        };

        $("#ddspxq").datagrid(param);
    })
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/5
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退货单</title>
</head>
<body>
    <table id="thd"></table>
    <script type="text/javascript">
        $(function () {
            var param = {
                url: 'thcxsy',
                columns: [[
                    {field: 'ck', title: '全选', checkbox: true, width: 100},
                    {field: 'cgddid', title: '采购订单ID', width: 100},
                    {field: 'yname', title: '采购员', width: 100},
                    {field: 'cgsj', title: '采购订单生成时间', width: 100},
                    {field: 'zjg', title: '商品总价格', width: 100}
                ]],
                fitColumns: true,
                striped: true,   //是否显示斑马线效果
                pagination: true,  //则在DataGrid控件底部显示分页工具栏。
                rownumbers: true,   //如果为true，则显示一个行号列。
            };

            $("#thd").datagrid(param);
        })
    </script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/6
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>库存查询</title>
</head>
<body>
商品名字：<input type="text" name="spname" id="kcspname">
    <a id="ckcsp" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
    <br>
<table id="ckc"></table>

<script type="text/javascript">
    var param ={
        url:'kcrlcxfy',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'kcname',title:'仓库名字',width:100},
            {field:'spname',title: '商品名字',width: 100},
            {field:'sl',title: '拥有数量',width: 100}
        ]],
        fitColumns:true,
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        singleSelect:true,
        pageSize:5,//在设置分页属性的时候初始化页面大小初始化页面大小选择列表。
        pageList:[5,10,15,20,25]////如果为true，则只允许选择一行。
    };

    $("#ckc").datagrid(param);

    //条件查询
    $("#ckcsp").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        /*var aa=$("#splx").combobox('getData','none');*/
        /*alert(aa[0].id);*/

        $("#ckc").datagrid('load',{spname:$("#kcspname").val()/*,splx:$("#splx").val()*/});
    });
</script>
</body>
</html>

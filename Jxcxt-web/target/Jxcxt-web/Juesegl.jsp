<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/2
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色管理</title>
</head>
<body>
员工姓名：<input type="text" name="yname" id="yname">
<a id="cx" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>
<div id="jstbuser">
    <a id="btnjsadd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">编辑员工角色</a>
</div>

<table id="dgvlj"></table>

<!-- 添加窗口-->
<div id="jsaddwin" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Jsadd.jsp',closed:true">
</div>

<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'cxsl',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'id',title:'编号',width:100},
            {field:'yname',title:'员工名字',width:100}
        ]],
        fitColumns:true,
        toolbar:'#jstbuser',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        singleSelect:true,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15,20,25]   //初始化页面大小选择列表。
    };

    $("#dgvlj").datagrid(param);
    $("#cx").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        $("#dgvlj").datagrid('load',{yname:$("#yname").val()});
    });

    $("#btnjsadd").click(function () {

        var aar=$("#dgvlj").datagrid("getSelections");
        if(aar.length==1){
            $("#jsaddwin").window("open");
            $("#jsaddwin").window("refresh");
        }else {
            alert("有且只能选择一条数据")
        }
    });
</script>
</body>
</html>

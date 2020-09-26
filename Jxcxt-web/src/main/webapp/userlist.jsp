<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/18
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
</head>
<body>

姓名：<input type="text" name="yname" id="yname">
性别:<select id="sex" name="sex" style="width: 100px">
    <option value="">全部</option>
    <option value="男">男</option>
    <option value="女">女</option>
</select>
<a id="btnsearchuser" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>

<div id="tbuser">
    <a id="btnadduser" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btnedituser" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btndeluser" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">解雇</a>
</div>

<table id="dgvuser"></table>

<!-- 添加窗口-->
<div id="addwin" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'userAdd.jsp',closed:true">
</div>

<!-- 编辑窗口-->
<div id="editwin" class="easyui-window" title="编辑" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'userEdit.jsp',closed:true">
</div>

<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'cxsl',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'yid',title:'编号',width:100},
            {field:'yname',title:'名字',width:100},
            {field: 'password',title: '密码',width: 100},
            {field: 'sfz',title: '身份证',width: 100},
            {field: 'sex',title: '性别',width: 100},
            {field: 'telephone',title: '手机号',width: 100},
            {field: 'mailbox',title: '邮箱',width: 100},
            {field: 'ygdz',title: '员工地址',width: 100}
        ]],
        fitColumns:true,
        toolbar:'#tbuser',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        singleSelect:true,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15,20,25]   //初始化页面大小选择列表。
    };

    $("#dgvuser").datagrid(param);

    //条件查询
    $("#btnsearchuser").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        $("#dgvuser").datagrid('load',{yname:$("#yname").val(),sex:$("#sex").val()});
    });

    //删除按钮  绑定事件
    $("#btndeluser").click(function () {

        //获取所有选中行的记录数组
        var selrows = $("#dgvuser").datagrid("getSelections");
        /*alert(selrows[0].spid)*/
        if (selrows.length == 0) {
            $.messager.alert('消息', '请选择一条记录！', 'info');
            return;
        }
        $.messager.confirm('确认对话框', '您确认解雇该人员吗 ？', function (r) {
            if (r) {
                //获取当前选中的记录的id
                var ids = "";
                for (var i = 0; i < selrows.length; i++) {
                    ids += selrows[i].yid + ",";
                }
                $.get("ygsc", {"ids": ids}, function (data) {
                    //弹出结果消息
                    $.messager.show({
                        title: '消息',
                        msg: data.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });

                    //刷新表格数据
                    $("#dgvuser").datagrid('load', {yname: $("#yname").val()});
                }, "json");
            }
        });
    });

    $("#btnadduser").click(function () {
        $("#addwin").window("open");
    });

    $("#btnedituser").click(function () {

        var aar=$("#dgvuser").datagrid("getSelections");
        if(aar.length==1){
            $("#editwin").window("open");
            $("#editwin").window("refresh");
        }else {
            alert("有且只能选择一条数据")
        }
    });
</script>
</body>
</html>

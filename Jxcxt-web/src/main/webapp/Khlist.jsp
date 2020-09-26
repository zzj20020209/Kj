<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/25
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
客户名字：<input type="text" name="khname" id="khname"></select>
<a id="btnkhcx" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>

<div id="khtbuser">
    <a id="btnkhadd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btnkhxg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btnkhsc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>

<table id="dgvkh"></table>

<!-- 添加窗口-->
<div id="khaddwin" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Khadd.jsp',closed:true">
</div>

<!-- 编辑窗口-->
<div id="kheditwin" class="easyui-window" title="编辑" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Khxg.jsp',closed:true">
</div>

<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'khcxfy',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'khid',title:'客户ID',width:100},
            {field:'khname',title: '客户名字',width: 100},
            {field:'khyx',title:'客户邮箱',width:100},
            {field: 'khgsdz',title: '客户公司地址',width: 100},
            {field: 'khgsdh',title: '客户公司电话',width: 100},
            {field: 'lxr',title: '联系人',width: 100},
            {field: 'lxrdh',title: '联系人电话',width: 100}
        ]],
        fitColumns:true,
        toolbar:'#khtbuser',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        //singleSelect:true,
        pageSize:5,//在设置分页属性的时候初始化页面大小初始化页面大小选择列表。
        pageList:[5,10,15,20,25]////如果为true，则只允许选择一行。
    };

    $("#dgvkh").datagrid(param);

    //条件查询
    $("#btnkhcx").click(function () {
        $("#dgvkh").datagrid('load',{khname:$("#khname").val()/*,splx:$("#splx").val()*/});
    });

    //删除按钮  绑定事件
    $("#btnkhsc").click(function () {

        //获取所有选中行的记录数组
        var selrows = $("#dgvkh").datagrid("getSelections");
        /*alert(selrows[0].spid)*/
        if (selrows.length == 0) {
            $.messager.alert('消息', '请选择一条记录！', 'info');
            return;
        }
        $.messager.confirm('确认对话框', '您确认删除这些记录吗？', function (r) {
            if (r) {

                //获取当前选中的记录的id
                var ids = "";
                for (var i = 0; i < selrows.length; i++) {
                    ids += selrows[i].khid + ",";
                }
                $.get("khsc", {"ids": ids}, function (data) {
                    //弹出结果消息
                    $.messager.show({
                        title: '消息',
                        msg: data.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });

                    //刷新表格数据
                    $("#dgvkh").datagrid('load', {khname: $("#khname").val()/*,splx:$("#splx").val()*/});
                }, "json");
            }
        });
    });

    //添加按钮  绑定事件  打开添加窗口
    $("#btnkhadd").click(function () {
        $("#khaddwin").window("open");
    });

    $("#btnkhxg").click(function () {
        var aar=$("#dgvkh").datagrid("getSelections");
        if(aar.length==1){
            $("#kheditwin").window("refresh")
            $("#kheditwin").window("open")
        }else {
            alert("有且只能选择一条数据")
        }
    })
</script>
</body>
</html>

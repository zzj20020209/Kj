<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/20
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>仓库</title>
</head>
<body>
仓库名字：<input type="text" name="kcname" id="kcname">
<a id="btnkccx" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>

<div id="kctbuser">
    <a id="btnkcadd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btnkcxg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btnkcsc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>

<table id="dgvkc"></table>

<!-- 添加窗口-->
<div id="kcaddwin" class="easyui-window" title="添加" style="width:200px;height:150px"
     data-options="iconCls:'icon-add',modal:true,href:'kcadd.jsp',closed:true">
</div>

<!-- 编辑窗口-->
<div id="kceditwin" class="easyui-window" title="编辑" style="width:200px;height:150px"
     data-options="iconCls:'icon-add',modal:true,href:'Kcxg.jsp',closed:true">
</div>

<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'kccxfy',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'kid',title:'仓库ID',width:100},
            {field:'kcname',title: '仓库名字',width: 100},
        ]],
        fitColumns:true,
        toolbar:'#kctbuser',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        //singleSelect:true,
        pageSize:5,//在设置分页属性的时候初始化页面大小初始化页面大小选择列表。
        pageList:[5,10,15,20,25]////如果为true，则只允许选择一行。
    };

    $("#dgvkc").datagrid(param);

    //条件查询
    $("#btnkccx").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        /*var aa=$("#splx").combobox('getData','none');*/
        /*alert(aa[0].id);*/

        $("#dgvkc").datagrid('load',{kcname:$("#kcname").val()/*,splx:$("#splx").val()*/});
    });

    //删除按钮  绑定事件
    $("#btnkcsc").click(function () {

        //获取所有选中行的记录数组
        var selrows = $("#dgvkc").datagrid("getSelections");
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
                    ids += selrows[i].kid + ",";
                }
                $.get("kcsc", {"ids": ids}, function (data) {
                    //弹出结果消息
                    $.messager.show({
                        title: '消息',
                        msg: data.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });

                    //刷新表格数据
                    $("#dgvkc").datagrid('load', {kcname: $("#kcname").val()/*,splx:$("#splx").val()*/});
                }, "json");
            }
        });
    });

    //添加按钮  绑定事件  打开添加窗口
    $("#btnkcadd").click(function () {
        $("#kcaddwin").window("open");
    });
</script>
</body>
</html>

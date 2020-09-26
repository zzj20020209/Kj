<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/27
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>业务员资料</title>
</head>
<body>
业务员名字：<input type="text" name="ywyname" id="ywyname"></select>
<a id="btnywycx" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>

<div id="ywytbuser">
    <a id="btnywyadd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btnywyxg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btnywysc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>

<table id="dgvywy"></table>

<!-- 添加窗口-->
<div id="ywyaddwin" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Ywyadd.jsp',closed:true">
</div>

<!-- 编辑窗口-->
<div id="ywyeditwin" class="easyui-window" title="编辑" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Ywyxg.jsp',closed:true">
</div>

<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'ywycxfy',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'ywyid',title:'业务员ID',width:100},
            {field:'ywyname',title: '业务员名字',width: 100},
            {field:'ywyage',title: '业务员年龄',width: 100},
            {field:'ywysex',title:'业务员性别',width:100}
        ]],
        fitColumns:true,
        toolbar:'#ywytbuser',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        //singleSelect:true,
        pageSize:5,//在设置分页属性的时候初始化页面大小初始化页面大小选择列表。
        pageList:[5,10,15,20,25]////如果为true，则只允许选择一行。
    };

    $("#dgvywy").datagrid(param);

    //条件查询
    $("#btnywycx").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        /*var aa=$("#splx").combobox('getData','none');*/
        /*alert(aa[0].id);*/

        $("#dgvywy").datagrid('load',{ywyname:$("#ywyname").val()});
    });

    //删除按钮  绑定事件
    $("#btnywysc").click(function () {

        //获取所有选中行的记录数组
        var selrows = $("#dgvywy").datagrid("getSelections");
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
                    ids += selrows[i].ywyid + ",";
                }
                $.get("ywysc", {"ids": ids}, function (data) {
                    //弹出结果消息
                    $.messager.show({
                        title: '消息',
                        msg: data.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });

                    //刷新表格数据
                    $("#dgvywy").datagrid('load', {ywyname: $("#ywyname").val()/*,splx:$("#splx").val()*/});
                }, "json");
            }
        });
    });

    //添加按钮  绑定事件  打开添加窗口
    $("#btnywyadd").click(function () {
        $("#ywyaddwin").window("open");
    });
</script>
</body>
</html>

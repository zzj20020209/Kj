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
    <title>商品</title>
</head>
<body>
商品名字：<input type="text" name="spname" id="spname">商品类型:<select id="zsplx" name="splx" style="width: 150px"></select>
<a id="btnspcx" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>

<div id="sptbuser">
    <a id="btnspadd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btnspxg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btnspsc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>

<table id="dgvsp"></table>

<!-- 添加窗口-->
<div id="spaddwin" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Spadd.jsp',closed:true">
</div>

<!-- 编辑窗口-->
<div id="speditwin" class="easyui-window" title="编辑" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Spxg.jsp',closed:true">
</div>

<script type="text/javascript">
    $("#zsplx").combobox({
        url:'wsplx',
        valueField:'id',
        textField:'text',
        onLoadSuccess:function (data) {
            $("#zsplx").combobox("select",data[0].id);
        }
    //     onselect:function (record) {
    //         pdrr=record.id;
    // }
    })
    //页面加载完成  初始化表格数据
    var param ={
        url:'spcxsl',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'spid',title:'商品ID',width:100},
            {field:'spname',title: '商品名字',width: 100},
            {field:'text',title: '商品类型',width: 100},
            {field:'spscph',title: '生产批号',width: 100},
            {field:'spms',title: '商品描述',width: 100}
        ]],
        fitColumns:true,
        toolbar:'#sptbuser',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        //singleSelect:true,
        pageSize:5,//在设置分页属性的时候初始化页面大小初始化页面大小选择列表。
        pageList:[5,10,15,20,25]////如果为true，则只允许选择一行。
    };

    $("#dgvsp").datagrid(param);



    //条件查询
    $("#btnspcx").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        /*var aa=$("#splx").combobox('getData','none');*/
        /*alert(aa[0].id);*/
        $("#dgvsp").datagrid('load',{spname:$("#spname").val(),splx:$("#zsplx").combobox("getValue")});
    });

    //删除按钮  绑定事件
    $("#btnspsc").click(function () {

        //获取所有选中行的记录数组
        var selrows = $("#dgvsp").datagrid("getSelections");
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
                    ids += selrows[i].spid + ",";
                }
                $.get("spsc", {"ids": ids}, function (data) {
                    //弹出结果消息
                    $.messager.show({
                        title: '消息',
                        msg: data.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });

                    //刷新表格数据
                    $("#dgvsp").datagrid('load', {spname: $("#spname").val(),splx:$("#zsplx").combobox("getValue")});
                }, "json");
            }
        });
    });

    //添加按钮  绑定事件  打开添加窗口
    $("#btnspadd").click(function () {
        $("#spaddwin").window("open");
    });
    $("#btnspxg").click(function () {

        var aar=$("#dgvsp").datagrid("getSelections");
        if(aar.length==1){
            $("#speditwin").window("open");
            $("#speditwin").window("refresh");
        }else {
            alert("有且只能选择一条数据")
        }
    });
</script>
</body>
</html>

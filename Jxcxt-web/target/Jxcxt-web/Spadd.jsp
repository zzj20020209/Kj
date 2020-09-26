<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/21
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
</head>
<body>
<form id="addspform" method="post">
    <table id="spadd" align="center">
        <tr><td>商品名称：</td><td><input id="spnameadd" name="spname" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]'" /></td></tr>
        <tr><td>商品供应商：</td><td><select name="gid" id="gnames" class="easyui-combobox" style="width: 200px"></select></td></tr>
        <tr><td>商品类型：</td><td><select name="splx" id="texts" class="easyui-combobox" style="width: 150px"></select></td></tr>
        <tr><td>商品生产批号:</td><td><input type="text" name="spscph" id="spscphs" class="easyui-validatebox" data-options="required:true,validType:'length[13,13]'"></td></tr>
        <tr><td>商品描述:</td><td><input type="text" id="spmss" name="spms" required="required"></td></tr>
        <tr><td>商品价格:</td><td><input id="prices" name="price" class="easyui-numberspinner" style="width:80px;" required="required" data-options="min:1,max:9999999999"></td></tr>
        <tr><td><a id="btnaddsp_add" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a></td></tr>
    </table>
</form>

<script type="text/javascript">
    $("#gnames").combobox({
        url:'spcd',
        valueField:'gid',
        textField:'gname',
        onLoadSuccess:function(){
            $("#gnames").combobox("select",1)
        }
    })
    $("#texts").combobox({
        url:'splx',
        valueField:'id',
        textField:'text',
        onLoadSuccess:function(){
            $("#texts").combobox("select",1)
        }
    })
    $("#btnaddsp_add").click(function () {
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $('#addspform').form('submit', {
            url:"spadd",
            onSubmit: function(){
                return $(this).form("validate");
            },
            success:function(data){
                //弹出消息
                $.messager.show({
                    title:'我的消息',
                    msg:data,
                    timeout:5000,
                    showType:'slide'
                });
                //关闭当前添加窗口
                $("#spaddwin").window("close");
                //刷新后台表格数据
                $("#dgvsp").datagrid('load',{spname:$("#spname").val(),splx:$("#zsplx").combobox("getValue")});
            }
        });
    });
</script>
</body>
</html>

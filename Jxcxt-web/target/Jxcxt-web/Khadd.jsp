<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/6
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户增加</title>
</head>
<body>
<form id="addkh" method="post">
    <table id="khzj" align="center">
        <tr><td>客户名字：</td><td><input id="khnameadd" name="khname" class="easyui-validatebox" data-options="required:true,validType:'length[2,5]'" /></td></tr>
        <tr><td>客户邮箱：</td><td><input name="khyx" id="khyxadd" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>客户公司地址：</td><td><input name="khgsdz" id="khgsdzadd" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>客户公司电话:</td><td><input type="text" name="khgsdh" id="khgsdhadd" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'"></td></tr>
        <tr><td>联系人:</td><td><input type="text" id="lxradd" name="lxr" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>联系人电话:</td><td><input id="lxrdhadd" name="lxrdh" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'"></td></tr>
        <tr><td><a id="khtj" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a></td></tr>
    </table>
</form>
<script type="text/javascript">
    $("#khtj").click(function () {
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $('#addkh').form('submit', {
            url:"khadd",
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
                $("#khaddwin").window("close");
                //刷新后台表格数据
                $("#dgvkh").datagrid('load',{khname: $("#khname").val()});
            }
        });
    });
</script>
</body>
</html>

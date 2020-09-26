<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/18
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工添加页面</title>
</head>
<body>
<<form id="adduserform" method="post">
    <table id="useradd" align="center">
        <tr><td>员工姓名：</td><td><input type="text" id="ynameadd" name="yname" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>密码：</td><td><input name="password" id="passwordadd" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>身份证:</td><td><input type="text" name="sfz" id="sfzadd" class="easyui-validatebox" data-options="required:true,validType:'length[16,18]'"></td></tr>
        <tr><td>性别:</td><td>男<input type="radio" id="nanadd" value="男" name="sex" checked="checked">女<input type="radio" id="nvadd" name="sex" value="女"></td></tr>
        <tr><td>电话:</td><td><input id="telephoneadd" name="telephone" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'"></td></tr>
        <tr><td>邮箱：</td><td><input name="mailbox" id="mailboxadd" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>住址：</td><td><input name="ygdz" id="ygdzadd" class="easyui-validatebox" required="required"></td></tr>
        <tr><td><a id="btnadduser_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a></td></tr>
    </table>
</form>
<script type="text/javascript">

    $("#btnadduser_add").click(function () {
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $('#adduserform').form('submit', {
            url:"add",
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
                $("#addwin").window("close");
                //刷新后台表格数据
                $("#dgvuser").datagrid('load',{yname:$("#yname").val()});
            }
        });
    });
</script>
</body>
</html>

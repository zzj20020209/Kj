<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/7
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户修改</title>
</head>
<body>
<form id="khxg" method="post">
    <table id="xgkh" align="center">
        <tr><td>客户ID：</td><td><input id="khidxg" name="khid" readonly="readonly"/></td></tr>
        <tr><td>客户名字：</td><td><input id="khnamexg" name="khname" class="easyui-validatebox" data-options="required:true,validType:'length[2,5]'" /></td></tr>
        <tr><td>客户邮箱：</td><td><input name="khyx" id="khyxxg" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>客户公司地址：</td><td><input name="khgsdz" id="khgsdzxg" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>客户公司电话:</td><td><input type="text" name="khgsdh" id="khgsdhxg" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'"></td></tr>
        <tr><td>联系人:</td><td><input type="text" id="lxrxg" name="lxr" class="easyui-validatebox" required="required"></td></tr>
        <tr><td>联系人电话:</td><td><input id="lxrdhxg" name="lxrdh" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'"></td></tr>
        <tr><td><a id="xgan" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a></td></tr>
    </table>
</form>
<script type="text/javascript">
    $(function () {
        var id = $("#dgvkh").datagrid("getSelected").khid;
        $("#khidxg").val(id);
        $.get("ckkhid",{"khid":id},function (data) {
            $("#khnamexg").val(data.khname)
            $("#khyxxg").val(data.khyx)
            $("#khgsdzxg").val(data.khgsdz)
            $("#khgsdhxg").val(data.khgsdh)
            $("#lxrxg").val(data.lxr)
            $("#lxrdhxg").val(data.lxrdh)
        })
    })
    $("#xgan").click(function () {
        $('#khxg').form('submit', {
            url:"khxg",
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
                //关闭当前修改窗口
                $("#kheditwin").window("close");
                //刷新后台表格数据
                $("#dgvkh").datagrid('load',{khname:$("#khname").val()});
            }
        });
    });
</script>
</body>
</html>

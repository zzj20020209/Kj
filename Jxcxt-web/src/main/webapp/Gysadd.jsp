<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/26
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>供应商添加</title>
</head>
<body>
    <form id="addgysform" method="post">
        <table align="center" >
            <tr><td>供应商名称:</td><td><input id="gname" name="gname" class="easyui-validatebox" style="width:80px;" data-options="required:true,validType:'length[1,20]'" /></td></tr>
            <tr><td>供应商邮编:</td><td><input id="gyx" name="gyx" class="easyui-validatebox" style="width:80px;" required="required"></td></tr>
            <tr><td>供应商公司地址:</td><td><input id="gsdz" name="gsdz" class="easyui-validatebox" style="width:80px;" data-options="required:true,validType:'length[1,20]'"/></td></tr>
            <tr><td>供应商公司电话:</td><td><input id="gsdh" name="gsdh" class="easyui-validatebox" style="width:80px;" data-options="required:true,validType:'length[11,11]'" /></td></tr>
            <tr><td><a id="btnaddgys_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a></td></tr>
        </table>
    </form>
<script type="text/javascript">
    $("#btnaddgys_add").click(function () {
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $('#addgysform').form('submit', {
            url:"gysadd",
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
                $("#gysaddwin").window("close");

                //刷新后台表格数据
                $("#dgvgys").datagrid('load',{gname: $("#gname").val()});

            }
        });

    });

</script>
</body>
</html>

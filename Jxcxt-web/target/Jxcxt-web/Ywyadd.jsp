<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/27
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>业务员增加</title>
</head>
<body>
<form id="addywyform" method="post">
    业务员名称：<input id="ywyname" name="ywyname" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]'" />  <br>
    业务员年龄：<input name="ywyage" id="ywyage" class="easyui-numberspinner" style="width: 150px" required="required" data-options="min:20,max:38"><br>
    业务员性别：<input type="radio" name="ywysex" id="ywynan" checked="checked" value="男">男<input type="radio" name="ywysex" id="ywynv" value="女">女<br>
</form>
<a id="btnaddywy_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>
<script type="text/javascript">
    $("#btnaddywy_add").click(function () {
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $('#addywyform').form('submit', {
            url:"ywyadd",
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
                $("#ywyaddwin").window("close");
                //刷新后台表格数据
                $("#dgvywy").datagrid('load',{ywyname:$("#ywyname").val()});
            }
        });
    });
</script>
</body>
</html>

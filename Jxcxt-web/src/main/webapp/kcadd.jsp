<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/24
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加仓库</title>
</head>
<body>
<form id="addkcform" method="post">
    仓库名称:<input id="kcnames" name="kcname" class="easyui-validatebox" style="width:80px;" data-options="required:true,validType:'length[1,20]'" />
</form>
<a id="btnaddkc_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>

<script type="text/javascript">
    $("#btnaddkc_add").click(function () {
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");

        $('#addkcform').form('submit', {
            url:"kcadd",
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
                $("#kcaddwin").window("close");

                //刷新后台表格数据
                $("#dgvkc").datagrid('load',{kcname: $("#kcname").val()});
            }
        });

    });

</script>
</body>
</html>

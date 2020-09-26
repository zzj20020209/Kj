<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/2
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购订单</title>
</head>
<body>
    <form id="cg" method="post">
        采购员:<input id="cgr" name="yname" value="${username}" readonly="readonly"><br>
        采购单备注:<input name="bz" id="cgdbz"><br>
    </form>
    <div id="cgqr">
        <a id="cgddqr" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">确认</a>
    </div>

    <script type="text/javascript">
        $("#cgddqr").click(function () {
            //组装页面数据  json
            //$.post("adduser.action",{},functuion(data){},"json");
            $('#cg').form('submit', {
                url:"cgljadd",
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
                    $("#cgaddwin").window("close");
                    $("#dgvcgdd").datagrid('load');
                }
            });
        });
    </script>
</body>
</html>

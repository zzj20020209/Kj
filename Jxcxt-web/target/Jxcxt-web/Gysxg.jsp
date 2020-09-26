<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/3
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>供应商修改</title>
</head>
<body>
    <form id="gysxg" method="post">
        <table id="gysxgb">
            <tr><td>供应商ID:</td><td><input type="text" name="gid" id="gidxg" readonly="readonly"></td></tr>
            <tr><td>供应商名称:</td><td><input name="gname" id="gnamexg" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]'"></td></tr>
            <tr><td>供应商邮编:</td><td><input id="gyxxg" name="gyx" class="easyui-validatebox" required="required"></td></tr>
            <tr><td>供应商公司地址:</td><td><input id="gsdzxg" name="gsdz" class="easyui-validatebox"  data-options="required:true,validType:'length[1,20]'"/></td></tr>
            <tr><td>供应商公司电话:</td><td><input id="gsdhxg" name="gsdh" class="easyui-validatebox"  data-options="required:true,validType:'length[11,11]'" /></td></tr>
            <tr><td><a id="btnaddgys_xg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a></td></tr>
        </table>
    </form>
    <script type="text/javascript">

        $(function () {
            var id=$("#dgvgys").datagrid("getSelected").gid;
            $("#gidxg").val(id);
            $.get("gyscxid",{"gid":id},function (data) {
                $("#gnamexg").val(data.gname)
                $("#gsdzxg").val(data.gsdz)
                $("#gsdhxg").val(data.gsdh)
                $("#gyxxg").val(data.gyx)
            });
            $("#btnaddgys_xg").click(function () {
                //组装页面数据  json
                //$.post("adduser.action",{},functuion(data){},"json");
                $('#gysxg').form('submit', {
                    url:"gysxg",
                    onSubmit: function(){
                        /* if($("#name").val().length <10){
                             return false;
                         }*/
                        /*  return true;*/
                        //表单中验证都通过  返回true
                        //只要有一个没通过  返回false
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
                        $("#gyseditwin").window("close");
                        //刷新后台表格数据
                        $("#dgvgys").datagrid('load',{gname:$("#gname").val()});
                    }
                });
            });
        })
    </script>
</body>
</html>

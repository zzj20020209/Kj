<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/2
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
    <form id="userEdit" method="post">
        <table id="userxg" align="center">
            <tr><td>编号</td><td><input type="text" id="yidxg" name="yid" class="easyui-validatebox" readonly="readonly"></td></tr>
            <tr><td>员工姓名：</td><td><input type="text" id="ynamexg" name="yname" class="easyui-validatebox" readonly="readonly" required="required"></td></tr>
            <tr><td>密码：</td><td><input name="password" id="passwordxg" class="easyui-validatebox" required="required"></td></tr>
            <tr><td>身份证:</td><td><input type="text" name="sfz" id="sfzxg" class="easyui-validatebox" data-options="required:true,validType:'length[16,18]'"></td></tr>
            <tr><td>性别:</td><td>男<input type="radio" id="nanxg" value="男" name="sex">女<input type="radio" id="nvxg" name="sex" value="女"></td></tr>
            <tr><td>电话:</td><td><input id="telephonexg" name="telephone" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]'"></td></tr>
            <tr><td>邮箱：</td><td><input name="mailbox" id="mailboxxg" class="easyui-validatebox" required="required"></td></tr>
            <tr><td>住址：</td><td><input name="ygdz" id="ygdzxg" class="easyui-validatebox" required="required"></td></tr>
            <tr><td><a id="btnadduser_xg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a></td></tr>
        </table>
    </form>
    <script type="text/javascript">
        /*$("#spcd").combobox({
            url:'spcxid?spid='+,
            valueField:'id',
            textField:'spcd',
            onLoadSuccess:function(){
                $("#spcd").combobox("select","深圳")
            }
        })*/
        $(function () {
            var id=$("#dgvuser").datagrid("getSelected").yid;
            $("#yidxg").val(id);
            $.get("cxid",{"yid":id},function (data) {
                /*$("#xgspform").form("load",{
                    spname:data.spname,
                    gname:data.gid,
                    text:data.id,
                    spscph:data.spscph,
                    spms:data.spms,
                    price:data.price
                })*/
                $("#ynamexg").val(data.yname)
                $("#passwordxg").val(data.password)
                $("#sfzxg").val(data.sfz)
                if(data.sex=="男"){
                    $("#nanxg").prop("checked","true")
                }else {
                    $("#nvxg").prop("checked","true")
                }
                $("#telephonexg").val(data.telephone)
                $("#mailboxxg").val(data.mailbox)
                $("#ygdzxg").val(data.ygdz)
            });
            $("#btnadduser_xg").click(function () {
                //组装页面数据  json
                //$.post("adduser.action",{},functuion(data){},"json");
                $('#userEdit').form('submit', {
                    url:"xg",
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
                        $("#editwin").window("close");
                        //刷新后台表格数据
                        $("#dgvuser").datagrid('load',{yname:$("#yname").val()});
                    }
                });
            });
        })
    </script>

</body>
</html>

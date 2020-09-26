<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/22
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品修改</title>
</head>
<body>
<form id="xgspform" method="post">
<table align="center">
    <tr><td>商品id:</td><td><input id="sid" name="spid" readonly="readonly"></td></tr><br>
    <tr><td>商品名称:</td><td><input id="spnames" name="spname" class="easyui-validatebox" data-options="required:true,validType:'length[1,20]'" /></td></tr>
    <tr><td>商品类型：</td><td><select name="splx" id="text" class="easyui-combobox" style="width: 150px"></select></td></tr>
    <tr><td>商品生产批号:</td><td><input type="text" name="spscph" id="spscph" class="easyui-validatebox" data-options="required:true,validType:'length[13,13]'"></td></tr>
    <tr><td>商品描述:</td><td><input type="text" id="spms" name="spms" required="required"></td></tr>
    <tr><td><a id="btnxgsp_xg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a></td></tr>
</table>
</form>
<script type="text/javascript">
    $(function () {
        var id=$("#dgvsp").datagrid("getSelected").spid;
        $("#sid").val(id);
        $.get("spcxid",{"spid":id},function (data) {
            /*$("#xgspform").form("load",{
                spname:data.spname,
                gname:data.gid,
                text:data.id,
                spscph:data.spscph,
                spms:data.spms,
                price:data.price
            })*/
            $("#spnames").val(data.spname)
            $("#spscph").val(data.spscph)
            $("#spms").val(data.spms)
            $("#price").numberbox("setValue",data.price)
        $("#text").combobox({
            url:'splx',
            valueField:'id',
            textField:'text',
            onBeforeLoad:function () {
                $("#text").combobox("select", data.splx)
            }
        })
        });
        $("#btnxgsp_xg").click(function () {
            //组装页面数据  json
            //$.post("adduser.action",{},functuion(data){},"json");
            $('#xgspform').form('submit', {
                url:"spxg",
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
                    $("#speditwin").window("close");
                    //刷新后台表格数据
                    $("#dgvsp").datagrid('load',{spname:$("#spname").val(),splx:$("#zsplx").combobox("getValue")});
                }
            });
        });
    })
</script>
</body>
</html>

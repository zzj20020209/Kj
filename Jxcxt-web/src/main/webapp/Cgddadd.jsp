<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/1
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购区域</title>
</head>
<body>
    <form id="addcgddform" method="post">
        <table id="addcgdd">
            <tr><td>采购商品名称:</td><td><select name="spid" id="cgsp" class="easyui-combobox" style="width: 200px" required="required"></select></td>
                <td>商品供应商:</td><td><select name="gid" id="spgys" class="easyui-combobox" style="width: 200px" required="required"></select></td></tr>
            <tr><td>采购商品价格:</td><td><input id="cgspjg" name="spjg" readonly="readonly"/></td>
                <td>采购数量:</td><td><input id="cgsl" name="spsl" class="easyui-numberspinner" style="width:80px;" required="required" data-options="min:1,max:9999999999"></td></tr>
            <tr><td><a id="btnaddcgdd_add" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a></td></tr>
        </table>
    </form>



    <table id="cgddb"></table>
    <div id="ddtbuser">
        <a id="cgddadd" class="easyui-linkbutton" data-options="iconCls:'icon-save'">申请</a>
        <a id="cgddsc" class="easyui-linkbutton" data-options="iconCls:'icon-save'">删除</a>
    </div>
    <script type="text/javascript">
        $(function () {
            var param ={
                url:'ddbcx',
                queryParams:{"cgddid":id},
                columns:[[
                    {field:'ck',title:'全选',checkbox:true,width:100},
                    {field:'ddid',title:'订单ID',width:100},
                    {field: 'spname',title: '商品',width: 100},
                    {field: 'spjg',title: '商品价格',width: 100},
                    {field: 'spsl',title: '商品数量',width: 100}
                ]],
                fitColumns:true,
                toolbar:'#ddtbuser',
                striped:true,   //是否显示斑马线效果
                pagination:true,  //则在DataGrid控件底部显示分页工具栏。
                rownumbers:true,   //如果为true，则显示一个行号列。
            };

            $("#cgddb").datagrid(param);

            $("#cgsp").combobox({
                url:'spcx',
                valueField:'spid',
                textField:'spname'
            })
            var spname="";
            var gname="";
            $("#cgsp").combobox({
                onSelect:function (record) {
                    spname=record.spname;
                        $("#spgys").combobox({
                            url:'cgys',
                            queryParams:{"spname":spname},
                            valueField:'gid',
                            textField:'gname',
                            onSelect:function (record) {
                                gname=record.gname;
                                $.get("cgys",{"spname":spname,"gname":gname},function (data) {
                                    $("#cgspjg").val(data[0].price)
                                })
                            }
                        })
                }
            })
            $("#btnaddcgdd_add").click(function () {
                //组装页面数据  json
                //$.post("adduser.action",{},functuion(data){},"json");
                $('#addcgddform').form('submit', {
                    url:"ddbadd",
                    queryParams:{"cgddid":id},
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
                        //刷新后台表格数据
                        $("#cgddb").datagrid('load');
                    }
                });
            });

            //删除
            $("#cgddsc").click(function () {

                //获取所有选中行的记录数组
                var selrows = $("#cgddb").datagrid("getSelections");
                /*alert(selrows[0].spid)*/
                if (selrows.length == 0) {
                    $.messager.alert('消息', '请选择一条记录！', 'info');
                    return;
                }
                $.messager.confirm('确认对话框', '您确认删除商品吗 ？', function (r) {
                    if (r) {
                        //获取当前选中的记录的id
                        var ids = "";
                        for (var i = 0; i < selrows.length; i++) {
                            ids += selrows[i].ddid + ",";
                        }
                        $.get("ddbsc", {"ids": ids}, function (data) {
                            //弹出结果消息
                            $.messager.show({
                                title: '消息',
                                msg: data.msg,
                                timeout: 5000,
                                showType: 'slide'
                            });
                            //刷新表格数据
                            $("#cgddb").datagrid('load');
                        }, "json");
                    }
                });
            });
            //关闭当前添加窗口
            $("#cgddadd").click(function () {
                $.get("czjg",{"cgddid":id},function (data) {
                    $.messager.show({
                        title: '消息',
                        msg: data,
                        timeout: 5000,
                        showType: 'slide'
                    });
                },"json")
                $("#cgddaddwin").window("close");
                $("#dgvcgdd").datagrid('load');
            });
        })
    </script>
</body>
</html>

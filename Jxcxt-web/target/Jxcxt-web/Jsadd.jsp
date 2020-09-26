<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/2
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑员工角色</title>
</head>
<body>
    <form id="bjjs" method="post">
        选择角色:<select name="jid" id="js" class="easyui-combobox" style="width: 150px"></select>
        <a id="btnxgjs_xg" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">授权</a>
    </form>
    <table id="bjjsb"></table>
    <div id="wangcheng">
        <a id="wc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">完成</a>
        <a id="sc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">删除</a>
    </div>
    <script type="text/javascript">
        $(function () {

            $("#js").combobox({
                url:"queryallroles.action",
                valueField:"jid",
                textField:"jname",
                onLoadSuccess:function(){
                    $("#js").combobox("select",1)
                }
            })

            var id=$("#dgvlj").datagrid("getSelected").yid;

            var param ={
                url:'ygjscxid',
                queryParams:{"yid":id},
                columns:[[
                    {field:'ck',title:'全选',checkbox:true,width:100},
                    {field:'id',title:'编号',width:100},
                    {field:'yname',title:'员工名字',width:100},
                    {field: 'jname',title: '员工角色',width: 100}
                ]],
                fitColumns:true,
                toolbar:'#wangcheng',
                striped:true,   //是否显示斑马线效果
                pagination:true,  //则在DataGrid控件底部显示分页工具栏。
                rownumbers:true,   //如果为true，则显示一个行号列。
                //singleSelect:true,  //如果为true，则只允许选择一行。
            };

            $("#bjjsb").datagrid(param);

            $("#btnxgjs_xg").click(function () {
                //组装页面数据  json
                //$.post("adduser.action",{},functuion(data){},"json");
                $('#bjjs').form('submit', {
                    url:"ygjsadd",
                    queryParams:{"yid":id},
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
                        $("#bjjsb").datagrid('load',{yid:id});
                    }
                });
            });

            //删除
            $("#sc").click(function () {

                //获取所有选中行的记录数组
                var selrows = $("#bjjsb").datagrid("getSelections");
                /*alert(selrows[0].spid)*/
                if (selrows.length == 0) {
                    $.messager.alert('消息', '请选择一条记录！', 'info');
                    return;
                }
                $.messager.confirm('确认对话框', '您确认删除该员工职位吗 ？', function (r) {
                    if (r) {
                        //获取当前选中的记录的id
                        var ids = "";
                        for (var i = 0; i < selrows.length; i++) {
                            ids += selrows[i].id + ",";
                        }
                        $.get("ygjssc", {"ids": ids}, function (data) {
                            //弹出结果消息
                            $.messager.show({
                                title: '消息',
                                msg: data.msg,
                                timeout: 5000,
                                showType: 'slide'
                            });

                            //刷新表格数据
                            $("#bjjsb").datagrid('load', {yid:id});
                        }, "json");
                    }
                });
            });

            $("#wc").click(function () {
                $("#jsaddwin").window("close");
            });
        })
    </script>
</body>
</html>

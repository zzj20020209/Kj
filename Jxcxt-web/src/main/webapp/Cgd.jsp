<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/4
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购单</title>
</head>
<body>
<div id="cgdbtn">
    <a id="cgdjh" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">进货</a>
    <a id="cgdth" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">退货</a>
</div>

<table id="cgdb"></table>


<div id="ckwin" class="easyui-window" title="商品详情" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'ddxq.jsp',closed:true">
</div>

<script type="text/javascript">
    $(function () {

        //页面加载完成  初始化表格数据
        var param = {
            url: 'cgdcxsl',
            columns: [[
                {field: 'ck', title: '全选', checkbox: true, width: 100},
                {field: 'cgddid', title: '采购订单ID', width: 100},
                {field: 'bz', title: '备注', width: 100},
                {field: 'yname', title: '采购员', width: 100},
                {field: 'cgdsj', title: '采购单生成时间', width: 100},
                {field: 'zjg', title: '商品总价格', width: 100},
                {
                    field: 'cgzt', title: '采购状态', width: 100, align: 'right',
                    formatter: function (value) {
                        if (value == 0) {
                            return "采购中";
                        } else if (value == 1) {
                            return "采购完成";
                        } else if(value == 2){
                            return "已退货";
                        }
                    }
                }
            ]],
            fitColumns: true,
            toolbar: '#cgdbtn',
            striped: true,   //是否显示斑马线效果
            pagination: true,  //则在DataGrid控件底部显示分页工具栏。
            rownumbers: true,   //如果为true，则显示一个行号列。
            singleSelect: true,  //如果为true，则只允许选择一行。
            pageSize: 5,   //在设置分页属性的时候初始化页面大小
            pageList: [5, 10, 15, 20, 25]   //初始化页面大小选择列表。
        };
        $("#cgdb").datagrid(param);
    })

    $("#cgdjh").click(function () {
        var id=$("#cgdb").datagrid("getSelected").cgddid;
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $.get("cgdjh",{"cgddid":id},function (data) {
            $.messager.show({
                title:'我的消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
        },"text");
        $("#cgdb").datagrid('load');
    });

    $("#cgdth").click(function () {
        var id=$("#cgdb").datagrid("getSelected").cgddid;
        $.get("cgdth",{"cgddid":id},function (data) {
            $.messager.show({
                title:'我的消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
        },"text");
        $("#cgdb").datagrid('load');
    })


    $("#cgdb").datagrid({
        onDblClickRow:function (rowIndex,rowDate) {
                $("#ckwin").window("open");
                $("#ckwin").window("refresh");
        }
    })
</script>
</body>
</html>

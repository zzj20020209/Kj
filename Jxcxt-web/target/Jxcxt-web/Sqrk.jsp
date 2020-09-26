<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/9/5
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入库申请</title>
</head>
<body>
    <div id="rkan">
        选择进货仓库:<input name="kid" id="ck"></input>
        <a id="tyrk" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">入库</a>
        <a id="jjrk" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">拒绝入库</a>
    </div>
    <table id="rksq"></table>

    <div id="rkwin" class="easyui-window" title="商品详情" style="width:600px;height:400px"
         data-options="iconCls:'icon-add',modal:true,href:'Cgdspxq.jsp',closed:true">
    </div>
    <script type="text/javascript">
        $(function () {
            $("#ck").combobox({
                url:"kccx",
                valueField:'kid',
                textField:'kcname',
                onLoadSuccess:function(){
                    $("#ck").combobox("select",10001)
                }
            })
            var param = {
                url: 'rksqcx',
                columns: [[
                    {field: 'ck', title: '全选', checkbox: true, width: 100},
                    {field: 'cgddid', title: '采购订单ID', width: 100},
                    {field: 'bz', title: '备注', width: 100},
                    {field: 'yname', title: '采购员', width: 100},
                    {field: 'cgdsj', title: '采购单生成时间', width: 100},
                    {field: 'zjg', title: '商品总价格', width: 100},
                    {
                        field: 'rkzt', title: '入库状态', width: 100, align: 'right',
                        formatter: function (value) {
                            if (value == 0) {
                                return "待入库";
                            } else if (value == 1) {
                                return "已通过";
                            }
                        }
                    }
                ]],
                fitColumns: true,
                toolbar: '#rkan',
                striped: true,   //是否显示斑马线效果
                pagination: true,  //则在DataGrid控件底部显示分页工具栏。
                rownumbers: true,   //如果为true，则显示一个行号列。
                singleSelect: true,  //如果为true，则只允许选择一行。
                pageSize: 5,   //在设置分页属性的时候初始化页面大小
                pageList: [5, 10, 15, 20, 25]   //初始化页面大小选择列表。
            };
            $("#rksq").datagrid(param);
        })

        $("#tyrk").click(function () {
            var aar1=$("#rksq").datagrid("getSelected").cgddid;
                    $.post("kcrladd",{"cgddid":aar1,"kid":$("#ck").val()},function (data) {
                        $.messager.show({
                            title:'我的消息',
                            msg:data,
                            timeout:5000,
                            showType:'slide'
                        });
                    },"text")
                $("#rksq").datagrid('load');
        })
        $("#rksq").datagrid({
            onDblClickRow:function (rowIndex,rowDate) {
                    $("#rkwin").window("open");
                    $("#rkwin").window("refresh");
            }
        })
    </script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/31
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>采购订单</title>
</head>
<body>
<div id="cgddtbuser">
    <a id="btncgadd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">采购</a>
    <a id="btncgddxq" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">详情</a>
    <a id="btncgddsc" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
    <a id="ty" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">同意</a>
    <a id="jj" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">拒绝</a>
</div>

<table id="dgvcgdd"></table>

<!-- 添加窗口-->
<div id="cgddaddwin" class="easyui-window" title="添加商品" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Cgddadd.jsp',closed:true">
</div>

<div id="cgaddwin" class="easyui-window" title="添加订单" style="width:300px;height:200px"
     data-options="iconCls:'icon-add',modal:true,href:'Cgadd.jsp',closed:true">
</div>

<div id="xqwin" class="easyui-window" title="商品详情" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'Spxq.jsp',closed:true">
</div>


<script type="text/javascript">
    var id =0;
    $(function () {
        //页面加载完成  初始化表格数据
        var param = {
            url: 'cgljcxsl',
            columns: [[
                {field: 'ck', title: '全选', checkbox: true, width: 100},
                {field: 'cgddid', title: '采购订单ID', width: 100},
                {field: 'bz', title: '备注', width: 100},
                {field: 'yname', title: '采购员', width: 100},
                {field: 'cgsj', title: '采购订单生成时间', width: 100},
                {field: 'zjg', title: '商品总价格', width: 100},
                {
                    field: 'zt', title: '申请状态', width: 100, align: 'right',
                    formatter: function (value) {
                        if (value == 1) {
                            return "申请成功";
                        } else if (value == 0) {
                            return "申请中";
                        } else if (value == 2) {
                            return "申请被拒绝";
                        }
                    }
                }
            ]],
            fitColumns: true,
            toolbar: '#cgddtbuser',
            striped: true,   //是否显示斑马线效果
            pagination: true,  //则在DataGrid控件底部显示分页工具栏。
            rownumbers: true,   //如果为true，则显示一个行号列。
            singleSelect: true,  //如果为true，则只允许选择一行。
            pageSize: 5,   //在设置分页属性的时候初始化页面大小
            pageList: [5, 10, 15, 20, 25]   //初始化页面大小选择列表。
        };
        $("#dgvcgdd").datagrid(param);
    })

    //获取选中列

        $("#dgvcgdd").datagrid({
            onDblClickRow:function (rowIndex,rowDate) {
                if(rowDate.zt==0){
                        id=rowDate.cgddid
                        $("#cgddaddwin").window("open");
                        $("#cgddaddwin").window("refresh");
                }else if(rowDate.zt==1 || rowDate.zt==2){
                        alert("申请完毕后不能修改商品")
                }
            }
        })
    //订单
    $("#btncgadd").click(function () {
        $("#cgaddwin").window("open");
        $("#cgddaddwin").window("refresh");
    });
    //详情
    $("#btncgddxq").click(function () {
        var aar2=$("#dgvcgdd").datagrid("getSelections");
        if (aar2.length == 0) {
            $.messager.alert('消息', '请选择一条记录！', 'info');
            return;
        }
        $("#xqwin").window("open");
        $("#xqwin").window("refresh");
    });
    //删除按钮  绑定事件
    $("#btncgddsc").click(function () {
        //获取所有选中行的记录数组
        /*alert(selrows[0].spid)*/
        var aar1=$("#dgvcgdd").datagrid("getSelections");
        if (aar1.length == 0) {
            $.messager.alert('消息', '请选择一条记录！', 'info');
            return;
        }
        $.messager.confirm('确认对话框', '您确认删除这些订单吗？', function (r) {
            if (r) {

                //获取当前选中的记录的id
                var ids = "";
                for (var i = 0; i < aar1.length; i++) {
                    ids += aar1[i].cgddid + ",";
                }
                $.get("cgljsc", {"ids": ids}, function (data) {
                    //弹出结果消息
                    $.messager.show({
                        title: '消息',
                        msg: data.msg,
                        timeout: 5000,
                        showType: 'slide'
                    });

                    //刷新表格数据
                    $("#dgvcgdd").datagrid('load');
                }, "json");
            }
        });
    });
    $.get("ygjscxid",{"yid":${yid}},function (data) {
        for (var i=0;i<data.length;i++){
            if(data[i].jname=="管理员" || data[i].jname=="业务员"){
                $("#ty").show();
                $("#jj").show();
                break;
            }else {
                $("#ty").hide();
                $("#jj").hide();
            }
        }
    })
    //同意
    $("#ty").click(function () {
        var id=$("#dgvcgdd").datagrid("getSelected").cgddid;
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $.get("ty",{"cgddid":id},function (data) {
            $.messager.show({
                title:'我的消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
        },"text");
        $("#dgvcgdd").datagrid('load');
    });
    $("#jj").click(function () {
        var id=$("#dgvcgdd").datagrid("getSelected").cgddid;
        //组装页面数据  json
        //$.post("adduser.action",{},functuion(data){},"json");
        $.get("jj",{"cgddid":id},function (data) {
            $.messager.show({
                title:'我的消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
        },"text");
        $("#dgvcgdd").datagrid('load');
    });
</script>
</body>
</html>

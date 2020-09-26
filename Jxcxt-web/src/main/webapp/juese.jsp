<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/19
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'角色选择',split:true" style="width:40%;">
        <div id="priv_tb">
            <a id="priv_btnsave" class="easyui-linkbutton" data-options="iconCls:' icon-201208041220'">授权</a>

        </div>
        <!--  显示所有角色-->
        <table id="priv_dgvrole"></table>
    </div>
    <div data-options="region:'center',title:'菜单选择'" style="padding:5px;width:60%;">
<!--  显示所有的菜单信息  tree   状态-->
        <ul id="priv_treemenu"></ul>
    </div>
</div>
<script type="text/javascript">
    //加载角色信息列表的
    var priv_dgvroleparam ={
        url:'queryallroles.action',
        columns:[[
            {field:'ck',checkbox:true,title:'Code',width:100},
            {field:'id',title:'ID',width:100},
            {field:'jid',title:'角色ID',width:100},
            {field:'jname',title:'角色名字',width:100,align:'right'}
        ]],
        toolbar:"#priv_tb",
        singleSelect:true,
        onClickRow:function (rowIndex, rowData) {
           //将选中的角色id  传递给  tree控件绑定的地址
            jid = rowData.id;
            //重新加载树控件
            $('#priv_treemenu').tree('reload');

        }
    };
    $('#priv_dgvrole').datagrid(priv_dgvroleparam);

    var jid =0;

    //权限页面 显示所有的菜单信息
    var priv_treemenuparam= {
        url:'qxcd',
        checkbox:true,
        queryParams:{"jid":jid},  //额外传递参数   post方式
        onBeforeLoad:function (node, param) {  //提交之前触发  参数  param包含这次请求的所有的参数
            param.jid  =jid;
            return true;
        }
    };
    $('#priv_treemenu').tree(priv_treemenuparam);

    //绑定授权按钮点击事件
    $("#priv_btnsave").click(function () {

        //获取角色id
        var selrow = $('#priv_dgvrole').datagrid('getSelected');
        if(selrow ==null){
            alert("请选择一个角色！")
            return;
        }
        var jid = selrow.id;
        //获取菜单id
        var nodes = $('#priv_treemenu').tree('getChecked', ['checked','indeterminate']);
        var mids ="";
        for (var i =0;i<nodes.length;i++){
            mids+= nodes[i].id+",";
        }

        //$.post();

        $.post("shouquan.action",{"jid":jid,"mids":mids},function (data) {
            $.messager.show({
                title:'消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
        },"text");
    });
</script>
</body>
</html>

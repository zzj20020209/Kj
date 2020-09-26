<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/17
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <!-- 3个js  2个css -->
    <!-- jquery -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <!-- easyui -->
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <!-- 语言包 -->
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <!-- 主体样式 -->
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <!-- 图标样式 -->
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <!-- 导入扩展图标-->
    <link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
</head>
<style>
    a {
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true" style="width:600px;height:400px;">
    <div data-options="region:'north',split:true" style="height:125px;">
        <h1>进销存管理系统</h1>
        <h3>用户:<a href="dl.jsp">${username}</a> 登录了！！！</h3>
    </div>

    <div data-options="region:'west',title:'菜单管理',split:true" style="width:175px;">
        <!-- 左边区域  放置  菜单-->
        <ul id="menutree"></ul>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        <!--中间区域  显示选项卡 -->
        <div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
            <div title="首页" style="padding:20px;display:none;">
                <h1>欢迎使用本系统</h1>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var treeparam = {
        url: "cxcd?yid=" +${yid},
    };
    $("#menutree").tree(treeparam);

    //树 菜单 单机事件
    $("#menutree").tree({
        onClick: function (node) {
            //判断点击的节点是否为子节点
            var arr = $("#menutree").tree("isLeaf", node.target);
            //判断 面板是否存在
            var p = $("#tt").tabs("exists", node.text);

            //是 子节点
            if (arr) {

                //面板 存在打开面板
                if (p) {
                    $("#tt").tabs("select", node.text);
                } else {
                    //面板 不存在 添加
                    $("#tt").tabs('add', {
                        title: node.text,
                        href: node.url,
                        closable: true,
                        tools: [{
                            iconCls: 'icon-mini-refresh',
                            handler: function () {
                                alert('refresh');
                            }
                        }]

                    })
                }
            }
        }
    })
</script>
</body>
</html>

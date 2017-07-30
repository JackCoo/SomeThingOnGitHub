<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 视窗自适应 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <title>组织管理</title>

    <!-- 引入Bootstrap样式 -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- 引入jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 引入BootStrap JS -->
    <script src="resources/js/bootstrap.min.js"></script>
    
	<!--   引入zTree样式   -->
    <link rel="stylesheet" href="resources/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<!--    引入zTree JS   -->
	<script type="text/javascript" src="resources/js/jquery.ztree.core.js"></script>


	<SCRIPT type="text/javascript" >
	  <!--
		var zTree;
		var demoIframe;

		//配置
		var setting = {
			view: {
				dblClickExpand: false,//双击展开
				showLine: true,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable:true,
					idKey: "id",//节点唯一标示符的名称
					pIdKey: "pId",//父节点的属性名
					rootPId: ""
				}
			},
			//treeId:zTree 的唯一标识，初始化后，等于 用户定义的 zTree 容器的 id 属性值。
			callback: {
				beforeClick: function(treeId, treeNode) {//用于捕获单击节点之前的事件回调函数，并且根据返回值确定是否允许单击操作--决定是否会掉onClick函数?
					var zTree = $.fn.zTree.getZTreeObj("tree");
					if (treeNode.isParent) {

						//展开该节点
						zTree.expandNode(treeNode);

						//加载页面
						demoIframe.attr("src",treeNode.file + ".html");

						return false;//不允许单击
						//如果返回 false，zTree 将不会选中节点，也无法触发 onClick 事件回调函数
					} else {
						demoIframe.attr("src",treeNode.file + ".html");
						return true;
					}
				}
			}
		};



	// 	节点数据--可设置任意不和zTree冲突的属性,id和pid在setting里设置了.
		var zNode =[
			{id:1, pId:0, name:"[core] 基本功能演示", open:true},
			{id:101, pId:1, name:"最简单的树 --  标准 JSON 数据", file:"core/standardData"},
			{id:102, pId:1, name:"最简单的树 --  简单 JSON 数据", file:"core/simpleData"},
			{id:103, pId:1, name:"不显示 连接线", file:"core/noline"},
			{id:104, pId:1, name:"不显示 节点 图标", file:"core/noicon"},
			{id:105, pId:1, name:"自定义图标 --  icon 属性", file:"core/custom_icon"},
			{id:106, pId:1, name:"自定义图标 --  iconSkin 属性", file:"core/custom_iconSkin"},
            {id:107, pId:1, name:"自定义字体", file:"core/custom_font"},
			{id:115, pId:1, name:"超链接演示", file:"core/url"},
			{id:108, pId:1, name:"异步加载 节点数据", file:"core/async"},
			{id:109, pId:1, name:"用 zTree 方法 异步加载 节点数据", file:"core/async_fun"},
			{id:110, pId:1, name:"用 zTree 方法 更新 节点数据", file:"core/update_fun"},
			{id:111, pId:1, name:"单击 节点 控制", file:"core/click"},
			{id:112, pId:1, name:"展开 / 折叠 父节点 控制", file:"core/expand"},
			{id:113, pId:1, name:"根据 参数 查找 节点", file:"core/searchNodes"},
			{id:114, pId:1, name:"其他 鼠标 事件监听", file:"core/otherMouse"},

			{id:2, pId:0, name:"[excheck] 复/单选框功能 演示", open:false},
			{id:201, pId:2, name:"Checkbox 勾选操作", file:"excheck/checkbox"},
			{id:206, pId:2, name:"Checkbox nocheck 演示", file:"excheck/checkbox_nocheck"},
			{id:207, pId:2, name:"Checkbox chkDisabled 演示", file:"excheck/checkbox_chkDisabled"},
			{id:208, pId:2, name:"Checkbox halfCheck 演示", file:"excheck/checkbox_halfCheck"},
			{id:202, pId:2, name:"Checkbox 勾选统计", file:"excheck/checkbox_count"},
			{id:203, pId:2, name:"用 zTree 方法 勾选 Checkbox", file:"excheck/checkbox_fun"},
			{id:204, pId:2, name:"Radio 勾选操作", file:"excheck/radio"},
			{id:209, pId:2, name:"Radio nocheck 演示", file:"excheck/radio_nocheck"},
			{id:210, pId:2, name:"Radio chkDisabled 演示", file:"excheck/radio_chkDisabled"},
			{id:211, pId:2, name:"Radio halfCheck 演示", file:"excheck/radio_halfCheck"},
			{id:205, pId:2, name:"用 zTree 方法 勾选 Radio", file:"excheck/radio_fun"},

			{id:3, pId:0, name:"[exedit] 编辑功能 演示", open:false},
			{id:301, pId:3, name:"拖拽 节点 基本控制", file:"exedit/drag"},
			{id:302, pId:3, name:"拖拽 节点 高级控制", file:"exedit/drag_super"},
			{id:303, pId:3, name:"用 zTree 方法 移动 / 复制 节点", file:"exedit/drag_fun"},
			{id:304, pId:3, name:"基本 增 / 删 / 改 节点", file:"exedit/edit"},
			{id:305, pId:3, name:"高级 增 / 删 / 改 节点", file:"exedit/edit_super"},
			{id:306, pId:3, name:"用 zTree 方法 增 / 删 / 改 节点", file:"exedit/edit_fun"},
			{id:307, pId:3, name:"异步加载 & 编辑功能 共存", file:"exedit/async_edit"},
			{id:308, pId:3, name:"多棵树之间 的 数据交互", file:"exedit/multiTree"},

			{id:4, pId:0, name:"大数据量 演示", open:false},
			{id:401, pId:4, name:"一次性加载大数据量", file:"bigdata/common"},
			{id:402, pId:4, name:"分批异步加载大数据量", file:"bigdata/diy_async"},
			{id:403, pId:4, name:"分批异步加载大数据量", file:"bigdata/page"},

			{id:5, pId:0, name:"组合功能 演示", open:false},
			{id:501, pId:5, name:"冻结根节点", file:"super/oneroot"},
			{id:502, pId:5, name:"单击展开/折叠节点", file:"super/oneclick"},
			{id:503, pId:5, name:"保持展开单一路径", file:"super/singlepath"},
			{id:504, pId:5, name:"添加 自定义控件", file:"super/diydom"},
			{id:505, pId:5, name:"checkbox / radio 共存", file:"super/checkbox_radio"},
			{id:506, pId:5, name:"左侧菜单", file:"super/left_menu"},
			{id:513, pId:5, name:"OutLook 风格", file:"super/left_menuForOutLook"},
			{id:515, pId:5, name:"Awesome 风格", file:"super/awesome"},
			{id:514, pId:5, name:"Metro 风格", file:"super/metro"},
			{id:507, pId:5, name:"下拉菜单", file:"super/select_menu"},
			{id:509, pId:5, name:"带 checkbox 的多选下拉菜单", file:"super/select_menu_checkbox"},
			{id:510, pId:5, name:"带 radio 的单选下拉菜单", file:"super/select_menu_radio"},
			{id:508, pId:5, name:"右键菜单 的 实现", file:"super/rightClickMenu"},
			{id:511, pId:5, name:"与其他 DOM 拖拽互动", file:"super/dragWithOther"},
			{id:512, pId:5, name:"异步加载模式下全部展开", file:"super/asyncForAll"},

			{id:6, pId:0, name:"其他扩展功能 演示", open:false},
			{id:601, pId:6, name:"隐藏普通节点", file:"exhide/common"},
			{id:602, pId:6, name:"配合 checkbox 的隐藏", file:"exhide/checkbox"},
			{id:603, pId:6, name:"配合 radio 的隐藏", file:"exhide/radio"}
		];
		

		$(document).ready(function(){
			
			alert("获取节点数据....");
			//获取节点数据
			$.getJSON("http://localhost:8080/WeixinBishe/getGroup",function(data,status){//使用getJSON，注意JSON对象和JSON字符串的差异
			alert("节点获取结果："+status);
			initZtree(data);//初始化zTree
			});
			
		});


		//初始化zTree
		function initZtree (zNodes){
			var t = $("#tree");//用于展现 zTree 的 DOM 容器
			t = $.fn.zTree.init(t, setting, zNodes);//初始化,DOM,配置,节点数据
			demoIframe = $("#testIframe");//左侧展示页面
			demoIframe.bind("load", loadReady);
			var zTree = $.fn.zTree.getZTreeObj("tree");
			zTree.selectNode(zTree.getNodeByParam("id", 101));//选中101节点

		}

		function loadReady() {
			var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
			htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
			maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
			h = demoIframe.height() >= maxH ? minH:maxH ;
			if (h < 530) h = 530;
			demoIframe.height(h);
		}

	  //-->
	</SCRIPT>





  </head>

  <body>

    

  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">组件管理</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

  <TABLE border=0 height=600px align=left>
	<TR>
<!-- zTree部分 -->
		<TD width=260px align=left valign=top style="BORDER-RIGHT: #999999 1px dashed">
			<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
		</TD>
<!-- 资源树右侧页面 -->
		<TD width=770px align=left valign=top><IFRAME ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=600px SRC="core/standardData.html"></IFRAME></TD>
	
	</TR>
</TABLE>


  </body>


</html>
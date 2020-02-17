 <%@ page language="java"  pageEncoding="UTF-8"%>
 <%@ include file="/common/context.jsp"%>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<title>角色管理界面</title>
		<meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="<%=basePath %>common/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=basePath %>common/css/font-awesome.css" />
        <link rel="stylesheet" href="<%=basePath %>common/css/jquery-ui.css" />
		<link rel="stylesheet" href="<%=basePath %>common/css/icheck/flat/blue.css" />
		<link rel="stylesheet" href="<%=basePath %>common/css/select2.css" />		
		<link rel="stylesheet" href="<%=basePath %>common/css/unicorn.css" /> 
		<!--[if lt IE 9]>
		<script type="text/javascript" src="js/respond.min.js"></script>
		<![endif]-->
	<script language="javaScript">   
	  
	     function Query(type)
	    {
	    	//var name = document.getElementById("roleName");
	    	action = document.forms[0].action;
	    	
	    	//alert(name);
	    	if (type=="find"){
				//	action="viewTSysRole_roles.action?sysRole.roleName"+name;
				action="selectViewOrders_projects.action";
					document.forms[0].action = action;
	        		document.forms[0].submit();
			}
	    }
	   
	    //选择订单  查看详情 
	    function selectEgorderDetail(){
	      var egorder = window.showModelessDialog("viewProjectsDetail_projects.action","","");
	      if(egorder!=null){
	  	    var pro = egorder.split('@');
	  	    $('#heth').val(pro[1]);
	  	    $('#kehu').val(pro[2]);
	  	}
	    }
	    
	    function showModeDetail(){ 
			map.clearOverlays();  
			var   select_provinceno = $("#select_provinceno option:selected"); 
			var   select_productId  = $("#select_productId option:selected");       
			 	
			var  data={ 
				select_provinceno:select_provinceno.val()  ,
				select_productId:select_productId.val()
				} ;   
			 $.ajax({
				type : 'POST',
				url  : '/viewProjectsDetail_projects.action',
				data : data,
				dataType : 'json',
				async : false,  
				success : function(infos){      
				var  xhcIcon;
					for(var i=0;i<infos.length;i++){  
					   if(infos[i].product_id==1){
					   var  xhcIcon= new BMap.Icon("../../images/map-marker-marker-outside-azure.png", new BMap.Size(24,24));	
					   }
					   if(infos[i].product_id==2){
					   var  xhcIcon= new BMap.Icon("../../images/map-marker-marker-outside-chartreuse.png", new BMap.Size(24,24));
					   }
					   if(infos[i].product_id==3){
					   var  xhcIcon= new BMap.Icon("../../images/map-marker-marker-outside-pink.png", new BMap.Size(24,24));
					   }
						var marker_demo1 = new BMap.Marker(new BMap.Point(infos[i].Latitude,infos[i].longitude),{icon:xhcIcon});  // 创建标注
						var content1 = "服务站："+infos[i].supplier_name+"<br/>服务站地址："+infos[i].address+"<br/>联系电话："+infos[i].contact;
						map.addOverlay(marker_demo1);               // 将标注添加到地图中
						addClickHandler(content1,marker_demo1); 		 
					}
	 
				 },
				 error: function(XMLHttpRequest, textStatus, errorThrown) {
	                        alert(XMLHttpRequest.status);
	                        alert(XMLHttpRequest.readyState);
	                        alert(textStatus);
	                    }
			}); 
		} 
	    
	</script>
</head>	
 
 <body data-color="grey" class="flat">
 <form id="showEgOrder"   method="post">
 	<div id="content">
		<div id="breadcrumb">
			<a href="#" title="Go to Home" class="tip-bottom"><i class="fa fa-home"></i> Home</a>
			<a href="#" class="current">订单管理</a>
		</div>
		 
				 <s:property value="egorderDetail.heth" />
		经销商名称，底盘号，合同价格？，是否结算 销售方式			 
						</div>
	 
	<!--  详情页面 START-->		
	<div id="myModal" class="modal fade">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button data-dismiss="modal" class="close" type="button">×</button>
													<h3>Modal header</h3>
												</div>
												<div class="modal-body">
													<p>One fine body…</p>
												</div>
											</div>
										</div>
									</div>		
	<!--  详情页面 STOP-->			
	<div class="row">
		<div id="footer" class="col-xs-12">
			2012 - 2013 &copy; Unicorn Admin. Brought to you by <a href="https://wrapbootstrap.com/user/diablo9983">diablo9983</a>
		</div>
	</div>
 </form>        
    <script src="<%=basePath %>common/script/js/jquery.min.js"></script>
    <script src="<%=basePath %>common/script/js/jquery-ui.custom.js"></script>
    <script src="<%=basePath %>common/script/js/bootstrap.min.js"></script>
    <script src="<%=basePath %>common/script/js/jquery.icheck.min.js"></script>
    <script src="<%=basePath %>common/script/js/select2.min.js"></script>
    <script src="<%=basePath %>common/script/js/jquery.dataTables.min.js"></script>
    <script src="<%=basePath %>common/script/js/jquery.nicescroll.min.js"></script>
    <script src="<%=basePath %>common/script/js/unicorn.js"></script>
    <script src="<%=basePath %>common/script/js/unicorn.tables.js"></script>
</body>
</html>

  
 <%@ page language="java"  pageEncoding="UTF-8"%>  
 <%@ include file="/common/context.jsp"%>
<!DOCTYPE html>
<!--[if lt IE 7]>       <html class="no-js lt-ie9 lt-ie8 lt-ie7">   <![endif]-->
<!--[if IE 7]>          <html class="no-js lt-ie9 lt-ie8">          <![endif]-->
<!--[if IE 8]>          <html class="no-js lt-ie9">                 <![endif]-->
<!--[if gt IE 8]><!-->  <html class="no-js">                        <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>订单管理界面</title>
        <meta name="description" content="Metis: Bootstrap Responsive Admin Theme">
        <meta name="viewport" content="width=device-width">
        <link type="text/css" rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="assets/css/bootstrap-responsive.min.css">
        <link type="text/css" rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="assets/css/style.css">
        <link type="text/css" rel="stylesheet" href="assets/css/calendar.css">
        <link type="text/css" rel="stylesheet" href="assets/css/theme.css">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
        <!--[if IE 7]>
        <link type="text/css" rel="stylesheet" href="assets/css/font-awesome-ie7.min.css"/>
        <![endif]-->

        <script src="assets/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js">
        
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
	    function selectEgorderDetail(orderId){
 	 		alert("111");
 	 		alert("orderId="+orderId);
      		var egorder = window.showModalDialog("viewProjectsDetail_projects.action","","dialogWidth:800px;dialogHeight:600px;scroll:no;status:no;");
	      	alert("stop");
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
    <body>
        <!-- BEGIN WRAP -->
        <div id="wrap">
	 	<%@  include  file="/header.jsp" %>
		<%@  include  file="/left.jsp" %>

            <!-- BEGIN MAIN CONTENT -->
            <div id="content">
                <div class="container-fluid outer">
                    <div class="row-fluid">
                        <!-- .inner -->
                        <div class="span12 inner">
                            <!--Begin Datatables-->
                            <div class="row-fluid">
                                <div class="span12">
                                    <div class="box">
                                        <header>
                                            <div class="icons"><i class="icon-move"></i></div>
                                            <h5>订单管理</h5>
                                        </header>
                                        <div id="collapse4" class="body">
                                            <table id="dataTable" class="table table-bordered table-condensed table-hover table-striped">
                                                <thead>
                                                    <tr>
<!-- 										<th>选择</th> -->
										<th>订单状态</th>
										<th>订单号</th>
										<th>合同数</th>
										<th>完成数</th>
										<th>待完数？</th>
										<th>预计交付日</th>
										<th>实际交付日</th>
										<th>签订日期</th>
										<th>执行日期</th>
										<th>底盘到厂日期</th>
										<th>底盘到厂数</th>
										<th>排产时间</th>
										<th>排产数</th>
										<th>整车入库时间</th>
										<th>完成发车时间</th>
									</tr>
                                                </thead>
                                               <s:iterator value="listValue" status="st">
										<tr class="gradeX">
<!-- 											<td> -->
<!-- 											<s:property value="#st.index+1" /> -->
<!-- 											<input type="hidden" value="<s:property value ='Id'/>"> -->
<!-- 											</td> -->
<!-- 											<td><a onclick="selectEgorderDetail(<s:property value="Id"/>)" ><s:property value="heth" /></a> &nbsp;</td> -->
											<td></td>
											<td><s:date name="shengxrq" format="yyyy-MM-dd" /></td>
											<td><s:date name="jiaohrq" format="yyyy-MM-dd" /></td>
											<td class="center">	<s:property value="kehu" /></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td> 
											<td></td> 
											<td></td> 
										</tr>
									</s:iterator> 
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                      </div>
               
            </div>
            <!-- END CONTENT -->


            <!-- #push do not remove -->
            <div id="push"></div>
            <!-- /#push -->
        </div>
        </div>
        </div>
        <!-- END WRAP -->
 		 <%@  include  file="/bottom.jsp" %>
 	
        
       <script src="assets/js/vendor/jquery-1.9.1.min.js"></script>
        <script src="assets/js/vendor/jquery-migrate-1.1.1.min.js"></script>
      
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script type="text/javascript" src="assets/js/lib/jquery.tablesorter.min.js"></script>
        <script type="text/javascript" src="assets/js/lib/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="assets/js/lib/DT_bootstrap.js"></script>
        <script src="assets/js/lib/responsive-tables.js"></script>
        <script type="text/javascript">
            $(function() {
                metisTable();
            });
        </script>
        <script type="text/javascript" src="assets/js/main.js"></script>
        
        
        <script type="text/javascript" src="assets/js/style-switcher.js"></script>
    </body>
</html>
 
 
 
  

  
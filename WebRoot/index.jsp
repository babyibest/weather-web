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
        <title>Dashboard</title>
        <meta name="description" content="Metis: Bootstrap Responsive Admin Theme">
        <meta name="viewport" content="width=device-width">
        <link type="text/css" rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="assets/css/bootstrap-responsive.min.css">
        <link type="text/css" rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="assets/css/style.css">
        <link type="text/css" rel="stylesheet" href="assets/css/calendar.css">
        
        <link rel="stylesheet" href="assets/css/theme.css">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
        <!--[if IE 7]>
        <link type="text/css" rel="stylesheet" href="assets/css/font-awesome-ie7.min.css"/>
        <![endif]-->

        <script src="assets/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!-- BEGIN WRAP -->
        <div id="wrap">

       	<%@  include  file="header.jsp" %>
		<%@  include  file="left.jsp" %>
 		<form method="POST" action="viewOrders_projects.action">
            <!-- BEGIN MAIN CONTENT -->
            <div id="content">
                <!-- .outer -->
                <div class="container-fluid outer">
                    <div class="row-fluid">
                        <!-- .inner -->
                        <div class="span12 inner">
                            <div class="tac">
                                <ul class="stats_box">
                                    <li>
                                        <div class="sparkline bar_week"></div>
                                        <div class="stat_text">
                                            <strong>2.345</strong>Weekly Visit
                                            <span class="percent down"> <i class="icon-caret-down"></i> -16%</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="sparkline line_day"></div>
                                        <div class="stat_text">
                                            <strong>165</strong>Daily Visit
                                            <span class="percent up"> <i class="icon-caret-up"></i> +23%</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="sparkline pie_week"></div>
                                        <div class="stat_text">
                                            <strong>$2 345.00</strong>Weekly Sale
                                            <span class="percent"> 0%</span>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="sparkline stacked_month"></div>
                                        <div class="stat_text">
                                            <strong>$678.00</strong>Monthly Sale
                                            <span class="percent down"> <i class="icon-caret-down"></i> -10%</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <hr>
                            <div class="tac">
                                <a class="quick-btn" href="#">
                                    <i class="icon-bolt icon-2x"></i>
                                    <span>inverse</span>
                                    <span class="label label-inverse">2</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-check icon-2x"></i>
                                    <span>important</span>
                                    <span class="label label-important">2</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-building icon-2x"></i>
                                    <span>No Label</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-envelope icon-2x"></i>
                                    <span>success</span>
                                    <span class="label label-success">-456</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-signal icon-2x"></i>
                                    <span>warning</span>
                                    <span class="label label-warning">+25</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-external-link icon-2x"></i>
                                    <span>&pi;</span>
                                    <span class="label btn-metis-2">3.14159265</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-lemon icon-2x"></i>
                                    <span>&eacute;</span>
                                    <span class="label btn-metis-4">2.71828</span>
                                </a>
                                <a class="quick-btn" href="#">
                                    <i class="icon-glass icon-2x"></i>
                                    <span>&phi;</span>
                                    <span class="label btn-metis-3">1.618</span>
                                </a>
                            </div>
                            <hr>
                            <div class="row-fluid">
                                <div class="span8">
                                    <div class="box">
                                        <header>
                                            <h5>Line Chart</h5>
                                        </header>
                                        <div class="body" id="trigo" style="height: 250px;"></div>
                                    </div>
                                </div>
                                <div class="span4">
                                    <div class="box">
                                        <div class="body">
                                            <table class="table table-bordered table-condensed table-hovered sortableTable">
                                                <thead>
                                                    <tr>
                                                        <th>Country <i class="icon-sort"></i><i class="icon-sort-down"></i><i
                                                                class="icon-sort-up"></i></th>
                                                        <th>Visit <i class="icon-sort"></i><i class="icon-sort-down"></i><i
                                                                class="icon-sort-up"></i></th>
                                                        <th>Time <i class="icon-sort"></i><i class="icon-sort-down"></i><i
                                                                class="icon-sort-up"></i></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Andorra</td>
                                                        <td>1126</td>
                                                        <td>00:00:15</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Belarus</td>
                                                        <td>350</td>
                                                        <td>00:01:20</td>
                                                    </tr>
                                                    <tr class="error">
                                                        <td>Paraguay</td>
                                                        <td>43</td>
                                                        <td>00:00:30</td>
                                                    </tr>
                                                    <tr class="info">
                                                        <td>Malta</td>
                                                        <td>547</td>
                                                        <td>00:10:20</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Australia</td>
                                                        <td>560</td>
                                                        <td>00:00:10</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Kenya</td>
                                                        <td>97</td>
                                                        <td>00:20:00</td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>Italy</td>
                                                        <td>2450</td>
                                                        <td>00:10:00</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="row-fluid">
                                <div class="span8">
                                    <div class="box">
                                        <header>
                                            <h5>Calendar</h5>
                                        </header>
                                        <div id="calendar_content" class="body">
                                            <div id='calendar'></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="span4">
                                    <div class="box">
                                        <header>
                                            <div class="icons"><i class="icon-tags"></i></div>
                                            <h5>Todos</h5>
                                        </header>
                                        <div class="block">
                                            <table class="table table-striped">
                                                <tbody>
                                                    <tr>
                                                        <td>sdg</td>
                                                        <td>dsfg</td>
                                                    </tr>
                                                    <tr>
                                                        <td>sdfg</td>
                                                        <td>dfg</td>
                                                    </tr>
                                                    <tr class="success">
                                                        <td>dsfg</td>
                                                        <td>dfg</td>
                                                    </tr>
                                                    <tr>
                                                        <td>dfgh</td>
                                                        <td>dfh</td>
                                                    </tr>
                                                    <tr>
                                                        <td>dfgh</td>
                                                        <td>dfhg</td>
                                                    </tr>
                                                    <tr>
                                                        <td>ddfghdfgh</td>
                                                        <td>dfh</td>
                                                    </tr>
                                                    <tr>
                                                        <td>dfh</td>
                                                        <td>ddfhdh</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--BEGIN LATEST COMMENT-->
                            <!-- .row-fluid -->
                            <div class="row-fluid">
                                <!-- .span6 -->
                                <div class="span6">
                                    <!-- .box -->
                                    <div class="box comments">
                                        <header>
                                            <div class="icons">
                                                <i class="icon-comments"></i>
                                            </div>
                                            <h5>Latest Comment</h5>
                                        </header>
                                        <!-- .body -->
                                        <div class="body">
                                            <div class="media">
                                                <a href="#" class="pull-left">
                                                    <img data-src="holder.js/64x64" class="media-object" alt="64x64" style="width: 64px; height: 64px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAACGklEQVR4nO2V0XKaUBRF8/+fckREJSYmirY2HWtJBxMnMtV2qCGFoL2/sPsAdRKjD62Q3WnPw3qBM2eWiwueGGPwP3PCFmCjAdgCbDQAW4CNBmALsNEAbAE2GoAtwEYDsAXYaAC2ABsNwBZgowHYAmw0AFuAjQZgC7DRAGwBNn8cYL28xsCtQ0QKOgiS5zObxQiN4n5zvPqr9h8VYB0OYYvA9m5xf2hu/RlvHAt2/fcFq95/ZIAVxi2BSBezx0Mza4RDG1bXx81b55lgNvdgiUA613gwBiadoisCkQvcJMfvrz7AwyecikDEQtOx8uNpuRgG0XYmmw9gSRPjVYboaldwg3CYH+1zP0RwKRCpoTdLS9pfdYDoPZzivXMnEYz5Bt/NhfvzDCa7g2cJar0ZHo3ZL7hZYNSQ7ftt9e+Qlbm/0gDxBG0RiLTw4T6/Fn908x/iLZFMzyDS3t47JBj7bhHAwVVU/v7qAvxYYGDtF6wPvyIJzp58uXfoBEiMgUlv0as9vV58D8raX2kAYxBP3D1H1MG7Ly9nXz6hBNOL/Eh7swjhqAERwakfl7T/FQIYs8HS76P16yk2LzEO072zu4Lfg3OI5O9wakz+d2YLRNoYR8fvf6UA/w4agC3ARgOwBdhoALYAGw3AFmCjAdgCbDQAW4CNBmALsNEAbAE2GoAtwEYDsAXYaAC2ABsNwBZgowHYAmw0AFuAzU+QYREQ9dxBOwAAAABJRU5ErkJggg==">
                                                </a>
                                                <div class="media-body">
                                                    <div class="popover right">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">Popover right</h3>
                                                        <div class="popover-content">
                                                            <p>Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="media">
                                                <a href="#" class="pull-right">
                                                    <img data-src="holder.js/64x64" class="media-object" alt="64x64" style="width: 64px; height: 64px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAACGklEQVR4nO2V0XKaUBRF8/+fckREJSYmirY2HWtJBxMnMtV2qCGFoL2/sPsAdRKjD62Q3WnPw3qBM2eWiwueGGPwP3PCFmCjAdgCbDQAW4CNBmALsNEAbAE2GoAtwEYDsAXYaAC2ABsNwBZgowHYAmw0AFuAjQZgC7DRAGwBNn8cYL28xsCtQ0QKOgiS5zObxQiN4n5zvPqr9h8VYB0OYYvA9m5xf2hu/RlvHAt2/fcFq95/ZIAVxi2BSBezx0Mza4RDG1bXx81b55lgNvdgiUA613gwBiadoisCkQvcJMfvrz7AwyecikDEQtOx8uNpuRgG0XYmmw9gSRPjVYboaldwg3CYH+1zP0RwKRCpoTdLS9pfdYDoPZzivXMnEYz5Bt/NhfvzDCa7g2cJar0ZHo3ZL7hZYNSQ7ftt9e+Qlbm/0gDxBG0RiLTw4T6/Fn908x/iLZFMzyDS3t47JBj7bhHAwVVU/v7qAvxYYGDtF6wPvyIJzp58uXfoBEiMgUlv0as9vV58D8raX2kAYxBP3D1H1MG7Ly9nXz6hBNOL/Eh7swjhqAERwakfl7T/FQIYs8HS76P16yk2LzEO072zu4Lfg3OI5O9wakz+d2YLRNoYR8fvf6UA/w4agC3ARgOwBdhoALYAGw3AFmCjAdgCbDQAW4CNBmALsNEAbAE2GoAtwEYDsAXYaAC2ABsNwBZgowHYAmw0AFuAzU+QYREQ9dxBOwAAAABJRU5ErkJggg==">
                                                </a>
                                                <div class="media-body">
                                                    <div class="popover left">
                                                        <div class="arrow"></div>
                                                        <h3 class="popover-title">Popover right</h3>
                                                        <div class="popover-content">
                                                            <p>Sed posuere consectetur est at lobortis. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- /.body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                                <!-- /.span6 -->
                                <!-- .span6 -->
                                <div class="span6">
                                    <!-- .box -->
                                    <div class="box">
                                        <header></header>
                                        <!-- .body -->
                                        <div class="body"></div>
                                        <!-- /.body -->
                                    </div>
                                    <!-- /.box -->
                                </div>
                                <!-- /.span6 -->
                            </div>
                            <!-- /.row-fluid -->
                            <!--END LATEST COMMENT-->
                        </div>
                        <!-- /.inner -->
                    </div>
                    <!-- /.row-fluid -->
                </div>
                <!-- /.outer -->
            </div>
            <!-- END CONTENT -->
			</form>

            <!-- #push do not remove -->
            <div id="push"></div>
            <!-- /#push -->
        </div>
        <!-- END WRAP -->

        <div class="clearfix"></div>
	  	<%@  include  file="bottom.jsp" %>
         
		<script src="assets/js/vendor/jquery-1.9.1.min.js"></script>

        <script src="assets/js/vendor/jquery-migrate-1.1.1.min.js"></script>
		<script src="assets/js/vendor/jquery-ui-1.10.0.custom.min.js"></script>
    <!--      <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min.js"></script>
        <script>window.jQuery.ui || document.write('')</script>-->

 
        <script src="assets/js/vendor/bootstrap.min.js"></script>

        <script src="assets/js/lib/jquery.tablesorter.min.js"></script>

        <script src="assets/js/lib/jquery.mousewheel.js"></script>
        <script src="assets/js/lib/jquery.sparkline.min.js"></script>
        <script src="assets/js/lib/flot/jquery.flot.js"></script>
        <script src="assets/js/lib/flot/jquery.flot.pie.js"></script>
        <script src="assets/js/lib/flot/jquery.flot.selection.js"></script>
        <script src="assets/js/lib/flot/jquery.flot.resize.js"></script>
        <script src="assets/js/lib/fullcalendar.min.js"></script>

       <script src="assets/js/main.js"></script>
          
      <script type="text/javascript">
            $(function() {
                dashboard();
            });
        </script>
      <script type="text/javascript" src="assets/js/style-switcher.js"></script> 
        
    </body>
</html>


















 
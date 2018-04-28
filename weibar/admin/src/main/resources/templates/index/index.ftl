<!DOCTYPE html>

<html>
<#include "../common/head.ftl">
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<#include "../common/navbar.ftl">
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <#include "${userMenuFtl}">
    <!-- BEGIN PAGE -->
    <div class="page-content">

        <!-- BEGIN PAGE CONTAINER-->
        <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
                <div class="span12">
                    <h3 class="page-title">
                        首页
                        <small>首页</small>
                    </h3>
                </div>
            </div>
            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box blue">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>首页</div>

                            <div class="actions">

                                <div class="btn-group">

                                </div>

                            </div>

                        </div>
                        <div class="portlet-body">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END PAGE CONTAINER-->
    </div>
    <!-- END PAGE -->
</div>
<!-- END CONTAINER -->

<#include "../common/footer.ftl">
<script src="media/js/app.js" type="text/javascript"></script>
<script src="media/js/index.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
    jQuery(document).ready(function () {

        App.init(); // initlayout and core plugins

        Index.init();

        Index.initJQVMAP(); // init index page's custom scripts

        Index.initCalendar(); // init index page's custom scripts

        Index.initCharts(); // init index page's custom scripts

        Index.initChat();

        Index.initMiniCharts();

        Index.initDashboardDaterange();

        Index.initIntro();

    });
</script>
</body>
<!-- END BODY -->
</html>
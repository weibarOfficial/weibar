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
                        收入管理
                        <small>收入总览</small>
                    </h3>
                </div>
            </div>
            <!-- END PAGE HEADER-->
            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box blue">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>收入总览</div>

                            <div class="actions">

                                <div class="btn-group">
                                    <!--
                                    <a class="btn" href="#" data-toggle="dropdown">

                                        Columns

                                        <i class="icon-angle-down"></i>

                                    </a>
                                    -->
                                    <!--
                                    <div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">

                                        <label><input type="checkbox" checked data-column="0">Rendering engine</label>

                                        <label><input type="checkbox" checked data-column="1">Browser</label>

                                        <label><input type="checkbox" checked data-column="2">Platform(s)</label>

                                        <label><input type="checkbox" checked data-column="3">Engine version</label>

                                        <label><input type="checkbox" checked data-column="4">CSS grade</label>

                                    </div>
                                    -->
                                </div>

                            </div>

                        </div>

                        <div class="portlet-body">

                            <table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
                                <thead>
                                <tr>
                                    <th>日期</th>
                                    <th>收入</th>
                                    <th class="hidden-480">消费人次</th>
                                    <th class="hidden-480">人均付费（次）</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list mIncomes as income>
                                <tr>
                                    <td>${income.createTime}</td>
                                    <td>${income.income}</td>
                                    <td >${income.people}</td>
                                    <td >${income.perConsume}</td>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE PORTLET-->

                </div>

            </div>
        </div>
        <!-- END PAGE CONTAINER-->
    </div>
    <!-- END PAGE -->
</div>
<!-- END CONTAINER -->

<#include "../common/footer.ftl">
<script type="text/javascript" src="media/js/select2.min.js"></script>
<script type="text/javascript" src="media/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>
<script src="media/js/app.js"></script>
<script src="media/js/table-advanced.js"></script>

<script>
    jQuery(document).ready(function () {
        App.init(); // initlayout and core plugins
        TableAdvanced.init();
    });
</script>
</body>
<!-- END BODY -->
</html>
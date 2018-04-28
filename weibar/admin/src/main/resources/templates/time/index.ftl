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


        <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

        <div id="portlet-config" class="modal hide">

            <div class="modal-header">

                <button data-dismiss="modal" class="close" type="button"></button>

                <h3>打赏配置</h3>

            </div>

            <div class="modal-body">

                <div class="tab-content">

                    <div class="tab-pane active" id="portlet_tab1">

                        <!-- BEGIN FORM-->

                        <form action="#" class="form-horizontal">

                            <input type="hidden" id="timeId" value="" />

                            <div class="control-group">

                                <label class="control-label">修改价格</label>

                                <div class="controls">

                                    <input type="text" placeholder="不能为0" class="m-wrap medium" id="editTimePrice" value="" />

                                    <span class="help-inline">元</span>

                                </div>

                            </div>

                            <div class="form-actions">
                                <button  class="btn blue editButton"><i class="icon-ok"></i>修改</button>
                            </div>

                        </form>

                        <!-- END FORM-->

                    </div>

                </div>

            </div>

        </div>

        <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->


        <!-- BEGIN PAGE CONTAINER-->
        <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
                <div class="span12">
                    <h3 class="page-title">
                        酒吧管理
                        <small>霸屏时长</small>
                    </h3>
                </div>
            </div>
            <!-- END PAGE HEADER-->
            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box blue">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>霸屏时长</div>

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

                                    <th>霸屏时长</th>
                                    <th>金额</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list mInfo as info>
                                <tr>
                                    <td>${info.timeDesc}</td>
                                    <td>${info.price}</td>
                                    <td><a href="#portlet-config" data-toggle="modal" data-timeId="${info.timeIdStr}" class="config editAmount">修改时长价格</a></td>

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

<script src="media/js/table-editable.js"></script>

<script>

    jQuery(document).ready(function () {
        App.init(); // initlayout and core plugins
        //Index.init();
        TableAdvanced.init();
    });



    $(".editAmount").click(function(){
        var timeId = $(this).attr("data-timeId");

        console.log("timeId is " + timeId);
        $.ajax({
            method: "POST",
            url: "/admin/getPriceTimeSettingInfo",
            data: { timeId: timeId }
        }).done(function( msg ) {
            console.log(msg);
            if(msg.code != 0){
                alert("错误码:" + msg.code + " " + msg.message);
                return;
            }
            $("#timeId").val(msg.data.timeIdStr);
            $("#editTimePrice").val(msg.data.priceStr);

        });
    });

    $(".editButton").click(function(){
        console.log($(this).parent().parent().find("#timeId").val());
        console.log($(this).parent().parent().find("#editTimePrice").val());
        var timeId = $(this).parent().parent().find("#timeId").val();
        var editTimePrice = $(this).parent().parent().find("#editTimePrice").val();
        $.ajax({
            method: "POST",
            url: "/admin/updatePriceTimeSettingInfo",
            data: {
                timeId: timeId,
                timePrice:editTimePrice
            }
        }).done(function( msg ) {
            console.log(msg);
            if(msg.code != 0){
                alert("错误码:" + msg.code + " " + msg.message);
                location.reload();
                return;
            }else{
                alert("修改成功");
                location.reload();
                return;
            }
        });
    });




</script>
</body>
<!-- END BODY -->
</html>
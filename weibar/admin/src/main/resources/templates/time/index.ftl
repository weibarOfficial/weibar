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

                <h3>修改价格</h3>

            </div>

            <div class="modal-body">

                <div class="tab-content">

                    <div class="tab-pane active" id="portlet_tab1">

                        <!-- BEGIN FORM-->

                        <form action="#" class="form-horizontal">

                            <input type="hidden" id="goodsId" value="" />

                            <div class="control-group">

                                <label class="control-label">修改价格</label>

                                <div class="controls">

                                    <input type="text" placeholder="不能为0" class="m-wrap medium" id="editGoodsPrice" value="" />

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
                        <small>商品信息</small>
                    </h3>
                </div>
            </div>
            <!-- END PAGE HEADER-->
            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box blue">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>查看商户</div>

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
                                    <th>商品ID</th>
                                    <th>商品名称</th>
                                    <th>商品图片</th>
                                    <th>商品金额</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list mInfo as info>
                                <tr>
                                    <td>${info.goodsIdStr}</td>
                                    <td>${info.goodsName}</td>
                                    <td ><img src="${info.goodsImgUrl}"  alt="" width="100px" height="100px" /></td>
                                    <td>${info.goodsAmountStr}</td>
                                    <td><a href="#portlet-config" data-toggle="modal" data-goodsId="${info.goodsIdStr}" class="config editAmount">修改商品价格</a></td>

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
<script src="media/js/app.js" type="text/javascript"></script>
<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="media/js/bootstrap.min.js" type="text/javascript"></script>
<script src="media/js/excanvas.min.js"></script>
<script src="media/js/respond.min.js"></script>
<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>
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
        var goodsId = $(this).attr("data-goodsId");

        console.log("goodsId is " + goodsId);
        $.ajax({
            method: "POST",
            url: "/admin/getGoodsSettingInfoById",
            data: { goodsId: goodsId }
        }).done(function( msg ) {
            console.log(msg);
            if(msg.code != 0){
                alert("错误码:" + msg.code + " " + msg.message);
                return;
            }
            $("#goodsId").val(msg.data.goodsId);
            $("#editGoodsPrice").val(msg.data.goodsAmountStr);
            //$("#portlet-config").removeClass("hide");
        });
    });

    $(".editButton").click(function(){
        console.log($(this).parent().parent().find("#goodsId").val());
        console.log($(this).parent().parent().find("#editGoodsPrice").val());
        var goodsId = $(this).parent().parent().find("#goodsId").val();
        var editGoodsPrice = $(this).parent().parent().find("#editGoodsPrice").val();
        $.ajax({
            method: "POST",
            url: "/admin/updateGoodsPrice",
            data: {
                goodsId: goodsId,
                goodsPrice:editGoodsPrice
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
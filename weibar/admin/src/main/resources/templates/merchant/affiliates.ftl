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

                <h3>修改分成比例</h3>

            </div>

            <div class="modal-body">

                <div class="tab-content">

                    <div class="tab-pane active" id="portlet_tab1">

                        <!-- BEGIN FORM-->

                        <form action="#" class="form-horizontal">

                            <input type="hidden" id="editAffiliateId" value="" />

                            <div class="control-group">

                                <label class="control-label">霸屏分成比例</label>

                                <div class="controls">

                                    <input type="text" placeholder="最高精确到0.1%" class="m-wrap medium" id="editSharingRatioBarpin" value="" />

                                    <span class="help-inline">%</span>

                                </div>

                            </div>
                            <div class="control-group">

                                <label class="control-label">红包分成比例</label>

                                <div class="controls">

                                    <input type="text" placeholder="最高精确到0.1%" class="m-wrap medium" id="editSharingRatioRedp" value="" />

                                    <span class="help-inline">%</span>

                                </div>

                            </div>
                            <div class="control-group">

                                <label class="control-label">打赏分成比例</label>

                                <div class="controls">

                                    <input type="text" placeholder="最高精确到0.1%" class="m-wrap medium" id="editSharingRatioGive" value="" />

                                    <span class="help-inline">%</span>

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
                        商户管理
                        <small>下属商户</small>
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
                                    <th>商户ID</th>
                                    <th>商户名称</th>
                                    <th>商户二维码</th>
                                    <th>角色</th>
                                    <th>霸屏分成比例</th>
                                    <th >红包分成比例</th>
                                    <th>打赏分成比例</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list mAffs as aff>
                                <tr>
                                    <td>${aff.merchantIdStr}</td>
                                    <td>${aff.name}</td>
                                    <td ><img src="${aff.QRCodeUrl}"  alt="" width="100px" height="100px" /></td>
                                    <td>${aff.roleStr}</td>
                                    <td>${aff.sharingRatioBarpinStr}</td>
                                    <td>${aff.sharingRatioRedpStr}</td>
                                    <td>${aff.sharingRatioGiveStr}</td>


                                    <td><a href="#portlet-config" data-toggle="modal" data-merchantid="${aff.merchantIdStr}" class="config editShare">修改分成比例</a></td>

                                </tr>
                                </#list>
                                </tbody>
                            </table>


                            <!--
                            <table class="table table-striped table-hover table-bordered" id="sample_editable_1">
                                <thead>
                                <tr>
                                    <th>商户ID</th>
                                    <th>商户名称</th>
                                    <th>商户二维码</th>
                                    <th>角色</th>
                                    <th>霸屏分成比例</th>
                                    <th >红包分成比例</th>
                                    <th>打赏分成比例</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list mAffs as aff>


                                <tr class="">

                                    <td>${aff.merchantIdStr}</td>
                                    <td>${aff.name}</td>
                                    <td ><img src="${aff.QRCodeUrl}"  alt="" width="100px" height="100px" /></td>
                                    <td>${aff.roleStr}</td>
                                    <td>${aff.sharingRatioBarpinStr}</td>
                                    <td>${aff.sharingRatioRedpStr}</td>
                                    <td>${aff.sharingRatioGiveStr}</td>

                                    <td><a class="edit" href="javascript:;">Edit</a></td>

                                    <td><a class="delete" href="javascript:;">Delete</a></td>

                                </tr>
                                </#list>
                                </tbody>



                            </table>
                            -->
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
        Index.init();
        TableAdvanced.init();
    });



    $(".editShare").click(function(){
        var merchantid = $(this).data("merchantid");

        $.ajax({
          method: "POST",
          url: "/admin/getAffiliateById",
          data: { affiliateId: merchantid }
        }).done(function( msg ) {
          console.log(msg);
          if(msg.code != 0){
            alert("错误码:" + msg.code + " " + msg.message);
            return;
          }
          $("#editSharingRatioBarpin").val(msg.data.sharingRatioBarpin/10.0);
          $("#editSharingRatioGive").val(msg.data.sharingRatioGive/10.0);
          $("#editSharingRatioRedp").val(msg.data.sharingRatioRedp/10.0);
          $("#editAffiliateId").val(merchantid);
          
        });
    });

    $(".editButton").click(function(){
      console.log($(this).parent().parent().find("#editAffiliateId").val());
      console.log($(this).parent().parent().find("#editSharingRatioBarpin").val());
      var affiliateId = $(this).parent().parent().find("#editAffiliateId").val();
      var sharingRatioBarpin = Math.floor($(this).parent().parent().find("#editSharingRatioBarpin").val() * 10);
      var sharingRatioGive = Math.floor($(this).parent().parent().find("#editSharingRatioGive").val()* 10);
      var sharingRatioRedp = Math.floor($(this).parent().parent().find("#editSharingRatioRedp").val()* 10);
      $.ajax({
          method: "POST",
          url: "/admin/editAffiliateShareRatio",
          data: {
           affiliateId: affiliateId,
           sharingRatioBarpin:sharingRatioBarpin,
           sharingRatioGive:sharingRatioGive,
           sharingRatioRedp:sharingRatioRedp
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
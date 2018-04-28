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
                        商户管理
                        <small>修改密码</small>
                    </h3>
                </div>
            </div>
            <!-- END PAGE HEADER-->
            <div class="row-fluid">

                <div class="span12">

                    <!-- BEGIN EXAMPLE TABLE PORTLET-->

                    <div class="portlet box blue">

                        <div class="portlet-title">

                            <div class="caption"><i class="icon-globe"></i>修改密码</div>

                            <div class="actions">

                                <div class="btn-group">

                                </div>

                            </div>

                        </div>
                        <div class="portlet-body">
                            <div class="tab-content table-full-width">
                                <div class="tab-pane active" id="portlet_tab1">
                                    <form action="#" class="form-horizontal">
                                        <div class="control-group">
                                            <label class="control-label">商户ID</label>
                                            <div class="controls">
                                                <input class="m-wrap medium" type="text" value="${mInfo.merchantIdStr}" disabled />
                                                <span class="help-inline">商户在秉烛公司的唯一ID</span>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">商户名称</label>
                                            <div class="controls">
                                                <input class="m-wrap medium" type="text" value="${mInfo.name}" disabled />
                                                <span class="help-inline"></span>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">登录名</label>
                                            <div class="controls">
                                                <input class="m-wrap medium" type="text" value="${mInfo.loginName}" disabled />
                                                <span class="help-inline">用于登录后台系统使用</span>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">原密码</label>
                                            <div class="controls">
                                                <input class="m-wrap medium" id="oldPwd" type="password" value=""  />
                                                <span class="help-inline"></span>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">新密码</label>
                                            <div class="controls">
                                                <input class="m-wrap medium" id="newPwd" type="password" value=""/>
                                                <span class="help-inline"></span>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label">再输新密码</label>
                                            <div class="controls">
                                                <input class="m-wrap medium" id="newPwdConfirm" type="password" value="" />
                                                <span class="help-inline"></span>
                                            </div>
                                        </div>



                                        <div class="form-actions">

                                            <button type="submit" class="btn blue" id="btnModifyPwd"><i class="icon-ok"></i> 修改密码</button>

                                            <!-- <button type="button" class="btn">Cancel</button> -->

                                        </div>
                                    </form>
                                </div>
                            </div>
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
<script src="media/js/app.js"></script>
<script src="media/js/index.js" type="text/javascript"></script>
<script>

    jQuery(document).ready(function () {
        App.init(); // initlayout and core plugins
        //TableAdvanced.init();

        Index.init();
    });




    $("#btnModifyPwd").click(function(){

        var oldPwd = $("#oldPwd").val();
        var newPwd = $("#newPwd").val();
        var newPwdConfirm = $("#newPwdConfirm").val();
        $.ajax({
            method: "POST",
            url: "/admin/modifyPwd",
            data: {
                oldPwd: oldPwd,
                newPwd: newPwd,
                newPwdConfirm:newPwdConfirm
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
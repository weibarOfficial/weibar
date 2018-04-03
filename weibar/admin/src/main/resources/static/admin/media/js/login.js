var Login = function () {

    return {
        //main function to initiate the module
        init: function () {

            $("#btnLogin").click(function (e) {
                e.preventDefault();
                //$('.alert-error', $('.login-form')).show();
                //window.location.href = "index.html";
                $.post("/admin/verifyPwd", {
                    loginName: $("#loginUserName").val(),
                    pwd: $("#loginPwd").val()
                }, function (result) {
                    console.log(result);
                    if (result.code == 0) {
                        window.location.href = "index.html";
                    } else {
                        alert(result.message);
                    }

                });
            });


            $("#regBtn").click(function (e) {
                console.log("role " + $("#roleId").val());
                $.post("/admin/createMerchant",
                    {
                        loginName: $("#regUsername").val(),
                        pwd: $("#regPassword").val(),
                        name: $("#regName").val(),
                        parentMerchantId: $("#regParentId").val(),
                        roleId: $("#roleId").val()
                    },
                    function (result) {
                        console.log(result);
                        if (result.code == 0) {
                            alert("注册成功，请登录");
                            window.location.href = "login.html";
                        } else {
                            alert(result.message);
                        }
                    });
                e.preventDefault();
            });


            $('.login-form').validate({
                errorElement: 'label', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true
                    },
                    remember: {
                        required: false
                    }
                },

                messages: {
                    username: {
                        required: "请输入用户名"
                    },
                    password: {
                        required: "请输入密码"
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit
                    $('.alert-error', $('.login-form')).show();
                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.control-group').addClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label.closest('.control-group').removeClass('error');
                    label.remove();
                },

                errorPlacement: function (error, element) {
                    error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
                },

                submitHandler: function (form) {
                }
            });

            $('.register-form').validate({
                errorElement: 'label', //default input error message container
                errorClass: 'help-inline', // default input error message class
                focusInvalid: false, // do not focus the last invalid input
                ignore: "",
                rules: {
                    username: {
                        required: true
                    },
                    password: {
                        required: true
                    },
                    rpassword: {
                        equalTo: "#regPassword"
                    },
                    regName: {
                        required: true
                    },
                    regParentId: {
                        required: true
                    }
                },

                messages: { // custom messages for radio buttons and checkboxes
                    username: {
                        required: "请输入用户名"
                    },
                    password: {
                        required: "请输入密码"
                    },
                    rpassword: {
                        equalTo: "两次输入密码必须一致"
                    },
                    regName: {
                        required: "请输入用户显示名"
                    },
                    regParentId: {
                        required: "请输入推荐人ID"
                    }
                },

                invalidHandler: function (event, validator) { //display error alert on form submit

                },

                highlight: function (element) { // hightlight error inputs
                    $(element)
                        .closest('.control-group').addClass('error'); // set error class to the control group
                },

                success: function (label) {
                    label.closest('.control-group').removeClass('error');
                    label.remove();
                },

                errorPlacement: function (error, element) {
                    if (element.attr("name") == "tnc") { // insert checkbox errors after the container
                        error.addClass('help-small no-left-padding').insertAfter($('#register_tnc_error'));
                    } else {
                        error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
                    }
                },

                submitHandler: function (form) {
                    //window.location.href = "index.html";
                }
            });

            $('.login-form input').keypress(function (e) {
                if (e.which == 13) {
                    if ($('.login-form').validate().form()) {
                        window.location.href = "index.html";
                    }
                    return false;
                }
            });
            /** 暂时不用
             $('.forget-form').validate({
	            errorElement: 'label', //default input error message container
	            errorClass: 'help-inline', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                }
	            },

	            messages: {
	                email: {
	                    required: "Email is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.control-group').addClass('error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.control-group').removeClass('error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.addClass('help-small no-left-padding').insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                window.location.href = "index.html";
	            }
	        });
             */
            $('.forget-form input').keypress(function (e) {
                if (e.which == 13) {
                    if ($('.forget-form').validate().form()) {
                        window.location.href = "index.html";
                    }
                    return false;
                }
            });

            jQuery('#forget-password').click(function () {
                jQuery('.login-form').hide();
                jQuery('.forget-form').show();
            });

            jQuery('#back-btn').click(function () {
                jQuery('.login-form').show();
                jQuery('.forget-form').hide();
            });


            jQuery('#register-btn').click(function () {
                jQuery('.login-form').hide();
                jQuery('.register-form').show();
            });

            jQuery('#register-back-btn').click(function () {
                jQuery('.login-form').show();
                jQuery('.register-form').hide();
            });
        }

    };

}();
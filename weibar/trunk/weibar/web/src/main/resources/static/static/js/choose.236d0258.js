!function(e){function t(o){if(n[o])return n[o].exports;var i=n[o]={i:o,l:!1,exports:{}};return e[o].call(i.exports,i,i.exports,t),i.l=!0,i.exports}var n={};t.m=e,t.c=n,t.d=function(e,n,o){t.o(e,n)||Object.defineProperty(e,n,{configurable:!1,enumerable:!0,get:o})},t.n=function(e){var n=e&&e.__esModule?function(){return e.default}:function(){return e};return t.d(n,"a",n),n},t.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},t.p="//www.yylive.com/static/",t(t.s=25)}({1:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0}),window.App||(window.App={}),window.allImageUrl="./images/",window.Global={SESSION_KEY_WX_PAY:"SESSION_KEY_WX_PAY",allImageUrl:allImageUrl,API_BASE:"",WS_BASE:"http://120.79.15.148:8080",merchantId:App.Utils.urlParam("merchantId")||1,chatId:null,User:{nickname:"app测试",userId:"1511958518205",scopeLevel:3,sex:"男",userPicture:""},login:function(){return this.DEBUG?$.getJSON(Global.API_BASE+"/test/loginByOpenId",{openId:Global.openId}):Promise.resolve()},loadUserInfo:function(){return $.getJSON("/h5/getUserInfo").then(function(e){e&&0===e.code&&$.extend(Global.User,e.data)})},getChatId:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:Global.talkToId;return $.post("/h5/getChatId?toUserId="+e).then(function(e){if(e&&0===e.code)return Global.chatId=e.data,e.data;App.showInfo("获取chatId失败",!1)})}},App.errorTip=function(e){return function(t){App.showInfo(t&&t.message||e||"操作失败，请重试。",!1)}},/MicroMessenger/i.test(navigator.userAgent)||(Global.DEBUG=!0,Global.openId=App.Utils.urlParam("openId")||"ouc82xNQp2oQstpR6g9MD0Dtjupw"),t.default=window.Global},25:function(e,t,n){"use strict";n(1),$(function(){function e(e){return $.getJSON("/h5/getFunctionList",{merchantId:e})}function t(e){return $.getJSON("/h5/deleteLoginLog",{logId:e})}function n(){if(s&&r){var e=$(".page2");e.data("inited")||(e.data("inited",!0),e.append(template("historyTpl",r)),l.left("cy_box"))}}function o(e){e.forEach(function(e){e._timeStr=App.Utils.fmDate(e.lastLogInTime)})}function i(e){showInfo(e&&e.message||"数据加载失败",!1)}function a(){$.getJSON("/h5/getAllMerchants").then(function(e){if(e&&0===e.code&&e.data&&e.data.length){var t=template("merchantTpl",e.data);$(".page1").prepend(t)}})}var l={left:function(e){$("."+e).on("swipeleft",function(e){$(this).find(".infoBox").addClass("delClass"),$(this).find(".delImg").fadeIn(600),l.right("cy_box")})},right:function(e){$("."+e).on("swiperight",function(e){$(this).find(".infoBox").removeClass("delClass"),$(this).find(".delImg").fadeOut(200)})}},r=null,s=!1;(function(){return $.getJSON("/h5/getLoginLog")})().then(function(t){if(t&&0===t.code){if(!(r=t.data)||!r.length)return $(".noData").removeClass("f-none"),void a();o(r),$(".loadMore").addClass("f-none"),$(".page1").append(template("latestTpl",r[0])),e(r[0].merchantId).then(function(e){e&&0===e.code?$(".page1").append(template("gamesTpl",e)):i(e)},i)}else i(t)},i).always(function(){s=!0}),$(".allMain").css({minHeight:$(window).height()-$(".copy")[0].offsetHeight}),$(".copy").css({visibility:"visible"}),function(){$(".barHead").on("click",".j_tab_item",function(){var e=$(this);if(!e.hasClass("sel")){e.addClass("sel").siblings().removeClass("sel");var t=e.index()+1;$(".j_tab_content").hide(),$(".page"+t).show(),t>1&&n()}}),$(".page2").on("click",".j_del",function(){var e=$(this),n=e.attr("logId");WM.Phone.get({type:"confirm",title:"删除足迹",innerHTML:"确定删除此足迹？",click:function(o){var i=this;if(!o)return this.close();t(n).then(function(){showInfo("删除成功"),i.close(),e.closest(".cy_box").remove()},function(){showInfo("删除失败")})}})}),$(window).bind("resize",function(){$(".allMain").css({minHeight:$(window).height()-$(".copy")[0].offsetHeight})})}()})}});
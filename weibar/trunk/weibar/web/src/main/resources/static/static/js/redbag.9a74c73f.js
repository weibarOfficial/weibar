!function(t){function e(i){if(n[i])return n[i].exports;var o=n[i]={i:i,l:!1,exports:{}};return t[i].call(o.exports,o,o.exports,e),o.l=!0,o.exports}var n={};e.m=t,e.c=n,e.d=function(t,n,i){e.o(t,n)||Object.defineProperty(t,n,{configurable:!1,enumerable:!0,get:i})},e.n=function(t){var n=t&&t.__esModule?function(){return t.default}:function(){return t};return e.d(n,"a",n),n},e.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},e.p="//www.yylive.com/static/",e(e.s=22)}({22:function(t,e,n){"use strict";$(function(){template.defaults.imports.dateFormat=App.Utils.fmDate,{init:function(){var t=this;this.loadData().then(function(e){t.createDom(e)})},initEvent:function(){var t=function(){$(".wm_main").css({minHeight:$(window).height()-30-$(".copyNormal")[0].offsetHeight}),$(".copyNormal").css({visibility:"visible"})};$(".look").on("click",function(){$(".detailRed").slideToggle()}),$(".onWall_redBagDetailHead").on("load",t)},createDom:function(t){var e=template("pageTpl",t);$(".wm_main").append(e),this.initEvent()},loadData:function(){var t=App.Utils.urlParam();return $.getJSON("/h5/getRedPackageList",{redPackageId:t.rbid}).then(function(t){if(t&&0===t.code)return t.data},function(t){App.showInfo(t&&t.message||"红包详情获取失败",!1)})}}.init()})}});
// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    app: getApp(),
    tomorrowDakaMoney: "未知",
    suceessDaka: "未知",
    failDaka: "未知"
  },
  


  inviteFriends:function(){
    wx.showShareMenu({
      withShareTicket: true
    })
  },


  payForDaka:function(){
    var sessionKey = null;
    var that = this.data;
    wx.getStorage({
      key: 'sessionKey',
      success : function(res){
        
        wx.request({
          url: that.app.BASE_URL + "/daka/pay",
          method: "GET",
          dataType: "json",
          data: {
            sessionKey: res.data,
            amount: 0.01
          },
          success: function (res) {
            console.log(res);
            if (res.data.code != 0) {
              wx.showModal({
                content: '打卡下单失败:' + res.data.message,
                showCancel: false
              });
            } else {
              console.log("打卡下单成功");
              console.log(res.data);
              var wxPayMpOrderResult = res.data.data.wechatPrePay.wxPayMpOrderResult;
              console.log(wxPayMpOrderResult);
              wx.requestPayment(
                {
                  'timeStamp': wxPayMpOrderResult.timeStamp,
                  'nonceStr': wxPayMpOrderResult.nonceStr,
                  'package': wxPayMpOrderResult.packageValue,
                  'signType': 'MD5',
                  'paySign': wxPayMpOrderResult.paySign,
                  'success': function (res) {
                    console.log("调用微信支付成功");
                    console.log(res);
                   },
                  'fail': function (res) { 
                    console.log("调用微信支付失败");
                    console.log(res);

                  },
                  'complete': function (res) { 
                    console.log("调用微信支付结束");
                    console.log(res);
                    this.refresh();
                  }
                })
            }
          }
        })
      }
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.refresh();
  },


  refresh: function(){
    var that = this;
    wx.getStorage({
      key: 'sessionKey',
      success: function(res) {
        wx.request({
          url: that.data.app.BASE_URL + "/daka/getIndexSummary",
          data:{
            'sessionKey': res.data
          },
          method: "GET",
          dataType: "json",
          success: function (res) {
            console.log("获取首页详情信息");
            console.log(res);
            if (res.data.code != 0) {
              wx.showModal({
                content: '获取首页详情信息失败' + res.data.message,
                showCancel: false,
                success: function (res) {
                }
              });
            } else {

              that.setData({
                tomorrowDakaMoney: res.data.data.tomorrowSummary.payAmount,
                suceessDaka: res.data.data.todaySummary.scount,
                failDaka: res.data.data.todaySummary.fcount
              })
            }

          }
        });
      }
    })
    
  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})
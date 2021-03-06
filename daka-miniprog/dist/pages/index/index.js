// pages/index/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    app: getApp(),
    tomorrowDakaMoney: "未知",
    suceessDaka: "未知",
    failDaka: "未知",
    buttonText:"报名参与打卡",
    buttonBindtap: "payForDaka",
    buttondisabled: "false",
    earlyUserPicture:"",
    luckyUserPicture: "",
    gutsUserPicture: "",
    earlyUserName:"",
    earlyTime:"",
    luckyUserName:"",
    luckyAmount:"",
    gutsUserName:"",
    gutsCount:"",
    gameRuleUrl:"/pages/article/articleFree",
    marqueeText:""


  },
  


  inviteFriends:function(){
    wx.showShareMenu({
      withShareTicket: true
    })
  },



  daka: function () {
    var that = this.data;
    wx.getStorage({
      key: 'sessionKey',
      success: function (res) {
        wx.request({
          url: that.app.BASE_URL + "/daka/daka",
          method: "GET",
          dataType: "json",
          data: {
            sessionKey: res.data
          },
          success: function (res) {
            console.log("打卡返回信息");
            console.log(res);
            if (res.data.code != 0) {
              wx.showModal({
                content:  res.data.message,
                showCancel: false
              });
            } else {
              wx.showModal({
                content: '打卡成功！稍后将瓜分奖金',
                showCancel: false,
                success : function(){
                  that.refresh();
                }
              });
            }
            that.refresh();
          }
        })
      }
    });
  },


  freeForDaka:function(){
    var sessionKey = null;
    var that = this;
    var thatData = this.data;
    wx.getStorage({
      key: 'sessionKey',
      success: function (res) {

        wx.request({
          url: thatData.app.BASE_URL + "/daka/payForFree",
          method: "GET",
          dataType: "json",
          data: {
            sessionKey: res.data
          },
          success: function (res) {
            console.log(res);
            if (res.data.code != 0) {
              wx.showModal({
                content: '报名打卡下单失败:' + res.data.message,
                showCancel: false
              });
            } else {
              console.log("免费打卡下单成功");
              wx.showModal({
                content: '打卡报名成功！明早记得5-8点前打卡哦~',
                showCancel: false
              });
              
              console.log(res.data);

            }
            that.refresh();
          }

        })
      }
    });
  },


  payForDaka:function(){
    var sessionKey = null;
    var that = this;
    var thatData = this.data;
    wx.getStorage({
      key: 'sessionKey',
      success : function(res){
        
        wx.request({
          url: thatData.app.BASE_URL + "/daka/pay",
          method: "GET",
          dataType: "json",
          data: {
            sessionKey: res.data,
            amount: 1
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
                    that.refresh();
                   },
                  'fail': function (res) { 
                    console.log("调用微信支付失败");
                    console.log(res);
                    that.refresh();

                  },
                  'complete': function (res) { 
                    console.log("调用微信支付结束");
                    console.log(res);
                    that.refresh();
                    
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

    var that = this;
    setTimeout(function () {
      that.refresh(); 
    }, 1000);
    
  },


  refresh: function(){
    console.log("come in refresh");
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
              var earlyTimeStr;
              var earlyUserNameStr;
              if (res.data.data.todaySummary.earlyTime){
                earlyTimeStr = "今日" + res.data.data.todaySummary.earlyTime + "打卡";
                earlyUserNameStr = res.data.data.todaySummary.earlyUserName;
              }else{
                earlyUserNameStr = "虚以待位";
                earlyTimeStr = "";
              }
              var luckyAmountStr;
              var luckyUserNameStr;
              if (res.data.data.todaySummary.luckyAmount){
                luckyAmountStr = "获得" + res.data.data.todaySummary.luckyAmount + "元";
                luckyUserNameStr = res.data.data.todaySummary.luckyUserName;
              }else{
                luckyUserNameStr = "虚以待位";
                luckyAmountStr = "";
              }

              var gutsCountStr;
              var gutsUserNameStr;
              if (res.data.data.todaySummary.gutsCount) {
                gutsCountStr = "累计打卡" + res.data.data.todaySummary.gutsCount + "次";
                gutsUserNameStr = res.data.data.todaySummary.gutsUserName;
              } else {
                gutsUserNameStr = "虚以待位";
                gutsCountStr = "";
              } 



              that.setData({
                tomorrowDakaMoney: res.data.data.tomorrowSummary.payAmount,
                suceessDaka: res.data.data.todaySummary.scount,
                failDaka: res.data.data.todaySummary.fcount,
                earlyUserPicture: res.data.data.todaySummary.earlyUserPicture,
                luckyUserPicture: res.data.data.todaySummary.luckyUserPicture,
                gutsUserPicture: res.data.data.todaySummary.gutsUserPicture,
                earlyUserName: earlyUserNameStr,
                earlyTime: earlyTimeStr,
                luckyUserName: luckyUserNameStr,
                luckyAmount: luckyAmountStr,
                gutsUserName: gutsUserNameStr,
                gutsCount: gutsCountStr
              })
            }

          }
        });
        wx.request({
          url: that.data.app.BASE_URL + "/daka/getUserInfo",
          data: {
            'sessionKey': res.data
          },
          method: "GET",
          dataType: "json",
          success: function (res) {
            console.log("获取用户信息");
            console.log(res);
            if (res.data.code != 0) {
              wx.showModal({
                content: '获取用户信息失败' + res.data.message,
                showCancel: false,
                success: function (res) {
                }
              });
            } else {


              that.setData({
                buttonText: res.data.data.dakaText,
                buttonBindtap: res.data.data.dakaBindTap,
                buttondisabled: res.data.data.dakaDisabled
              });

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
    var that = this;
    for(var i = 0; i < 10; i++){
      setTimeout(function () {
        that.refresh();
      }, 500 + i * 500);
    }
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
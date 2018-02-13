// pages/my/my.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    app: getApp(),
    allPay: "未知",
    allGet: "未知",
    allSucDaka: "未知",
    dakaDetails: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {


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
    wx.getStorage({
      key: 'sessionKey',
      success: function (res) {
        wx.request({
          url: that.data.app.BASE_URL + "/daka/getDakaMyInfo",
          data: {
            'sessionKey': res.data
          },
          method: "GET",
          dataType: "json",
          success: function (res) {
            console.log("获取我的战绩信息");
            console.log(res);
            if (res.data.code != 0) {
              wx.showModal({
                content: '获取我的战绩信息失败' + res.data.message,
                showCancel: false,
                success: function (res) {
                }
              });
            } else {
              that.setData({
                allPay: res.data.data.allPay,
                allGet: res.data.data.allGet,
                allSucDaka: res.data.data.allSucDaka,
                dakaDetails: res.data.data.dakaDetails

              })
            }

          }

        });
      }
    });
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
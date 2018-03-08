// pages/rank/rank.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    app: getApp(),
    rankItems: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //this.loadRanking();
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
    this.loadRanking();
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
  
  },
  loadRanking: function () {
    var self = this;
    var url = self.data.app.BASE_URL + "/daka/getRanks";
    wx.request({
      url: url,
      success: function (res) {
        console.log("获取排名信息成功");
        console.log(res);
        if (res.data.code != 0) {
          wx.showModal({
            content: '获取世界排名信息失败' + res.data.message,
            showCancel: false,
            success: function (res) {
            }
          });
        } else {
          self.setData({
            rankItems: res.data.data
          })
        }
        
      },
      fail: function (res) {
        console.log("获取排名信息失败");
        console.log(res);
        wx.showModal({
          content: '获取世界排名信息失败' + res.data.message,
          showCancel: false,
          success: function (res) {
          }
        });
      }
    })
  }
})
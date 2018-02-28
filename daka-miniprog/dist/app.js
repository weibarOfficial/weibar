App({
  BASE_URL: 'https://www.yylive.com',  
    onLaunch: function () {
      var that = this;
      wx.login({
        success: function (res) {
          //that.loginMedal();
          if (res.code) {
            //发起网络请求
            var loginCode = res.code;
            console.log("登录成功获取code " + loginCode);
            wx.getUserInfo({
              success: function (res) {
                var userInfo = res.userInfo
                var nickName = userInfo.nickName;
                var avatarUrl = userInfo.avatarUrl;
                var gender = userInfo.gender; //性别 0：未知、1：男、2：女
                var province = userInfo.province;
                var city = userInfo.city;
                var country = userInfo.country;
                // wx.showModal({
                //   content: '获取用户信息成功',
                //   showCancel: false,
                //   success: function (res) {
                //   }
                // });
                wx.request({
                  url: getApp().BASE_URL + "/daka/login",
                  data: {
                    "code": loginCode,
                    "nickName": nickName,
                    "avatarUrl": avatarUrl,
                    "gender": gender,
                    "province": province,
                    "city": city,
                    "country": country
                  },
                  method: "GET",
                  dataType: "json",
                  success : function(res){
                    console.log(res);
                    if(res.data.code != 0){
                      wx.showModal({
                        content: '登录失败' + res.data.message,
                        showCancel: false,
                        success: function (res) {
                        }
                      });
                    }else{
                      wx.setStorage({
                        key: 'sessionKey',
                        data: res.data.data.sessionKey,
                      })
                    }
                    
                  },
                  fail : function (res) {
                    var resStr = JSON.stringify(res);
                    wx.showModal({
                      
                      content: '登录失败' + resStr,
                      showCancel: false,
                      success: function (res) {
                      }
                    });
                  }
                })
              }
            });
          } else {
            wx.showModal({
              content: '登录失败，访问后台服务器失败',
              showCancel: false,
              success: function (res) {
              }
            });
          }
        },
        fail : function(){
          that.loginMedal();
        }
      });
    },
    onShow: function () {
        console.log('App Show')
    },
    onHide: function () {
        console.log('App Hide')
    },


    loginMedal : function(){
      wx.showModal({
        content: '微信登录失败，必须授权登录才能进行后续操作，是否重新登录？',
        showCancel: true,
        success: function (res) {

          if (res.confirm) {
            wx.openSetting({
              success: function (res) {
              }
            })
          } else if (res.cancel) {
            console.log('微信登录 用户点击取消');
            wx.navigateBack({
              delta: -1
            })
          }


        }
      });
    },
    globalData: {
        hasLogin: false
    }
});
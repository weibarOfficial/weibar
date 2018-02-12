App({
  BASE_URL: 'https://www.yylive.com',  
    onLaunch: function () {
      wx.login({
        success: function (res) {
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
                wx.showModal({
                  content: '获取用户信息成功',
                  showCancel: false,
                  success: function (res) {
                  }
                });
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
            console.log('获取用户登录态失败！' + res.errMsg)
          }
        },
        fail : function(){
          wx.showModal({
            content: '登录失败，访问后台服务器失败',
            showCancel: false,
            success: function (res) {
            }
          });
        }
      });
    },
    onShow: function () {
        console.log('App Show')
    },
    onHide: function () {
        console.log('App Hide')
    },
    globalData: {
        hasLogin: false
    }
});
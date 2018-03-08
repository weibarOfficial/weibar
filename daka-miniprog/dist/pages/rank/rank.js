Page({
    onLoad: function() {
        this.loadRanking()
    },
    data: {
        app: getApp(),
        rankItems: [],
        modalHidden: true,
        rankTypes: ['原创', '分享', '阅读'],
        currentRankType: '原创'
    },
    changeRankType: function(e) {
        wx.showToast({
            title: '加载中',
            icon: 'loading'
        })
        var rankType = e.currentTarget.dataset.rankType
        this.setData({
            currentRankType: rankType
        })
        this.loadRanking()
    },
    loadRanking: function() {
        var self = this;
        var url = self.data.app.BASE_URL + "/daka/getDakaMyInfo";
        wx.request({
            url: url,
            success: function(res) {
              console.log(res);
            },
            fail: function(res) {
              console.log(res);
            }
        })
    },
    afterLoading: function(success) {
        wx.hideToast()
        if (!success) this.modalShow()
    },
    modalHide: function(e) {
        this.setData({
            modalHidden: true
        })
    },
    modalShow: function(e) {
        this.setData({
            modalHidden: false
        })
    }
})

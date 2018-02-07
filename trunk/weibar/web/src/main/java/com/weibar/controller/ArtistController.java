package com.weibar.controller;

import com.weibar.pojo.exception.BaseException;
import com.weibar.pojo.result.BaseResult;
import com.weibar.service.function.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/5.
 */
@RestController
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = "/h5/getArtistList" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object goodsSettingInfo(@RequestParam Long merchantId) throws BaseException {
        return BaseResult.getSuccessfulResult(artistService.getArtistList(merchantId));
    }

    @RequestMapping(value = "/h5/createArtist" ,method = {RequestMethod.POST,RequestMethod.GET})
    public Object createArtist(@RequestParam Long merchantId,@RequestParam Long userId) throws BaseException {
        return BaseResult.getSuccessfulResult(artistService.createArtist(merchantId,userId));
    }


}

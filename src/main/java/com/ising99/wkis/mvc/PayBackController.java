package com.ising99.wkis.mvc;

import com.ising99.wkis.parameter.PayinfoByUrlParam;
import com.ising99.wkis.service.PayinfoByUrlService;
import com.ising99.wkis.utils.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jerry on 2014/7/3.
 */
@Controller
@RequestMapping("payback")
public class PayBackController {
    @Resource
    PayinfoByUrlService payinfoByUrlService;

    /**
     * 网讯支付回调
     *
     * @param localOrderNo 开发者本地记录的订单号码*
     * @param merchantNo   商户记录的订单号*
     * @param payStatus    支付是否成功的状态*(2 表示  成功，1 表示失败)
     * @param payMoney     支付的金额(即是购买商品需要支付的金额)*
     * @param md5Str       加 密 验 证 *(localOrderNo|merchantNo|payStatus)需要将这几个参  数以“|”连接加密，如果为空的则用“”字符串表示
     * @param commodity    购买商品的名称
     * @param comcount     购买商品的数量*
     * @param comprice     购买商品的单价*
     * @return
     */
    @RequestMapping("/wx")
    @ResponseBody
    public boolean paybackByWangXun(HttpServletRequest request, String localOrderNo, String merchantNo
            , String payStatus, BigDecimal payMoney, String md5Str, String commodity, Integer comcount, BigDecimal comprice) {

        if(localOrderNo == null || localOrderNo.length() == 0){
            return  false;
        }
        if(merchantNo == null || merchantNo.length() == 0){
            return  false;
        }
        PayinfoByUrlParam payinfoByUrlParam = new PayinfoByUrlParam();
        payinfoByUrlParam.setCreatetime(new Date());
        try {
            payinfoByUrlParam.setIp(WebUtils.getIpAddr(request));
        }catch (Exception e){
            payinfoByUrlParam.setIp("");
        }
        payinfoByUrlParam.setComcount(comcount);
        payinfoByUrlParam.setCommodity(commodity);
        payinfoByUrlParam.setComprice(comprice);
        payinfoByUrlParam.setLoaclorderno(localOrderNo);
        payinfoByUrlParam.setMd5str(md5Str);
        payinfoByUrlParam.setMerchantno(merchantNo);
        payinfoByUrlParam.setPaymoney(payMoney);
        payinfoByUrlParam.setPaystatus(payStatus);
        payinfoByUrlParam.setQuerystring(request.getQueryString());
        payinfoByUrlParam.setUrl(request.getRequestURL().toString());
        int count = payinfoByUrlService.insert(payinfoByUrlParam);
        return count == 1;

    }
}

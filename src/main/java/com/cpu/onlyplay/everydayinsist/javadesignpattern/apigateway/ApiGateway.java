package com.cpu.onlyplay.everydayinsist.javadesignpattern.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 9:10
 * @description: 网关接口
 */
public class ApiGateway {

    private final ImageClient imageClient;


    private final PriceClient priceClient;

    public ApiGateway(ImageClient imageClient, PriceClient priceClient) {
        this.imageClient = imageClient;
        this.priceClient = priceClient;
    }

    @RequestMapping(path = "/desktop", method = RequestMethod.GET)
    public DesktopProduct getProductDesktop() {
        DesktopProduct desktopProduct = new DesktopProduct();
        desktopProduct.setImagePath(imageClient.getImageUrl());
        desktopProduct.setPrice(priceClient.getPrice());
        return desktopProduct;
    }


    /**
     * 移动端获取商品详情，但是不需要客户端
     *
     * @return
     */
    @RequestMapping(path = "/mobile", method = RequestMethod.GET)
    public MobileProduct getProductMobile() {
        MobileProduct mobileProduct = new MobileProduct();
        mobileProduct.setPrice(priceClient.getPrice());
        return mobileProduct;
    }

}

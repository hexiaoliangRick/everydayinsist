package com.cpu.onlyplay.everydayinsist.javadesignpattern.apigateway;

import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;

/**
 * @author: cpuRick
 * @createTime: 2022/08/16 9:06
 * @description: 图片客户端
 */
public class ImageClientImpl implements ImageClient {
    @Override
    public String getImageUrl() {
        try {
            HttpClient httpClient = HttpClient.New(new URL("http://localhost:50005/image-path"));

        } catch (IOException e) {

        }
        return null;
    }
}

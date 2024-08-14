package com.nuaa.testdemo;

import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.AppSigner;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class apiTest {
    @Test
    public void getWeatherInfo() {
        final String accessKey = "40c8d51743754b66bd3310b02b09543a";
        final String secretKey = "4d5baea0d8624fef882b5bfd05f5be70";

        String path = "http://getweather.api.bdymkt.com/lundear/weather1d";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.GET, path);
        request.setCredentials(accessKey, secretKey);
        request.addHeaderParameter("Content-Type", "application/json;charset=UTF-8");

        request.addQueryParameter("areaCn", "南京");
        request.addQueryParameter("areaCode", "");
        request.addQueryParameter("ip", "");
        request.addQueryParameter("lat", "");
        request.addQueryParameter("lng", "");

        ApiExplorerClient client = new ApiExplorerClient(new AppSigner());

        try {
            ApiExplorerResponse response = client.sendRequest(request);
            System.out.println(response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getWeather15DInfo() {
        final String accessKey = "40c8d51743754b66bd3310b02b09543a";
        final String secretKey = "4d5baea0d8624fef882b5bfd05f5be70";

        String path = "http://getweather.api.bdymkt.com/lundear/weather15d";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.GET, path);
        request.setCredentials(accessKey, secretKey);
        request.addHeaderParameter("Content-Type", "application/json;charset=UTF-8");

        request.addQueryParameter("areaCn", "");
        request.addQueryParameter("areaCode", "320100");
        request.addQueryParameter("ip", "");
        request.addQueryParameter("lat", "");
        request.addQueryParameter("lng", "");

        ApiExplorerClient client = new ApiExplorerClient(new AppSigner());

        try {
            ApiExplorerResponse response = client.sendRequest(request);
            System.out.println(response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getShipInfo() {
        final String accessKey = "40c8d51743754b66bd3310b02b09543a";
        final String secretKey = "4d5baea0d8624fef882b5bfd05f5be70";
        String path = "http://kuaidi100.api.bdymkt.com/poll/channelquery.do";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.POST, path);
        request.setCredentials(accessKey, secretKey);

        // 设置header参数
        request.addHeaderParameter("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

        // 设置query参数
        request.addQueryParameter("param", "{\"com\":\"yunda\",\"num\":\"434070173711291\"}");


        ApiExplorerClient client = new ApiExplorerClient(new AppSigner());

        try {
            ApiExplorerResponse response = client.sendRequest(request);
            // 返回结果格式为Json字符串
            System.out.println(response.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

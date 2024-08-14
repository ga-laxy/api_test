package com.nuaa.testdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.baidubce.http.ApiExplorerClient;
import com.baidubce.http.AppSigner;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.ApiExplorerRequest;
import com.baidubce.model.ApiExplorerResponse;
@SpringBootTest
class TestDemoApplicationTests {

    @Test
    void contextLoads() {
        String path = "http://kdniao.api.bdymkt.com/express/track";
        ApiExplorerRequest request = new ApiExplorerRequest(HttpMethodName.POST, path);
        request.setCredentials("40c8d51743754b66bd3310b02b09543a", "4d5baea0d8624fef882b5bfd05f5be70");

        request.addHeaderParameter("Content-Type", "application/json;charset=UTF-8");

        request.addQueryParameter("ShipperCode", "");
        request.addQueryParameter("LogisticCode", "");
        request.addQueryParameter("CustInfo", "");



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

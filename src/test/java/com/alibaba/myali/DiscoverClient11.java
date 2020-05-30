package com.alibaba.myali;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = MyaliApplication.class)
@RunWith(SpringRunner.class)
public class DiscoverClient11 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("content-center");
        instances.stream().forEach(e-> System.out.println(JSON.toJSONString(e)));
    }
}

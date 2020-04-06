package com.online.estore;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
public class RestTest {
    Logger log = LoggerFactory.getLogger(RestTest.class);


    static  {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
    }

    @Test
    public void test() throws Exception {
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
                new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build(), null, null,
                (s, sslSession) -> true
        );
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory);
        final HttpHeaders headers = new HttpHeaders();
        headers.set("uuid", UUID.randomUUID().toString());
        HttpEntity<EntityRequest> httpEntity = new HttpEntity<>(new EntityRequest(), headers);

        ResponseEntity<EntityResponse> response = restTemplate.exchange("https://transit2.emcrey.com:7790/ist/v1.0/accountVerification", HttpMethod.POST, httpEntity, EntityResponse.class);
        log.info("Response:{}", response);

//        ResponseEntity<Entity> responseEntity = restTemplate.postForEntity("https://transit2.emcrey.com:7790/ist/v1.0/accountVerification", httpEntity, Entity.class);
//        log.info("Response:{}", responseEntity);
    }
}

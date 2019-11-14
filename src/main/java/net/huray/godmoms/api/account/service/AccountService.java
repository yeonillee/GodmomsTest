package net.huray.godmoms.api.account.service;

import net.huray.godmoms.common.code.SocialType;
import net.huray.godmoms.common.dto.TokenRequest;
import net.huray.godmoms.common.dto.TokenResponse;
import net.huray.godmoms.common.property.SocialApiProperties;
import net.huray.godmoms.common.property.AccountApiProperties;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class AccountService {

    @Autowired
    private AccountApiProperties accountApiProperties;

    @Autowired
    private RestTemplate restTemplate;

    private String createCallbackUri(SocialType type, URI baseUri) {
        URIBuilder builder = new URIBuilder(baseUri);
        builder.setPathSegments("account", "callback", type.getCode());

        return builder.toString();
    }

    public String createAccountUri(SocialType type, URI uri) throws URISyntaxException {
        SocialApiProperties properties = accountApiProperties.getApiProperties(type);

        URIBuilder builder = new URIBuilder(properties.getAccountUrl());
        builder.addParameter("client_id", properties.getClientId());
        builder.addParameter("redirect_uri", createCallbackUri(type, uri));

        if (properties.getParams() != null) {
            properties.getParams().forEach((key, value) -> {
                builder.addParameter(key, value);
            });
        }

        return builder.toString();
    }

    public String requestToken(SocialType type, String code, String url) {
        SocialApiProperties properties = accountApiProperties.getApiProperties(type);

        TokenRequest request = new TokenRequest();
        request.setCode(code);
        request.setClientId(properties.getClientId());
        request.setClientSecret(properties.getClientSecret());
        request.setRedirectUri(url);

        MultiValueMap<String, String> map = request.getRequestMap();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        TokenResponse response = restTemplate.postForObject(properties.getTokenUrl(), entity, TokenResponse.class);

        return response.getAccessToken();
    }

}

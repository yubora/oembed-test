package com.purple.oembed.service;

import com.purple.oembed.domain.error.ErrorResponse;
import com.purple.oembed.domain.oembed.ProviderType;
import com.purple.oembed.domain.oembed.response.OembedResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OembedService {

    public Map<String, Object> getOembedData(String url) {
        Map<String, Object> result = new HashMap<>();
        String api = ProviderType.getApiByUrl(url);

        OembedResponse response;
        try {
            RestTemplate restTemplate = new RestTemplate();
            response = restTemplate.getForObject(api, OembedResponse.class);
            result.put("response", response);

        } catch (Exception e) {
            ErrorResponse error = null;
            if (e.getClass() == HttpClientErrorException.class
                    || e.getClass() == IllegalArgumentException.class) {

                error = ErrorResponse.builder()
                        .code(HttpStatusCode.valueOf(403).toString())
                        .message("잘못된 접근입니다. URL을 확인해주세요.")
                        .build();
            }

            result.put("error", error);
        }
        return result;
    }
}

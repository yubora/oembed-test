package com.purple.oembed.domain.oembed;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProviderType {
    YOUTUBE("youtube", "https://www.youtube.com/oembed?url="),
    TWITTER("twitter", "https://publish.twitter.com/oembed?url="),
    VIMEO("vimeo", "https://vimeo.com/api/oembed.json?url="),

    UNDEFINED("", ""),

    ;

    final String name;
    final String api;

    public String getName() {
        return name;
    }

    public String getApi() {
        return api;
    }

    public static String getApiByUrl(String url) {
        if (url.contains(ProviderType.YOUTUBE.getName())) {
            return ProviderType.YOUTUBE.getApi() + url;
        }
        if (url.contains(ProviderType.TWITTER.getName())) {
            return ProviderType.TWITTER.getApi() + url;
        }
        if (url.contains(ProviderType.VIMEO.getName())) {
            return ProviderType.VIMEO.getApi() + url;
        }
        return UNDEFINED.getApi();
    }

}

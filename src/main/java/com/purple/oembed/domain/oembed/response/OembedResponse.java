package com.purple.oembed.domain.oembed.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@Data
public class OembedResponse {
    private String title;
    private String type;
    private String version;
    private String width;
    private String height;
    private String url;
    private String authorName;
    private String authorUrl;
    private String providerName;
    private String providerUrl;
    private String isPlus;
    private String html;
    private String duration;
    private String description;
    private String thumbnailUrl;
    private String thumbnailWidth;
    private String thumbnailHeight;
    private String thumbnailUrlWithPlayButton;
    private String uploadDate;
    private String videoId;
    private String uri;

}

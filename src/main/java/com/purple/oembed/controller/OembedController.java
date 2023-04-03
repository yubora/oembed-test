package com.purple.oembed.controller;

import com.purple.oembed.service.OembedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/page")
public class OembedController {

    private final OembedService oembedService;

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/oembed")
    public String getOembed(Model model, @RequestParam("url") String url) {
        if (StringUtils.isEmpty(url)) {
            return "redirect:/";
        }

        Map<String, Object> result = oembedService.getOembedData(url);

        model.addAttribute("error", result.get("error"));
        model.addAttribute("response", result.get("response"));
        model.addAttribute("url", url);

        return "index";
    }


}

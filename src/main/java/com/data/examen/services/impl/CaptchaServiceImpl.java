package com.data.examen.services.impl;

import com.data.examen.config.CaptchaProperties;
import com.data.examen.entity.CaptchaResponse;
import com.data.examen.services.ICaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.regex.Pattern;

@Service
public class CaptchaServiceImpl implements ICaptchaService {

    @Autowired
    private CaptchaProperties captchaProperties;

    @Autowired
    private RestTemplate restTemplate;

    private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    /*@Override
    private void processResponse(String response) {
        if(!responseSanityCheck(response)) {
            //throw new InvalidReCaptchaException("Response contains invalid characters");
        }

        URI verifyUri = URI.create(String.format(
                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
                captchaProperties.getSecret(), response, ""));

        CaptchaResponse captchaResponse = restTemplate.getForObject(verifyUri, CaptchaResponse.class);

        if(!captchaResponse.getSuccess()) {
            //throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
        }
    }*/

    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    @Override
    public void processResponse(String response) {
        if(!responseSanityCheck(response)) {
            //throw new InvalidReCaptchaException("Response contains invalid characters");
        }

        URI verifyUri = URI.create(String.format(
                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
                captchaProperties.getSecret(), response));

        CaptchaResponse captchaResponse = restTemplate.getForObject(verifyUri, CaptchaResponse.class);

        if(!captchaResponse.getSuccess()) {
            //throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
        }
    }
}
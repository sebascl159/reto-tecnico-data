package com.data.examen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CaptchaResponse {

    private Boolean success;

    @JsonProperty("challenge_ts")
    private Date challengeTs;

    private String hostname;

    @JsonProperty("error-codes")
    private List<String> errorCodes;


}

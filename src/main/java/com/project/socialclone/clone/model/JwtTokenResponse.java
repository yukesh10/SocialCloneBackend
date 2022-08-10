package com.project.socialclone.clone.model;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {
    private final String token;

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}

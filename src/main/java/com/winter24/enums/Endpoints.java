package com.winter24.enums;

import lombok.Getter;

public enum Endpoints {

    DEMO_QA_HOME_PAGE("https://demoqa.com"),
    ALERT("/alerts"),
    FRAMES("/frames"),
    BROWSER_WINDOWS("/browser-windows");

    @Getter
    final String endpoint;


    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

}

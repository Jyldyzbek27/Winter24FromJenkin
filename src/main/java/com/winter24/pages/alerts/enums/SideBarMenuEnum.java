package com.winter24.pages.alerts.enums;

import lombok.Getter;

public enum SideBarMenuEnum {

    ADMIN("Admin"),
    PIM("Pim");


    @Getter
    String menu;

    SideBarMenuEnum(String menu) {
        this.menu = menu;
    }
}

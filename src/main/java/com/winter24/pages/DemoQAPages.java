package com.winter24.pages;

import com.winter24.pages.alerts.AlertPage;
import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@Builder
public class DemoQAPages {

    protected TextBoxPage textBoxPage;
    protected PracticeFormPage practiceFormPage;
    protected AlertPage alertPage;
    protected ButtonsPage buttonsPage;
    protected MenuPage menuPage;
    protected ProgressBarPage progressBarPage;
    protected SelectPage selectPage;
    protected WebTablesPage webTablesPage;
    protected SideBarMenu sideBarMenu;


    public DemoQAPages() {
        setUp();
    }

    public void setUp() {
        textBoxPage = new TextBoxPage();
        practiceFormPage = new PracticeFormPage();
        alertPage = new AlertPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        selectPage = new SelectPage();
        webTablesPage = new WebTablesPage();
        sideBarMenu = new SideBarMenu();
    }
}

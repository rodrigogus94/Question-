package com.reciclagus.question.model.quiz;

public class Content {

    private String txtMain;
    private String txtExemple;
    private String moduleTitle;

    public Content(String txtMain, String txtExemple, String moduleTitle) {
        this.txtMain = txtMain;
        this.txtExemple = txtExemple;
        this.moduleTitle = moduleTitle;
    }
    public Content(String txtMain, String txtExemple) {
        this.txtMain = txtMain;
        this.txtExemple = txtExemple;
    }


    public Content() {}

    public String getTxtMain() {
        return txtMain;
    }

    public void setTxtMain(String txtMain) {
        this.txtMain = txtMain;
    }

    public String getTxtExemple() {
        return txtExemple;
    }

    public void setTxtExemple(String txtExemple) {
        this.txtExemple = txtExemple;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }
}

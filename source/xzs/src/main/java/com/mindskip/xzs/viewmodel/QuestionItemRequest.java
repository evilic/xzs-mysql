package com.mindskip.xzs.viewmodel;

import javax.validation.constraints.NotBlank;

public class QuestionItemRequest {
    @NotBlank
    private String prefix;
    @NotBlank
    private String content;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

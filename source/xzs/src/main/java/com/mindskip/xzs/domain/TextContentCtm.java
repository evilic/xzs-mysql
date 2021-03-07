package com.mindskip.xzs.domain;

import java.io.Serializable;

public class TextContentCtm implements Serializable {
    private static final long serialVersionUID = 4532622187295506541L;

    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}

package com.translation.api.model;

public class TranslationRequest {
    private String text;
    private String from;
    private String to;

    public TranslationRequest() {}

    public TranslationRequest(String text, String from, String to) {
        this.text = text;
        this.from = from;
        this.to = to;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
      }

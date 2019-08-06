package com.webChat.entities;

public class Chat {

    private String chatwho;
    private String saywhat;
    private String whochat;

    public String getWhochat() {
        return whochat;
    }

    public void setWhochat(String whochat) {
        this.whochat = whochat;
    }

    public String getChatwho() {
        return chatwho;
    }

    public void setChatwho(String chatwho) {
        this.chatwho = chatwho;
    }

    public String getSaywhat() {
        return saywhat;
    }

    public void setSaywhat(String saywhat) {
        this.saywhat = saywhat;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chatwho='" + chatwho + '\'' +
                ", saywhat='" + saywhat + '\'' +
                ", whochat='" + whochat + '\'' +
                '}';
    }
}

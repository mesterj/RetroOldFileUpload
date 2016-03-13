package com.kite.joco.retrooldfileupload.entity;

import java.util.Date;

/**
 * Created by Mester József on 2015.11.23..
 */
public class Partner {

    private String partnerKod;

    private String partnerNev;

    private String partnerTelepules;

    private String partnerIrsz;

    private String partnerCim;

    private String partnerAdoszam;

    private String partnerEmail;

    private String status;

    private Date modifiedTime;

    public String getPartnerKod() {
        return partnerKod;
    }

    public void setPartnerKod(String partnerKod) {
        this.partnerKod = partnerKod;
    }

    public String getPartnerNev() {
        return partnerNev;
    }

    public void setPartnerNev(String partnerNev) {
        this.partnerNev = partnerNev;
    }

    public String getPartnerTelepules() {
        return partnerTelepules;
    }

    public void setPartnerTelepules(String partnerTelepules) {
        this.partnerTelepules = partnerTelepules;
    }

    public String getPartnerIrsz() {
        return partnerIrsz;
    }

    public void setPartnerIrsz(String partnerIrsz) {
        this.partnerIrsz = partnerIrsz;
    }

    public String getPartnerCim() {
        return partnerCim;
    }

    public void setPartnerCim(String partnerCim) {
        this.partnerCim = partnerCim;
    }

    public String getPartnerAdoszam() {
        return partnerAdoszam;
    }

    public void setPartnerAdoszam(String partnerAdoszam) {
        this.partnerAdoszam = partnerAdoszam;
    }

    public String getPartnerEmail() {
        return partnerEmail;
    }

    public void setPartnerEmail(String partnerEmail) {
        this.partnerEmail = partnerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}


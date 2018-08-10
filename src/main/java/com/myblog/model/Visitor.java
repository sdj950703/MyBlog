package com.myblog.model;

import java.sql.Date;

public class Visitor {
    private Integer vId;

    private String ipadress;

    private Integer bId;

    private Date visitttime;

    public Integer getvId() {
        return vId;
    }

    public void setvId(Integer vId) {
        this.vId = vId;
    }

    public String getIpadress() {
        return ipadress;
    }

    public void setIpadress(String ipadress) {
        this.ipadress = ipadress == null ? null : ipadress.trim();
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Date getVisitttime() {
        return visitttime;
    }

    public void setVisitttime(Date visitttime) {
        this.visitttime = visitttime;
    }

	@Override
	public String toString() {
		return "Visitor [vId=" + vId + ", ipadress=" + ipadress + ", bId="
				+ bId + ", visitttime=" + visitttime + "]";
	}
    
}
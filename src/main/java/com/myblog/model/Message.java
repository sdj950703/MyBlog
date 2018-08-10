package com.myblog.model;

public class Message {
    private Integer mId;

    private String name;

    private String email;

    private String content;

    private Short sendback;

    private String phone;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Short getSendback() {
        return sendback;
    }

    public void setSendback(Short sendback) {
        this.sendback = sendback;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	@Override
	public String toString() {
		return "Message [mId=" + mId + ", name=" + name + ", email=" + email
				+ ", content=" + content + ", sendback=" + sendback
				+ ", phone=" + phone + "]";
	}
    
}
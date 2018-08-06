package com.myblog.model;

import java.io.Serializable;
import java.sql.Date;

public class Blog implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer bId;

    private String title;

    private String author;

    private Integer readcount;

    private Date createtime;

    private String content;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "Blog [bId=" + bId + ", title=" + title + ", author=" + author
				+ ", readcount=" + readcount + ", createtime=" + createtime
				+ ", content=" + content + "]";
	}
    
}
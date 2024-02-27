package com.cvds.servingWebContent;

public class UserToDo {

    private Integer id;
    private Integer userId;
    private String title;
    private boolean state;

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public boolean isState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

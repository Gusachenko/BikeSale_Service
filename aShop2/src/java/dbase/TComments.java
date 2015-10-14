/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbase;

/**
 *
 * @author huma
 */
public class TComments {
    
    int id;
    String userName;
    String textComment;
    String date;
    
    public TComments() {
    }

    public TComments(Integer id) {
        this.id = id;
    }

    public TComments(Integer id, String userName, String textComment, String date) {
        this.id = id;
        this.userName = userName;
        this.textComment = textComment;
        this.date = date;
    }

    public Integer getKeyId() {
        return id;
    }

    public void setKeyId(Integer keyId) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}

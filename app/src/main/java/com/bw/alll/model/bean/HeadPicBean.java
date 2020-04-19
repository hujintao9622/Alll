package com.bw.alll.model.bean;

/**
 * date:2020/4/15 0015
 * author:胡锦涛(Administrator)
 * function:
 */
public class HeadPicBean {

    /**
     * headPath : http://mobile.bwstudent.com/images/movie/head_pic/2020-04-15/20200415195722.jpg
     * message : 上传成功
     * status : 0000
     */

    private String headPath;
    private String message;
    private String status;

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

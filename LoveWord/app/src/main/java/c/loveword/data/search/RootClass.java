package c.loveword.data.search;

/**
 * Created by hasee on 2017/5/19.
 */

import java.util.List;

public class RootClass {
    private List<String> translation;
    private Basic basic;
    private String query;
    private int errorCode;
    private List<Web> web;

    public List<String> gettranslation() {
        return translation;
    }

    public void settranslation(List<String> translation) {
        this.translation = translation;
    }

    public Basic getbasic() {
        return basic;
    }

    public void setbasic(Basic basic) {
        this.basic = basic;
    }

    public String getquery() {
        if (query==null) {
            return "";
        }
        else{
            return query;
        }
    }

    public void setquery(String query) {
        this.query = query;
    }

    public int geterrorCode() {
        return errorCode;
    }

    public void seterrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<Web> getweb() {
        return web;
    }

    public void setweb(List<Web> web) {
        this.web = web;
    }
}
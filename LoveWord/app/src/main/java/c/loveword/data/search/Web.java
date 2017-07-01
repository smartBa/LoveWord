package c.loveword.data.search;

/**
 * Created by hasee on 2017/5/19.
 */

import java.util.List;

public class Web {
    private List<String> value;
    private String key;

    public List<String> getvalue() {
        return value;
    }

    public void setvalue(List<String> value) {
        this.value = value;
    }

    public String getkey() {
        if (key==null) {
            return "";
        }
        else{
            return key;
        }
    }

    public void setkey(String key) {
        this.key = key;
    }
}
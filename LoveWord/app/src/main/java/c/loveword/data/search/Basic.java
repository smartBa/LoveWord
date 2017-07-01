package c.loveword.data.search;

/**
 * Created by hasee on 2017/5/19.
 */

import java.util.List;

import java.util.List;

public class Basic {
    private String us_phonetic;
    private String phonetic;
    private String uk_phonetic;
    private List<String> explains;

    public String getus_phonetic() {
        if (us_phonetic==null) {
            return "";
        }
        else{
            return us_phonetic;
        }
    }

    public void setus_phonetic(String us_phonetic) {
        this.us_phonetic = us_phonetic;
    }

    public String getphonetic() {
        if (phonetic==null) {
            return "";
        }
        else{
            return phonetic;
        }
    }

    public void setphonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getuk_phonetic() {
        if (uk_phonetic==null) {
            return "";
        }
        else{
            return uk_phonetic;
        }
    }

    public void setuk_phonetic(String uk_phonetic) {
        this.uk_phonetic = uk_phonetic;
    }

    public List<String> getexplains() {
        return explains;
    }

    public void setexplains(List<String> explains) {
        this.explains = explains;
    }
}

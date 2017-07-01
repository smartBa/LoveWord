package c.loveword.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hasee on 2017/6/8.
 */
@Entity
public class Word {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String voice;
    private String explain;
    @Generated(hash = 1145224291)
    public Word(Long id, String name, String voice, String explain) {
        this.id = id;
        this.name = name;
        this.voice = voice;
        this.explain = explain;
    }
    @Generated(hash = 3342184)
    public Word() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVoice() {
        return this.voice;
    }
    public void setVoice(String voice) {
        this.voice = voice;
    }
    public String getExplain() {
        return this.explain;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }
   
}

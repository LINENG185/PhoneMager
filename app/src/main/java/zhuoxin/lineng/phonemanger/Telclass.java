package zhuoxin.lineng.phonemanger;

/**
 * Created by 繁华丶落尽 on 2016/6/13.
 */
public class Telclass {
    private String name;
    private int idx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Telclass(String name, int idx) {

        this.name = name;
        this.idx = idx;
    }
}

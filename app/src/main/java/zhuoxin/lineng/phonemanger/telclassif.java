package zhuoxin.lineng.phonemanger;

/**
 * Created by 繁华丶落尽 on 2016/6/14.
 */
public class telclassif {
    private String name;
    private long nunber;
    private int _id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNunber() {
        return nunber;
    }

    public void setNunber(long nunber) {
        this.nunber = nunber;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public telclassif( int _id, long nunber,String name) {

        this.name = name;
        this._id = _id;
        this.nunber = nunber;
    }
}

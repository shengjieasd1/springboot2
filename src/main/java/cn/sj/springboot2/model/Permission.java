package cn.sj.springboot2.model;

/**
 * @author shuzheng
 */
public class Permission {
    private int id;
    private String pername;
    private String perids;
    private int fatherID;
    private String pertype;
    
    @Override
    public String toString() {
        return "permission{" +
                "id=" + id +
                ", pername='" + pername + '\'' +
                ", perids='" + perids + '\'' +
                ", fatherID='" + fatherID + '\'' +
                ", pertype='" + pertype + '\'' +
                '}';
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPername() {
        return pername;
    }
    
    public void setPername(String pername) {
        this.pername = pername;
    }
    
    public String getPerids() {
        return perids;
    }
    
    public void setPerids(String perids) {
        this.perids = perids;
    }
    
    public int getFatherID() {
        return fatherID;
    }
    
    public void setFatherID(int fatherID) {
        this.fatherID = fatherID;
    }
    
    public String getPertype() {
        return pertype;
    }
    
    public void setPertype(String pertype) {
        this.pertype = pertype;
    }
}

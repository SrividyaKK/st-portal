package universe.sk.stportal;

public class Complaint {
    private String busNum, compCount, compMsg;

    public Complaint(String busNum, String compCount, String compMsg) {
        this.busNum = busNum;
        this.compCount = compCount;
        this.compMsg = compMsg;
    }

    public String getBusNum() {
        return busNum;
    }
    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public String getCompCount() {
        return compCount;
    }
    public void setCompCount(String compCount) {
        this.compCount = compCount;
    }

    public String getCompMsg() {
        return compMsg;
    }
    public void setCompMsg(String compMsg) {
        this.compMsg = compMsg;
    }
}

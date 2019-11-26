package universe.sk.stportal;

public class Complaint {
    private String busNum, compDate, compMsg;

    public Complaint(String busNum, String compDate, String compMsg) {
        this.busNum = busNum;
        this.compDate = compDate;
        this.compMsg = compMsg;
    }

    public String getBusNum() {
        return busNum;
    }
    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public String getCompDate() {
        return compDate;
    }
    public void setCompDate(String compDate) {
        this.compDate = compDate;
    }

    public String getCompMsg() {
        return compMsg;
    }
    public void setCompMsg(String compMsg) {
        this.compMsg = compMsg;
    }
}

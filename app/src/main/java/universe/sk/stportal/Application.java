package universe.sk.stportal;

public class Application {
    private String id, name, status;

    public Application(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public String getstatus() {
        return status;
    }
    public void setstatus(String status) {
        this.status = status;
    }
}

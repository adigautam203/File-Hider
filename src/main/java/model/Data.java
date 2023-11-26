package model;

public class Data {
    private int id;
    private String filenaame;
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilenaame() {
        return filenaame;
    }

    public void setFilenaame(String filenaame) {
        this.filenaame = filenaame;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEmail() {
        return email;
    }

    public Data(int id, String filenaame, String path) {
        this.id = id;
        this.filenaame = filenaame;
        this.path = path;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private  String email;

    public Data(int id, String filenaame, String path, String email) {
        this.id = id;
        this.filenaame = filenaame;
        this.path = path;
        this.email = email;
    }
}

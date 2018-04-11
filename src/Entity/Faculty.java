package Entity;

public class Faculty {
    private long id;
    private String name;

    public Faculty(){}

    public Faculty(long id, String name){
        this.id = id;
        this.name = name;
    }

    public Faculty(String name){
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Faculty: id = " + id + ", name = " + name;
    }
}

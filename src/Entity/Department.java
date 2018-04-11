package Entity;

public class Department extends Object{
    private long id;
    private String name;
    private String faculty;

    public Department(){}

    public Department(String name, String faculty){
        this.name = name;
        this.faculty = faculty;
    }

    public Department(long id, String name, String faculty){
        this.id = id;
        this.name = name;
        this.faculty = faculty;
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

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString(){
        return "Department: id = " + id + ", name = " + name + ", faculty = " + faculty;
    }
}

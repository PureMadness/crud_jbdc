package Entity;

public class Professor {
    private long id;
    private String name;
    private String department;

    public Professor(){}

    public Professor(String name, String department){
        this.name = name;
        this.department = department;
    }

    public Professor(long id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    @Override
    public String toString(){
        return "Professor: id = " + id + ", name = " + name + ", department = " + department;
    }
}

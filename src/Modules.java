public class Modules {
    private int marks;
    private String name;
    private String moduleGrade;

    public Modules(int marks, String name) {
        this.marks = marks;
        this.name = name;
        this.moduleGrade = "moduleGrade";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getModuleGrade() {
        return moduleGrade;
    }

    public void setModuleGrade(String moduleGrade) {
        this.moduleGrade = moduleGrade;
    }
}

public class Student {
    private String id;
    private String name;
    private Modules [] module;

    public Student(String id, String name, Modules[] module) {
        this.id = id;
        this.name = name;
        this.module = module;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Modules[] getModule() {
        return module;
    }

    public void setModule(Modules[] module) {
        this.module = module;
    }
}

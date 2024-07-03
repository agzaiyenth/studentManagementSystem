public class Modules {
    private int module_1;
    private int module_2;
    private int module_3;
    private int total;
    private int average;
    private String moduleGrade;

    public Modules(int [] module_marks) {
        this.module_1=module_marks[0];
        this.module_2=module_marks[1];
        this.module_3=module_marks[2];
        this.total=this.module_1+this.module_2+this.module_3;
        this.average=total/3;
        if (average>=80){
            this.moduleGrade="Distinction";
        } else if (average>=70) {
            this.moduleGrade="Merit";
        } else if (average>=40) {
            this.moduleGrade="Pass";
        }else{
            this.moduleGrade="Fail";
        }
        ;
    }


    public int getModule_1() {
        return module_1;
    }

    public void setModule_1(int module_1) {
        this.module_1 = module_1;
    }

    public int getModule_2() {
        return module_2;
    }

    public void setModule_2(int module_2) {
        this.module_2 = module_2;
    }

    public int getModule_3() {
        return module_3;
    }

    public void setModule_3(int module_3) {
        this.module_3 = module_3;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public String getModuleGrade() {
        return moduleGrade;
    }

    public void setModuleGrade(String moduleGrade) {
        this.moduleGrade = moduleGrade;
    }
}

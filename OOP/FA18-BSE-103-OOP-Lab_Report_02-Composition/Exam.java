public class Exam{
    private String course;
    private double gpa;
    
    public Exam(String course,double gpa){
        this.course=course;
        this.gpa=gpa;
    }
    
    public Exam(){
        this.course = "";
        this.gpa=0;
    }
    
    public String  toString(){
        return course;
    }
    
    public double getGrade(){
        return gpa;
    }
    public double getValue(){
        return gpa;
    }
    public double toDouble(){
        return gpa;
    }
    
    public void setGrade(double grade){
        this.gpa=grade;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public double getPercent(){
        return gpa*100/4;
    }
    
    
}
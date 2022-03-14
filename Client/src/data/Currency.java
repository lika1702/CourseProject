package data;

public class Currency {
    private String code;
    private String name;
    private double course;
    
    public Currency (String code, String name, double course) {
        this.setCode(code);
        this.setName(name);
        this.setCourse(course);
    }
    
    public void setCode (String code) {
        this.code = code;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public void setCourse (double course) {
        this.course = course;
    }
    
    public String getCode () {
        return this.code;
    }
    
    public String getName () {
        return this.name;
    }
    
    public double getCourse () {
        return this.course;
    }
}

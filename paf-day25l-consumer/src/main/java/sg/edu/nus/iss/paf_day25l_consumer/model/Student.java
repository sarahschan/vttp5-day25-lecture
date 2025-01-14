package sg.edu.nus.iss.paf_day25l_consumer.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class Student {
    
    private int id;
    private String fullName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dob;

    
    public Student() {
    }

    public Student(int id, String fullName, LocalDate dob) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", fullName=" + fullName + ", dob=" + dob + "]";
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}

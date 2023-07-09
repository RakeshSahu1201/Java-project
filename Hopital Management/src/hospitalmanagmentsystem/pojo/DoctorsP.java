/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.pojo;

import java.util.Date;

/**
 *
 * @author Soft1
 */
public class DoctorsP {

    public DoctorsP() {
    }
    private String doctor_id;
    private String doctor_name;
    private String email;
    private long contact;
    private String qualification;
    private String gender;
    private Date doj;

    public DoctorsP(String doctor_id, String doctor_name, String email, long contact, String qualification, String gender, Date doj) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.email = email;
        this.contact = contact;
        this.qualification = qualification;
        this.gender = gender;
        this.doj = doj;
    }
    

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }
     
}

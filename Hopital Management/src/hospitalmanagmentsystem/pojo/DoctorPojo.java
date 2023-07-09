/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem.pojo;

/**
 *
 * @author Soft1
 */
public class DoctorPojo {

    private String doctorName;
    private String doctorId;
    private String qualification;
    private String Specialist;
    private String emailId;
    private String gender;
    private String contactNo;

    public DoctorPojo() {
    }

    public DoctorPojo(String doctorName, String doctorId, String qualification, String Specialist, String emailId, String gender, String contactNo) {
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.qualification = qualification;
        this.Specialist = Specialist;
        this.emailId = emailId;
        this.gender = gender;
        this.contactNo = contactNo;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String Specialist) {
        this.Specialist = Specialist;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    
    
    
   }

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
public class ReceptionistPojo {
    private String receptionistId;
    private String receptionistName;
    private String gender;

    public ReceptionistPojo() {
    }

    public ReceptionistPojo(String receptionistId, String receptionistName, String gender) {
        this.receptionistId = receptionistId;
        this.receptionistName = receptionistName;
        this.gender = gender;
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public void setReceptionistName(String receptionistName) {
        this.receptionistName = receptionistName;
    }

    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "ReceptionistPojo{" + "receptionistId=" + receptionistId + ", receptionistName=" + receptionistName + ", gender=" + gender + '}';
    }
    
    
}

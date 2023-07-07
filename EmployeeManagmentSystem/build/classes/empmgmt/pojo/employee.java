package empmgmt.pojo;


public class employee {

    private int empno;
    private String ename;
    private double esal;
    public employee() {
    }
    public employee(int empno,String ename,double esal){
        this.empno = empno;
        this.ename = ename;
        this.esal = esal;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }    
}

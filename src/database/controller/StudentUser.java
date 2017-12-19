package database.controller;

import javafx.beans.property.SimpleStringProperty;

public class StudentUser {
    private final SimpleStringProperty STDID;
    private final SimpleStringProperty FIRSTNAME;
    private final SimpleStringProperty LASTNAME;
    private final SimpleStringProperty SEX;
    private final SimpleStringProperty BDATE;

    StudentUser(String STDID,String FIRSTNAME,String LASTNAME,String SEX, String BDATE) {
        this.STDID = new SimpleStringProperty(STDID);
        this.FIRSTNAME = new SimpleStringProperty(FIRSTNAME);
        this.LASTNAME = new SimpleStringProperty(LASTNAME);
        this.SEX = new SimpleStringProperty(SEX);
        this.BDATE = new SimpleStringProperty(BDATE);
    }

    public String getSTDID() {
        return STDID.get();
    }
    public void setSTDID(String STDID) {
        this.STDID.set(STDID);
    }

    public String getFIRSTNAME() {
        return FIRSTNAME.get();
    }
    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME.set(FIRSTNAME);
    }

    public String getLASTNAME() {
        return LASTNAME.get();
    }
    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME.set(LASTNAME);
    }
    
    public String getSEX() {
        return SEX.get();
    }
    
    public void setSEX(String SEX) {
        this.SEX.set(SEX);
    }
    
    public String getBDATE() {
        return BDATE.get();
    }
    
    public void setBDATE(String BDATE) {
        this.BDATE.set(BDATE);
    }

    @Override
    public String toString() {
        return STDID + ", " + FIRSTNAME + ", " + LASTNAME + ", " + SEX + ", " + BDATE;
    }



}


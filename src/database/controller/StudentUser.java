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
    
    StudentUser(String STDID,String FIRSTNAME,String LASTNAME) {
        this.STDID = new SimpleStringProperty(STDID);
        this.FIRSTNAME = new SimpleStringProperty(FIRSTNAME);
        this.LASTNAME = new SimpleStringProperty(LASTNAME);
        this.SEX = null;
        this.BDATE = null;
    }

    public String getSTDID() {
        return STDID.get();
    }
    public void setSTDID(String StdId) {
        this.STDID.set(StdId);
    }

    public String getFIRSTNAME() {
        return FIRSTNAME.get();
    }
    public void setFIRSTNAME(String FirstName) {
        this.FIRSTNAME.set(FirstName);
    }

    public String getLASTNAME() {
        return LASTNAME.get();
    }
    public void setLASTNAME(String LastName) {
        this.LASTNAME.set(LastName);
    }
    
    public String getSEX() {
        return SEX.get();
    }
    
    public void setSEX(String Sex) {
        this.SEX.set(Sex);
    }
    
    public String getBDATE() {
        return BDATE.get();
    }
    
    public void setBDATE(String BDate) {
        this.BDATE.set(BDate);
    }

    @Override
    public String toString() {
        return STDID + ", " + FIRSTNAME + ", " + LASTNAME + ", " + SEX + ", " + BDATE;
    }



}


package database.controller;

import javafx.beans.property.SimpleStringProperty;

public class User {
    private final SimpleStringProperty STDID;
    private final SimpleStringProperty FIRSTNAME;
    private final SimpleStringProperty LASTNAME;
    private final SimpleStringProperty SEX;
    private final SimpleStringProperty BDATE;

    User(String STDID,String FIRSTNAME,String LASTNAME,String SEX, String BDATE) {
        this.STDID = new SimpleStringProperty(STDID);
        this.FIRSTNAME = new SimpleStringProperty(FIRSTNAME);
        this.LASTNAME = new SimpleStringProperty(LASTNAME);
        this.SEX = new SimpleStringProperty(SEX);
        this.BDATE = new SimpleStringProperty(BDATE);
    }

    public String getSTDID() {
        return STDID.get();
    }
    public void setSTDID(String uName) {
        STDID.set(uName);
    }

    public String getFIRSTNAME() {
        return FIRSTNAME.get();
    }
    public void setFIRSTNAME(String pass) {
        FIRSTNAME.set(pass);
    }

    public String getLASTNAME() {
        return LASTNAME.get();
    }
    public void setLASTNAME(String fName) {
        LASTNAME.set(fName);
    }
    
    public String getSEX() {
        return SEX.get();
    }
    
    public void setSEX(String sex) {
        SEX.set(sex);
    }
    
    public String getBDATE() {
        return BDATE.get();
    }
    
    public void setBDATE(String bDate) {
        BDATE.set(bDate);
    }

    @Override
    public String toString() {
        return STDID + ", " + FIRSTNAME + ", " + LASTNAME + ", " + SEX + ", " + BDATE;
    }



}


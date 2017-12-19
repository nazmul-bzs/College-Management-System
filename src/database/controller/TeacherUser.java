/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.controller;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Nazmul
 */
public class TeacherUser {
    private SimpleStringProperty TID;
    private SimpleStringProperty FIRSTNAME;
    private SimpleStringProperty LASTNAME;
    private SimpleStringProperty SEX;
    private SimpleStringProperty BDATE;

    public TeacherUser(String TID, String FIRSTNAME, String LASTNAME, String SEX, String BDATE) {
        this.TID = new SimpleStringProperty(TID);
        this.FIRSTNAME = new SimpleStringProperty(FIRSTNAME);
        this.LASTNAME = new SimpleStringProperty(LASTNAME);
        this.SEX = new SimpleStringProperty(SEX);
        this.BDATE = new SimpleStringProperty(BDATE);
    }
    
    public String getSTDID() {
        return TID.get();
    }
    public void setSTDID(String TID) {
        this.TID.set(TID);
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
        return TID + ", " + FIRSTNAME + ", " + LASTNAME + ", " + SEX + ", " + BDATE;
    }

}

package com.Externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class Automobile implements Externalizable {

    private String regNo;
    private String mileage;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public Automobile() {}

    Automobile(String rn, String m) {
        regNo = rn;
        mileage = m;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.regNo);
        out.writeObject(this.mileage);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.regNo = (String) in.readObject();
        this.mileage = (String) in.readObject();
    }
}
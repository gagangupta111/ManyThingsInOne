package com.HackerEarth;

public class HashCodeCheck {

    private int value = 5;
    private String id;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeCheck)) return false;

        HashCodeCheck that = (HashCodeCheck) o;

        if (getValue() != that.getValue()) return false;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getValue();
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }

    public static void main(String[] args){

        System.out.println(" Hello !");






    }

}

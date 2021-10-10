package org.yeasheng.enumdef;

/**
 * @author yansh
 * @version 2021/7/3
 **/
public enum Gender {

    MALE("男"),

    FEMALE("女");

    private final String gender;

    Gender(String gender){
        this.gender = gender;
    }
    public String getName(){
        return this.gender;
    }
}

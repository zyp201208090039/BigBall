package com.example.demo.model;

import com.sun.org.apache.xpath.internal.objects.XString;

public enum  RoleEnum {

    Admin("admin"),
    Teacher("Teacher"),
    student("student"),
    common("Normal");
    private String srole;
    RoleEnum(String role)
    {
        this.srole=role;
    }
    public String getSrole()
    {
        return this.srole;
    }


}

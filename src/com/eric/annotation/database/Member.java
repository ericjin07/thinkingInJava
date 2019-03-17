package com.eric.annotation.database;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/15/2019 3:22 PM
 */
@DBTable(name = "MEMBER")
public class Member {
    @SqlString(20)
    private String firstName;

    @SqlString(30)
    private String lastName;
    @SqlInteger
    private int age;
    @SqlString(value = 30,name = "handler",constriants = @Constriants(primaryKey = true))
    private String handle;

    private static int membercount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMembercount() {
        return membercount;
    }
}

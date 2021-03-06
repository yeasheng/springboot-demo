package org.yeasheng.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = -1590950705684397210L;

    /**
     * 员工号
     */
    private Long empNo;

    /**
     * 员工姓名
     */
    private String eName;

    private Integer age;

    /**
     * 薪水
     */
    private Integer salary;
    /**
     * 所属部门号
     */
    private Integer deptNo;

    public Employee(Long empNo, String eName, Integer salary, Integer deptNo) {
        this.empNo = empNo;
        this.eName = eName;
        this.salary = salary;
        this.deptNo = deptNo;
    }

    public Employee() {
    }
}
package org.yeasheng.entity;

import lombok.Data;

@Data

public class Employee {

    private static final Employee e = new Employee();

    /**
     * 员工号
     */
    private Long empNo;
    /**
     * 员工姓名
     */
    private String eName; //
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
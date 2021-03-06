package com.cronnoss.hrstaffrestapi.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "depid")
    private int depid;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE
            , CascadeType.REFRESH, CascadeType.DETACH}
            , mappedBy = "department")
    private List<Position> poss;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addPositionToDepartment(Position position) {
        if (poss == null) {
            poss = new ArrayList<>();
        }
        poss.add(position);
        position.setDepartment(this);
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Position> getPoss() {
        return poss;
    }

    public void setPoss(List<Position> poss) {
        this.poss = poss;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depid=" + depid +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
package com.cpu.onlyplay.everydayinsist.javadesignpattern.composite.example;

/**
 * @author: cpuRick
 * @createTime: 2022/08/25 9:56
 * @description: it部门
 */
public class ItDepartment extends OrganizationComponent {
    protected ItDepartment(String name) {
        super(name);
    }

    @Override
    void add(OrganizationComponent organizationComponent) {
        throw new UnsupportedOperationException("基础部门，无法添加");
    }

    @Override
    OrganizationComponent getChild(String name) {
        if (name.equals(this.getName())) {
            return this;
        }
        return null;
    }

    @Override
    int getStaffCount() {
        return 20;
    }
}

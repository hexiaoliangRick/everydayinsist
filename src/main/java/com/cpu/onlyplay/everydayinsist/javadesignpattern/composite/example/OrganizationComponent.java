package com.cpu.onlyplay.everydayinsist.javadesignpattern.composite.example;

/**
 * @author: cpuRick
 * @createTime: 2022/08/25 9:46
 * @description: 抽象组织类
 */
public abstract class OrganizationComponent {

    private final String name;

    protected OrganizationComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    /**
     * 添加下级组织
     *
     * @param organizationComponent
     */
    abstract void add(OrganizationComponent organizationComponent);

    /**
     * 获取下级组织
     *
     * @param name
     * @return
     */
    abstract OrganizationComponent getChild(String name);

    /**
     * 获取员工数
     *
     * @return
     */
    abstract int getStaffCount();
}

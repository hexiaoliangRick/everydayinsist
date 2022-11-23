package com.cpu.onlyplay.everydayinsist.javadesignpattern.composite.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author: cpuRick
 * @createTime: 2022/08/25 9:49
 * @description: 组织树干类
 */
public class OrganizationComposite extends OrganizationComponent {

    private final List<OrganizationComponent> organizationComponents = new LinkedList<>();

    protected OrganizationComposite(String name) {
        super(name);
    }

    @Override
    void add(OrganizationComponent organizationComponent) {
        organizationComponent.add(organizationComponent);
    }

    @Override
    OrganizationComponent getChild(String name) {
        for (OrganizationComponent component : organizationComponents
        ) {
            Optional<OrganizationComponent> optional = Optional.ofNullable(component.getChild(name));
            if (optional.isPresent()) {
                return optional.get();
            }
        }
        return null;
    }

    @Override
    int getStaffCount() {
        Integer staffCount = 0;
        for (OrganizationComponent component : organizationComponents
        ) {
            staffCount += component.getStaffCount();
        }
        return staffCount;
    }
}

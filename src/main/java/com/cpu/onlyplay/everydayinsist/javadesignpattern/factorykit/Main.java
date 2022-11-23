package com.cpu.onlyplay.everydayinsist.javadesignpattern.factorykit;

import lombok.var;

import java.util.LinkedList;

/**
 * @author: cpuRick
 * @createTime: 2022/11/08 10:32
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        var factory = WeaponFactory.factory(k -> {
            k.put(WeaponType.AXE, Axe::new);
            k.put(WeaponType.BOW, Bow::new);
            k.put(WeaponType.SPEAR, Spear::new);
        });
        var list = new LinkedList<Weapon>();
        list.add(factory.create(WeaponType.AXE));
        list.add(factory.create(WeaponType.BOW));

    }
}

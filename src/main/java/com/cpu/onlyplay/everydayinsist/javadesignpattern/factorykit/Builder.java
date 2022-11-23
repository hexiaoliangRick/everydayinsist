package com.cpu.onlyplay.everydayinsist.javadesignpattern.factorykit;

import java.util.function.Supplier;

/**
 * @author: cpuRick
 * @createTime: 2022/11/08 10:23
 * @description:
 */
public interface Builder {
    void add(WeaponType name, Supplier<Weapon> supplier);
}

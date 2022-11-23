package com.cpu.onlyplay.everydayinsist.javadesignpattern.factorykit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: cpuRick
 * @createTime: 2022/11/08 10:22
 * @description:
 */
public interface WeaponFactory {


    static WeaponFactory factory(Consumer<Map<WeaponType, Supplier<Weapon>>> consumer) {
        Map<WeaponType, Supplier<Weapon>> map = new HashMap<WeaponType, Supplier<Weapon>>();
        consumer.accept(map);
        return name -> map.get(name).get();
    }

    Weapon create(WeaponType weaponType);
}

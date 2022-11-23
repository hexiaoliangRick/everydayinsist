package com.cpu.onlyplay.everydayinsist.javadesignpattern.decorator;

import java.io.Reader;

/**
 * @author: cpuRick
 * @createTime: 2022/09/27 8:42
 * @description:
 */
public class LuxuryCar implements Car {

    private final SimpleCar simpleCar;

    public LuxuryCar(SimpleCar simpleCar) {
        this.simpleCar = simpleCar;
    }

    @Override
    public void running() {

    }


}

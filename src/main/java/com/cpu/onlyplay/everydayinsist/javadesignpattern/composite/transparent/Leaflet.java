package com.cpu.onlyplay.everydayinsist.javadesignpattern.composite.transparent;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: cpuRick
 * @createTime: 2022/08/25 9:39
 * @description: 树枝
 */
public class Leaflet extends Component {
    private List<Component> children = new LinkedList<>();

    @Override
    void add(Component component) {
        children.add(component);
    }

    @Override
    List<Component> children() {
        return this.children;
    }

    @Override
    void remove(Component component) {
        this.children.remove(component);
    }
}

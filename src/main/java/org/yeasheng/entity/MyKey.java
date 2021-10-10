package org.yeasheng.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author yansh
 * @version 2021/9/14
 **/
@Getter
@Setter
public class MyKey {

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return Objects.equals(name, myKey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.length());
    }

    public MyKey(String name) {
        this.name = name;
    }
}

package org.yeasheng.componet;

import java.util.concurrent.Callable;

/**
 * IntegerSquare类用于计算并返回输入的整数的平方
 */
public class IntegerSquare implements Callable<Integer> {
    private int num; //进行平方运算的数

    public IntegerSquare(int num) {
        this.num = num;
    }

    @Override
    public Integer call() {
        return num * num; //返回num的平方
    }
}



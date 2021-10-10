package org.yeasheng.entity;

import org.yeasheng.componet.ProductRepository;

public class Producer implements Runnable {

    private ProductRepository repository;

    public Producer(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true){
            repository.produce();
        }
    }
}
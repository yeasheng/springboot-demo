package org.yeasheng.entity;

import org.yeasheng.componet.ProductRepository;

public class Consumer implements Runnable {

    private ProductRepository repository;

    public Consumer(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true){
            repository.consume();
        }
    }
}
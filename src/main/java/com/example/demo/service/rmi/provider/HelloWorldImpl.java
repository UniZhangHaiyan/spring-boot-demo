package com.example.demo.service.rmi.provider;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloWorldImpl implements IHelloWorld {

    @Override
    public void say(String username) {
        System.out.println("hello:" + username);
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

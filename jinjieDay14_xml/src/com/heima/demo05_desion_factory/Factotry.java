package com.heima.demo05_desion_factory;

public class Factotry {

    public static Animal getInstance(String s)
    {
        Animal a = null;
        switch (s){
            case "cat":
                a =  new Cat();
                break;
            case "dog":
                a =  new Dog();
                break;
            default:
                break;
        }

        return a;
    }
}

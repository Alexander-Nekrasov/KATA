package main;

import female.FemaleFactory;
import male.MaleFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(FactoryProducer.HumanFactoryType type) {

        if (type == FactoryProducer.HumanFactoryType.MALE) {
            return new MaleFactory();
        } else {
            return new FemaleFactory();
        }
    }

    public enum HumanFactoryType {
        MALE,
        FEMALE
    }
}



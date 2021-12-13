package female;

import main.AbstractFactory;
import main.Human;

public class FemaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age){
        if(age<=KidGirl.MAX_AGE) return new KidGirl();
        else if(age<=TeenGirl.MAX_AGE) return new TeenGirl();
        else return new Woman();
    }
}

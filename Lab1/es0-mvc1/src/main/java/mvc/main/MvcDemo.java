package mvc.main;

import mvc.app.Person;
import mvc.app.PersonController;
import mvc.app.PersonView;

public class MvcDemo {

    public static void main(String[] arg){
        //App initialization
        Person model = fetchPersonFromDatabase();
        PersonView view = new PersonView();
        PersonController controller = new PersonController(model, view);

        //Execution scenario
        controller.updateView();
        controller.setPersonFirstName("Mario");
        controller.updateView();
    }

    private static Person fetchPersonFromDatabase(){
        Person person = new Person("Mariano","Ceccato");
        return person;
    }
}

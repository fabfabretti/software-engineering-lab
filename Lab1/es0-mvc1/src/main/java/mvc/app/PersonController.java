package mvc.app;

public class PersonController {

    // add class field to reference the model and the view
    private Person model = null;
    private PersonView view = null;

    public PersonController(Person model, PersonView view){
        // initialize class
        this.model = model;
        this.view = view;
    }

    public void updateView(){
        // ask the view to display data from the model;
        view.printPersonDetails(model.getFirstName(), model.getLastName());
    }

    public String getPersonFirstName() {
        // read data from the model
        return model.getFirstName();
    }

    public void setPersonFirstName(String firstName) {
        // write data to the model
        model.setFirstName(firstName);
    }

    public String getPersonLastName() {
        // read data from the model
        return model.getLastName();
    }

    public void setPersonLastName(String lastName) {
        // write data to the model
        model.setLastName(lastName);
    }


}

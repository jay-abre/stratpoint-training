// Implementation of Inheritance and Polymorphism
public class Reference {
    private String ISBN;

    public Reference(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    // polymorphism
    public void displayInfo() {
        System.out.println("Type of Publication: ");
    }

}


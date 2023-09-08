public class Animal {
    String denumire, tip;

    public Animal(String denumire, String tip){
        this.denumire = denumire;
        this.tip = tip;
    }

    public static void main(String[] args){
        Animal animal = new Animal("Caine", "mamifer");
        System.out.println(animal.denumire+" "+animal.tip);
    }
}

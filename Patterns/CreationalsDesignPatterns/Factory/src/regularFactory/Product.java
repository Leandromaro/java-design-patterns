package CreationalsDesignPatterns.Factory.src.regularFactory;

abstract class Product {
    public void writeName(String name) {
        System.out.println("My name is "+name);
    }
}

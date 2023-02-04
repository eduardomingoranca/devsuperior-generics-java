import util.List;

public class Main {
    public static void main(String[] args) {
        // TYPE SAFETY -> garante o tipo de dado evitando erro em tempo de execucao
        // Object nao possui type safety

        // verifica o tipo em tempo de compilacao
        List<Double> list = new List<>();

        list.add(3.5);
        list.add(9.2);

        System.out.println(list);

        List<String> list1 = new List<>();

        list1.add("Mary");
        list1.add("John");

        System.out.println(list1);
    }

}
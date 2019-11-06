public class Main {

    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.goldenRatio();
        System.out.println("Золотое сечение:");
        System.out.println("X = " + methods.minGoldenX + ", Y = " + methods.minGoldenY);

        System.out.println();
        System.out.println("Метод парабол:");
        methods.parabolaImpl();
    }

}

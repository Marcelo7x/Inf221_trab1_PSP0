public class Main {

    public static void main(String[] args) {
        Impedimento imp = new Impedimento();
        imp.setAtacantesDefesores();
        imp.setDistancias();
        boolean impedimento = imp.resultado();

        if (impedimento == true) System.out.println("Y"); else System.out.println("N");
    }
}
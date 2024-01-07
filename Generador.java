public class Generador {
    private static int t = 0;
    private static int l = 0;

    public static String nuevaVariable() {
        return "t" + Integer.toString(t++);
    }

    public static String getVariable() {
        int aux = t-1;
        return "t" + Integer.toString(aux);
    }

    public static String nuevaEtiqueta() {
        return "L" + Integer.toString(l++);
    }

}
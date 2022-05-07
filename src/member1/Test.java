package member1;

public class Test {
    public static void main(String[] args) {
        String name = "KwonGuHwna";
        char[] chars = name.toCharArray();
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar + "   (int)aChar="+(int)aChar);
        }
    }
}

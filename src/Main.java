import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(calc("one plus one"));
        System.out.println(calc("twenty one plus one"));
        System.out.println(calc("ninety one plus fifty"));
        System.out.println("___________________________________________");
        System.out.println(code(3));
        System.out.println(code(9));
        System.out.println(code(17));
        System.out.println(code(24));
    }

    //Нужно было написать код, который будет считать используя слова
    //Типо: one plus one=two
    public static String calc(String s) {
        String[] mas = s.toLowerCase().split(" ");
        Map<String, Integer> textToInt = new HashMap<>();
        textToInt.put("zero", 0);
        textToInt.put("one", 1);
        textToInt.put("two", 2);
        textToInt.put("tree", 3);
        textToInt.put("four", 4);
        textToInt.put("five", 5);
        textToInt.put("six", 6);
        textToInt.put("seven", 7);
        textToInt.put("eight", 8);
        textToInt.put("nine", 9);
        textToInt.put("ten", 10);
        textToInt.put("eleven", 11);
        textToInt.put("twelve", 12);
        textToInt.put("thirteen", 13);
        textToInt.put("fourteen", 14);
        textToInt.put("fifteen", 15);
        textToInt.put("sixteen", 16);
        textToInt.put("seventeen", 17);
        textToInt.put("eighteen", 18);
        textToInt.put("nineteen", 19);
        textToInt.put("twenty", 20);
        textToInt.put("thirty", 30);
        textToInt.put("forty", 40);
        textToInt.put("fifty", 50);
        textToInt.put("sixty", 60);
        textToInt.put("seventy", 70);
        textToInt.put("eighty", 80);
        textToInt.put("ninety", 90);
        textToInt.put("hundred", 100);

        int[] a = new int[2];
        int i = 0;
        String operation = "";

        for (String word : mas) {
            if (textToInt.containsKey(word)) {
                int c = textToInt.get(word);
                if (c == 100) {
                    a[i] = a[i] * c;
                } else a[i] += c;
            } else {
                i++;
                operation = word;
            }
        }

        int ans = 0;

        if (operation.equals("plus")) {
            ans = a[0] + a[1];
        }
        if (operation.equals("minus")) {
            ans = a[0] - a[1];
        }
        if (operation.equals("multiplication")) {
            ans = a[0] * a[1];
        }
        if (operation.equals("division")) {
            if (a[1] == 0) {
                throw new RuntimeException("невозможно деление на 0");
            }
            ans = a[0] / a[1];
        }

        if (ans == 0) {
            return "Zero";
        }

        String fin = "";

        while (ans != 0) {
            int b = ans % 100;
            if (textToInt.containsValue(b)) {
                for (String text : textToInt.keySet()) {
                    if (textToInt.get(text) == b) {
                        fin = text + " " + fin;
                        break;
                    }
                }
            }

            if (!fin.isEmpty()) {
                ans = ans / 100;
                if (ans != 0) {
                    fin = "hundred" + " " + fin;
                }
                continue;
            }
            int c = ans % 10;
            if (textToInt.containsValue(c)) {
                for (String text : textToInt.keySet()) {
                    if (textToInt.get(text) == c) {
                        fin = text + " " + fin;
                        break;
                    }
                }
            }
            ans = ans/10 *10;

        }
        return fin.replaceFirst(Character.toString(fin.charAt(0)),Character.toString(fin.charAt(0)).toUpperCase()).trim();
    }

    //Степень двойки и остаток
    public static int code(int num){
        int st = 0;
        while (num > Math.pow(2,st+1)){
            st++;
        }
        int ost = (int) (num-Math.pow(2,st));
        int fin = 0;
        while (st!=0){
            fin+=2;
            fin*=10;
            st--;
        }
        return fin+ost;
    }
}
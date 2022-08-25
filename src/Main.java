import java.util.HashMap;
import java.util.Map;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
            " incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat " +
            "nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia " +
            "deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>(); //мапа для символов и кол-ва раз, которое они встречаются
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.toLowerCase().charAt(i); //приводим символ к нижнему регистру и пробегаемся по символам
            if (!map.containsKey(symbol)) { //символа нет в мапе
                map.put(symbol, 1); //вставляем
            } else { //символ есть в мапе
                int val = map.get(symbol); //вынимаем
                val++; //увеличиваем
                map.put(symbol, val); //вставляем
            }
        }
        System.out.println(map); //мапа частот с которой встречаются символы

        int max = -1;
        char keyMax = 0;
        int min = Integer.MAX_VALUE;
        char keyMin = 0;
        for (char key : map.keySet()) {  //проходимся по мапе
            int value = map.get(key);
            if (key != ' ' && key != '.' && key != ',') { //убираем лишние символы
                if (value > max) {
                    max = value;
                    keyMax = key; //находим максимум
                }
                if (value < min) {
                    min = value;
                    keyMin = key; // находим минимум
                }
            }
        }
        System.out.println("Чаще всего в тексте встречается буква " + keyMax + ". Она повторяется " + max + " раз.");
        System.out.println("Реже всего в тексте встречается буква " + keyMin + ". Она повторяется " + min + " раз.");
    }
}

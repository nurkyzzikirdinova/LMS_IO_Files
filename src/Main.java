import java.util.Arrays;
import java.util.Scanner;

/**1. Параметирине String тибинде соз алып ал созду тескерисинен кылып кайтарган метод туз.

 2. StringBuilder аркылуу создордун массивдерин алып, аларды бир сапка бириктирген метод түз.

 3. Параметирине соз алып ал создун ичинде канча ундуу тамга бар экенин эсептеген метод туз.

 4. StringBuilder жардамы менен берилген. соз палиндром экенин текшеруучу метод туз.

 5. StringBuilder аркылуу сүйлөмдөгү ар бир сөздүн биринчи тамгасын баш тамга менен жазуучу  метод туз.

 6. String жана StringBuilder жардамы менен сүйлөмдөгү сөздөрдүн санын эсептөөчу метод туз.

 7. StringBuilder аркылуу ар бир тамганын өзүнүн ASCII коду менен алмаштырган метод туз.

 8. StringBuilder аркылуу cуйломдон бардык боштуктарды (пробелдерди) алып салуучу метод туз.*/
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write word for reverse: ");
        System.out.println("Word in reverse method: " + reversed(scanner.nextLine()));

        System.out.println("Write 2 words for arrays split: ");
        String[] words = scanner.nextLine().split(" ");
        System.out.println("Concatenation words: " + concat(words));

        System.out.println("Write word to count vowels: ");
        System.out.println("Vowels : " + countVowelsAl(scanner.nextLine()));

        System.out.println("Write word check palindrome: ");
        System.out.println("This word is palindrome?  " + isPalindrome(scanner.nextLine()));

        System.out.println("Write word capitalize: ");
        System.out.println(capitalizeWord("Capitalive words: "+ capitalizeWord(scanner.nextLine())));

        String sentence = scanner.nextLine();
        StringBuilder sentenceBuilder = new StringBuilder(scanner.nextLine());

        System.out.println("Word of sentence (String): " + wordsString(sentence));
        System.out.println("Word of sentence (StringBuilder): " +wordsStringBuilder(sentenceBuilder));
        System.out.println("Device sentence: ");
        System.out.println("Sentence word in ASCII code: "+replaceASCII(scanner.nextLine()));

        System.out.println("Device sentence: ");
        System.out.println("Sentence without white space: "+removeSpace(scanner.nextLine()));
        scanner.close();
    }

    
    public static String reversed(String word) {
        StringBuilder rev = new StringBuilder(word);
        return rev.reverse().toString();
    }

    public static String concat(String[] words) {
        StringBuilder con = new StringBuilder();
        for (String word : words) {
            con.append(word);
        }
        return con.toString();
    }

    public static int countVowelsAl(String word) {
        int count = 0;
        String vowels = "aeiouAEIOUаеиуэАЭЕУИ";
        for (int i = 0; i < word.length(); i++) {
            if (vowels.contains(String.valueOf(word.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPalindrome(String word) {
        word = word.replaceAll("\\W", "");
        StringBuilder strBuilder = new StringBuilder(word);
        strBuilder.reverse();
        String invertedText = strBuilder.toString();

        return word.equalsIgnoreCase(invertedText);
    }

    public static String capitalizeWord(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char chars : word.trim().toCharArray()) {
            chars = capitalizeNext ? Character.toUpperCase(chars) : chars;
            capitalizeNext = chars == ' ';
            result.append(chars);
        }

        return result.toString();
    }
    public static int wordsString(String sentence) {
        return sentence == null ? 0 : sentence.trim().split("\\s+").length;
    }

    public static int wordsStringBuilder(StringBuilder sentence) {
        return sentence == null ? 0 : sentence.toString().split("\\s+").length;
    }
    public static String replaceASCII(String word) {
        StringBuilder ascii = new StringBuilder();
        for (char w : word.toCharArray()) {
            ascii.append((int) w).append(" ");
        }
        return ascii.toString().trim();
    }
    public static String removeSpace(String sentence) {
        StringBuilder result = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}


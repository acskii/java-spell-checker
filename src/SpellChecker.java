import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SpellChecker {
    final static String dictionaryFilePath = "Dictionary.txt";
    static long wordCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = load_bst_from_dictionary();
        Node previous = null;
        System.out.println("< Dictionary Spell Check >");
        System.out.printf("Word Count: %d\n", wordCount);
        System.out.printf("Height: %d\n", BST.heightBST(root));

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            System.out.print(word);
            Node searched = BST.searchBST(root, null, word);
            if (searched != null && searched.val.equalsIgnoreCase(word)) {
                System.out.print(" - Correct\n");
            } else {
                System.out.print(" - Incorrect, Suggestions: ");
                Node pred = BST.getPredecessor(root, searched);
                Node succ = BST.getSuccessor(root, searched);
                System.out.printf("%s, %s, %s\n", searched.val, succ.val, pred.val);
            }
        }
    }

    private static Node load_bst_from_dictionary() {
        try {
            List<String> list = Files.readAllLines(Paths.get(dictionaryFilePath));
            Node root = null;

            for (String line: list) {
                wordCount++;
                root = BST.insertToBST(root, line);
            }

            return root;

        } catch (IOException e) {
            System.out.printf("Couldn't find file at %s\n", dictionaryFilePath);;
        }

        return null;
    }
}

import java.util.*;

public class mathRelations {
    static Scanner sc = new Scanner(System.in);

    public static void enter(int n) {
        boolean mat[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Please enter true/false for (" + (i + 1) + "," + (j + 1) + ")");
                mat[i][j] = sc.nextBoolean();
            }
        }
        System.out.println("----------------");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
        System.out.println("Checker for Reflexive Relation is: " + reflexive(mat, n));
        System.out.println("----------------");
        System.out.println("Checker for Irreflexive Relation is: " + irreflexive(mat, n));
        System.out.println("----------------");
        System.out.println("Checker for Symmetric Relation is: " + symmetric(mat, n));
        System.out.println("----------------");
        System.out.println("Checker for Asymmetric Relation is: " + (!symmetric(mat, n)));
        System.out.println("----------------");
        System.out.println("Checker for Transitive Relation is: " + transitive(mat, n));
        System.out.println("----------------");
        System.out.println("Checker for Anti-Symmetric Relation is: " + antisymmetric(mat, n));
    }

    public static boolean reflexive(boolean mat[][], int n) {
        for (int i = 0; i < n; i++) {
            if (!mat[i][i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean irreflexive(boolean mat[][], int n) {
        for (int i = 0; i < n; i++) {
            if (mat[i][i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean symmetric(boolean mat[][], int n) {
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (mat[i][j] != mat[j][i]) {
                return false;
            }
        }
    }
    return true;
}



    public static boolean transitive(boolean mat[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (mat[i][j] && mat[j][k] && !mat[i][k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean antisymmetric(boolean mat[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] && mat[j][i] && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println("Please enter the size of the matrix:");
        int n = sc.nextInt();
        enter(n);
    }
}

public class Q_10Group{
    public static int getOrder(int element, int prime) {
        int order = 1;
        int result = element % prime;

        while (result != 1) {
            result = (result * element) % prime;
            order++;
        }

        return order;
    }

    public static void main(String[] args) {
        int ele = 2; 
        int pr = 5;   

        int order = getOrder(ele, pr);
        System.out.println("The order of " + ele + " modulo " + pr + " is: " + order);
    }
}

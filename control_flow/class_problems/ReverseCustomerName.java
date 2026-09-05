public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();

        String reversed = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            reversed = reversed + characters[i];
        }

        return reversed;
    }

    public static void main(String[] args) {

        String customerName = "Sunil";

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }
}
class Trash {

    public static String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            ans.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(66));
    }
}

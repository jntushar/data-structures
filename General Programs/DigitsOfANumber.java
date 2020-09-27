public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        for(char c : String.valueOf(num).toCharArray()) {
			System.out.println(c);
		}
    }
}
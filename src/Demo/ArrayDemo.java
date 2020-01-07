package Demo;

public class ArrayDemo {

    public static void main(String[] args) {
        int[][] array = createArray();
        printArray(array);
    }

    private static int[][] createArray() {
        int[][] array = new int[5][5];
        for(int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for(int colIndex = 0; colIndex < array[0].length; colIndex++) {
                array[rowIndex][colIndex] = (int) (Math.random() * 10);
            }
        }
        return array;
    }

    private static void printArray(int[][] array) {
        for(int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for(int colIndex = 0; colIndex < array[0].length; colIndex++) {
                System.out.print(array[rowIndex][colIndex] + " | ");
            }
            System.out.print("\n");
        }
    }

}

package Sorting;

import de.ur.mi.oop.graphics.Image;

import java.util.Arrays;

/**
 * Diese Demo demonstriert eine einfache Implementierung des Bubble Sort-Algorithmus am Beispiel eines int-Arrays.
 */

public class App {

    /* Feste Werte für die obere Grenze der zufälligen Werte des Arrays und dessen Länge */
    private static final int MAX_VALUE = 100;
    private static final int ARRAY_LENGTH = 10;

    public static void main(String[] args) {
        int[] array = createArray(ARRAY_LENGTH);
        printArray(array, "Unsorted");
        sortArray(array);
        printArray(array, "Sorted");
    }

    /* Gibt ein int-Array der übergebenen Länge zurück, das mit zufälligen Werten befüllt ist */
    private static int[] createArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * (MAX_VALUE + 1));
        }
        return array;
    }

    /* Sortiert das übergebene int-Array mit dem Bubble Sort-Mechanismus */
    private static void sortArray(int[] array) {
        // Äußere Schleife für den Start-Index der einzelnen Sortiervorgänge ...
        for (int i = 1; i < array.length; i++) {
            // Innere Schleife über den noch nicht sortierten Bereich
            for (int j = 0; j < array.length - i; j++) {
                // Prüfung der beiden direkten Nachbarn
                if (array[j] > array[j + 1]) {
                    // Positionstausch mithilfe eines Zwischenspeichers
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }

    /**
     * Gibt die Inhalte des übergebenen Arrays zeilenweise aus. Der Ausgabe wird die ebenfalls übergebene Überschrift
     * vorangestellt. Index und Wert werden bei der Ausgabe normalisiert, d.h. alle Strings werden durch führende '0'
     * auf eine einheitliche Länge gebracht.
     */
    private static void printArray(int[] array, String header) {
        int maxIndexDigits = String.valueOf(array.length).length();
        int maxValueDigits = String.valueOf(MAX_VALUE).length();
        System.out.println("### " + header + " ###");
        for (int i = 0; i < array.length; i++) {
            String index = normalizeStringLength(String.valueOf(i + 1), maxIndexDigits);
            String value = normalizeStringLength(String.valueOf(array[i]), maxValueDigits);
            System.out.println(index + ":\t" + value);
        }
    }

    private static String normalizeStringLength(String value, int length) {
        while (value.length() < length) {
            value = "0".concat(value);
        }
        return value;
    }


}

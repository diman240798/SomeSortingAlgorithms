import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {
    private static final double HAIRBRUSH_COEFFICENT = 1.247;
    static int stepCounter = 0;

    static void sillySorting(List<Integer> list) {
        printList(list);
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; i++) {
            stepCounter += 1;
            int a1 = list.get(i);
            int a2 = list.get(i + 1);
            if (a1 > a2) {
                flag = true;
                list.set(i, a2);
                list.set(i + 1, a1);
            }
        }
        if (flag)
            sillySorting(list);
    }

    static void bubbleSorting(List<Integer> list, int max) {
        printList(list);
        boolean flag = false;
        for (int i = 0; i < max; i++) {
            stepCounter += 1;
            int a1 = list.get(i);
            int a2 = list.get(i + 1);
            if (a1 > a2) {
                flag = true;
                list.set(i, a2);
                list.set(i + 1, a1);
            }
        }
        if (flag)
            bubbleSorting(list, max - 1);
    }

    static void shakerSorting(List<Integer> list, int min, int max) {
        printList(list);
        boolean flag = false;
        for (int i = min; i < max; i++) {
            stepCounter += 1;
            int a1 = list.get(i);
            int a2 = list.get(i + 1);
            if (a1 > a2) {
                flag = true;
                list.set(i, a2);
                list.set(i + 1, a1);
            }
        }
        printList(list);
        for (int i = max - 1; i > min; i--) {
            stepCounter += 1;
            int a1 = list.get(i - 1);
            int a2 = list.get(i);
            if (a1 > a2) {
                flag = true;
                list.set(i - 1, a2);
                list.set(i, a1);
            }
        }
        if (flag)
            shakerSorting(list, min + 1, max - 1);
    }

    private static void oddEvenSorting(List<Integer> list) {
        printList(list);
        boolean flag = false;
        for (int i = 0; i < list.size() - 1; i += 2) {
            stepCounter += 1;
            int a1 = list.get(i);
            int a2 = list.get(i + 1);
            if (a1 > a2) {
                list.set(i, a2);
                list.set(i + 1, a1);
            }
        }
        printList(list);
        for (int i = 1; i < list.size() - 2; i += 2) {
            stepCounter += 1;
            int a1 = list.get(i);
            int a2 = list.get(i + 1);
            if (a1 > a2) {
                flag = true;
                list.set(i, a2);
                list.set(i + 1, a1);
            }
        }
        if (flag)
            oddEvenSorting(list);
    }

    private static void hairbrushSorting(List<Integer> list, int difference) {
        printList(list);
        boolean flag = false;
        for (int i = 0; i < list.size() - difference; i++) {
            stepCounter += 1;
            int a1 = list.get(i);
            int a2 = list.get(i + difference);
            if (a1 > a2) {
                flag = true;
                list.set(i, a2);
                list.set(i + difference, a1);
            }
        }
        if (flag)
            if (difference == 1) {
                hairbrushSorting(list, 1);

            } else
                hairbrushSorting(list, (int) (difference / HAIRBRUSH_COEFFICENT));
    }


    private static void printList(List<Integer> list) {
        System.out.println(list.toString());
    }

    public static List<Integer> createShuffledSequence() {
        return Arrays.asList(5, 7, 6, 1, 0, 3, 9, 8, 4, 2);

    }

    private static void printNumberOfStepsAndRefreshStepConter() {
        System.out.println(String.format("number of steps taken is: %d\n", stepCounter));
        stepCounter = 0;
    }

    public static void main(String[] args) {
        System.out.println("Silly Sorting");
        System.out.println("/////////////////");
        List<Integer> shuffledSequence = createShuffledSequence();
        sillySorting(shuffledSequence);
        printNumberOfStepsAndRefreshStepConter();

        System.out.println("Bubble Sorting");
        System.out.println("/////////////////");
        shuffledSequence = createShuffledSequence();
        bubbleSorting(shuffledSequence, shuffledSequence.size() - 1);
        printNumberOfStepsAndRefreshStepConter();

        System.out.println("Shaker Sorting");
        System.out.println("/////////////////");
        shuffledSequence = createShuffledSequence();
        shakerSorting(shuffledSequence, 0, shuffledSequence.size() - 1);
        printNumberOfStepsAndRefreshStepConter();

        System.out.println("Odd-Even Sorting");
        System.out.println("/////////////////");
        shuffledSequence = createShuffledSequence();
        oddEvenSorting(shuffledSequence);
        printNumberOfStepsAndRefreshStepConter();

        System.out.println("Hairbrush Sorting");
        System.out.println("/////////////////");
        shuffledSequence = createShuffledSequence();
        hairbrushSorting(shuffledSequence, (int) (shuffledSequence.size() / HAIRBRUSH_COEFFICENT));
        printNumberOfStepsAndRefreshStepConter();

    }
}

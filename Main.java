import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int[] arr = {5, 9, 22, 61, 901, 44, -85};
        String[] str1 = {"aaa", "bbb", "ccc"};
        String[] str2 = {"mmm", "bbb","ddd", "eee", "kkk", "fff"};
        Integer[] arr1 = {5, 9, 22, 61, 901, 44, -85};

        // myIncludes() method call
        System.out.println(myIncludes(arr1, 5));

        // myFindLastIndex() method call
        System.out.println("The last index is: " + myFindLastIndex(arr, n -> n % 2 == 0));

        // myFindIndex() method call
        System.out.println("The index is: " + myFindIndex(arr, n -> n % 2 == 0));

        // myFind() method call
        int number = myFind(arr, n -> n % 2 == 0);
        System.out.println("number is : " + number);

        // myFill() method call
        Integer[] num = {1, 2, 3, 4, 5};
        Integer[] filledArray = myFill(num, -1, 2);
        System.out.println("Filled array: " + Arrays.toString(filledArray));

        // myEntries() method call
        Map<Integer, String> entries = myEntries(str2);
        for (Map.Entry<Integer, String> entry : entries.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // mySort() method call
        String[] sortedArray = mySort(str2, Comparator.naturalOrder());
        for (var el : sortedArray)
          System.out.println(el);

        // mySome() method call
        boolean resultOfSome = mySome(arr, n -> n % 2 !=0);
        System.out.println(resultOfSome);
        // mySlice() method call
        String[] newStr2 = mySlice(str2, 2, 3);
        for (var el : newStr2)
            System.out.println(el);

        // myRevrse() method call
        String[] newStr1 = myReverse(str1);
        for (var el : newStr1)
         System.out.println(el);

        // myOtherMap() method call
        int[] array = myOtherMap(arr, n -> n == 99);
        for (var el : array)
         System.out.println(el);

        // myMap() method call
        int[] newArr = myMap(arr, n -> n * 2);
        for (var el : newArr)
          System.out.println(el);

        // myLastIndexOf() method call
        String str = "Hello, world!";
        String target = "world";
        int index = myLastIndexOf(str, target);
        System.out.println("Index of '" + target + "' in '" + str + "' with myLastIndexOf() is : " + index);

        // myIndexOf() method call
        String str5 = "Hello, world!";
        String target5 = "world";
        int index5 = myIndexOf(str5, target5);
        System.out.println("Index of '" + target5 + "' in '" + str5 + "' is : " + index5);

        // myForEach() method call
        Integer[] numbers = {1, 2, 3, 4, 5};
        myForEach(numbers, System.out::println);
        myForEach(str1, System.out::println);

        // myFilter() method call
        int[] arrFromFilter = myFilter(arr, n -> n < 10);
        System.out.print("The array after filtering is: ");
        for (var num1 : arrFromFilter)
         System.out.print(num1 + " ");
        System.out.println();

        // myEvery() method call
        boolean allEven = myEvery(arr, n -> n % 2 == 0);
        System.out.println("Are all numbers even? " + allEven);

        // myConcat() method call
        String[] concatArray = m.myConcat(str1, str2);
        for (String element : concatArray) {
            System.out.println(element);
        }

        // myWith() method call
        int[] new_arr = myWith(arr, -3, -1);
        for (int i = 0; i < new_arr.length; ++i)
            System.out.println(new_arr[i]);

        //myJion() method call
        System.out.println(myJoin(arr, "|"));

    }

    /**
     * Checks if a value exists in the given array.
     *
     * @param <T>   the type of the elements in the array
     * @param arr the array to be checked
     * @param value the value to search for in the array
     * @return true if the value exists in the array, false otherwise
     */

    public static <T> boolean myIncludes(T[] arr, T value) {
        return Arrays.asList(arr).contains(value);
    }

    /**
     * Finds the last index of an element in the given array that satisfies the provided condition.
     *
     * @param arr       the array to be searched
     * @param condition the condition to be satisfied by the element
     * @return the last index of the element satisfying the condition, or -1 if no such element is found
     */
    public static  int myFindLastIndex(int[] arr, IntPredicate condition) {
        for (int i = arr.length - 1; i >= 0; --i) {
            if (condition.test(arr[i])) {
                return i;
            }
        }
        System.out.println("No element in the given array which satisfies given condition.");
        return -1;
    }

    /**
     * Finds the first index of an element in the given array that satisfies the provided condition.
     *
     * @param arr       the array to be searched
     * @param condition the condition to be satisfied by the element
     * @return the first index of the element satisfying the condition, or -1 if no such element is found
     */
    public static int myFindIndex(int[] arr, IntPredicate condition) {
        for (int i = 0; i < arr.length; ++i) {
            if (condition.test(arr[i])) {
                return i;
            }
        }
        System.out.println("No element in the given array which satisfies given condition.");
        return -1;
    }

    /**
     * Finds the first element in the given array that satisfies the provided condition.
     *
     * @param arr       the array to be searched
     * @param condition the condition to be satisfied by the element
     * @return the first element satisfying the condition, or -1 if no such element is found
     */
    public static int myFind(int[] arr, IntPredicate condition) {
        for (var el : arr) {
            if (condition.test(el)) {
                return el;
            }
        }
        System.out.println("No element in the given array which satisfies given condition.");
        return -1;
    }

    /**
     * Fills a portion of the given array with the specified value, starting from the specified position.
     *
     * @param <T>    the type of the elements in the array
     * @param array  the array to be filled
     * @param value  the value to fill the array with
     * @param start  the starting position from which to fill the array
     * @return the original array after filling the specified portion with the value
     * @throws IllegalArgumentException      if the array is null
     * @throws IndexOutOfBoundsException     if the start position is invalid
     */
    public static <T> T[] myFill(T[] array, T value, int start) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        if (start < 0 || start >= array.length) {
            throw new IndexOutOfBoundsException("Invalid start position.");
        }
        Arrays.fill(array, start, array.length, value);
        return array;
    }

    /**
     * Creates a map containing the entries of the given array, with the array indices as keys and the array elements as values.
     *
     * @param <T>    the type of the elements in the array
     * @param array  the array from which to create the map
     * @return a map containing the entries of the array, with indices as keys and elements as values
     */
    public static <T> Map<Integer, T> myEntries(T[] array) {
        Map<Integer, T> map = new LinkedHashMap<>();
        for (int i = 0; i < array.length; ++i) {
            map.put(i, array[i]);
        }
        return map;
    }

    /**
     * Sorts the elements of the given array in ascending order according to the provided comparator.
     *
     * @param <T>        the type of the elements in the array
     * @param arr        the array to be sorted
     * @param comparator the comparator to determine the order of the elements
     * @return the sorted array
     */
    public static <T> T[] mySort(T[] arr, Comparator<T> comparator) {
        Arrays.sort(arr, comparator);
       return arr;
    }

    /**
     * Checks if at least one element in the given array satisfies the provided condition.
     *
     * @param arr       the array to be checked
     * @param condition the condition to be satisfied by an element
     * @return true if at least one element satisfies the condition, false otherwise
     */
    public static  boolean mySome(int[] arr, IntPredicate condition) {
        for (var num : arr)
            if (condition.test(num))
                return true;
        return false;
    }

    /**
     * Creates a new array containing a portion of the given array, starting from the specified start index and ending at the specified end index.
     *
     * @param <T>       the type of the elements in the array
     * @param arr       the array from which to create the slice
     * @param startInd  the starting index of the slice (inclusive)
     * @param endInd    the ending index of the slice (inclusive)
     * @return a new array containing the elements from the start index to the end index, or an empty array if the indices are invalid
     */
    public static <T> T[] mySlice(T[] arr, int startInd, int endInd) {
        int size = endInd - startInd + 1;
        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), size);;
        if (startInd <= endInd && startInd >= 0 && endInd <= arr.length - 1) {
            int i = 0;
            while (startInd <= endInd) {
               newArr[i++] = arr[startInd++];
            }
        }
        return newArr;
    }

    /**
     * Reverses the order of elements in the given array.
     *
     * @param <T>   the type of the elements in the array
     * @param arr   the array to be reversed
     * @return the reversed array
     */
    public static <T> T[] myReverse(T[] arr) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;
        if (size != 0) {
            T temp;
            while (start < end) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                ++start;
                --end;
            }
        }
        return arr;
    }

    /**
     * Filters out elements from the given array based on the provided condition and returns a new array with the remaining elements.
     *
     * @param arr         the array to be filtered
     * @param condition   the condition to be satisfied by an element
     * @return a new array containing the elements that do not satisfy the condition
     */
    public static int[] myOtherMap(int[] arr, IntPredicate condition) {
        int count = arr.length;
        for (var el : arr) {
            if (condition.test(el)) {
                --count;
            }
        }
        int[] newArr = new int[count];
        int j = 0;
        for (var el : arr) {
            if (condition.test(el)) {
                continue;
            }
            newArr[j++] = el;
        }
        return newArr;
    }

    /**
     * Applies the provided function to each element in the given array and returns a new array with the results.
     *
     * @param arr        the array to be mapped
     * @param function   the function to apply to each element
     * @return a new array containing the results of applying the function to each element
     */
    public static int[] myMap(int[] arr, UnaryOperator<Integer> function) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = function.apply(arr[i]);
        }
        return newArr;
    }

    /**
     * Returns the last occurrence index of the target string within the given string.
     *
     * @param str     the string to search within
     * @param target  the target string to search for
     * @return the index of the last occurrence of the target string, or -1 if the target is not found or if either of the input strings is null or empty
     */
    public static int myLastIndexOf(String str, String target) {
        if (str == null || target == null || target.length() == 0) {
            return -1;
        }
        int strLength = str.length();
        int targetLength = target.length();
        for (int i = strLength - targetLength; i >= 0; i--) {
            if (str.charAt(i) == target.charAt(0)) {
                int j;
                for (j = 1; j < targetLength; j++) {
                    if (str.charAt(i + j) != target.charAt(j)) {
                        break;
                    }
                }
                if (j == targetLength) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the index of the first occurrence of the target string within the given string.
     *
     * @param str     the string to search within
     * @param target  the target string to search for
     * @return the index of the first occurrence of the target string, or -1 if the target is not found or if either of the input strings is null or empty
     */
    public static int myIndexOf(String str, String target) {
        if (str == null || target == null || target.length() == 0) {
            return -1;
        }
        int strLength = str.length();
        int targetLength = target.length();
        for (int i = 0; i <= strLength - targetLength; i++) {
            if (str.charAt(i) == target.charAt(0)) {
                int j;
                for (j = 1; j < targetLength; j++) {
                    if (str.charAt(i + j) != target.charAt(j)) {
                        break;
                    }
                }
                if (j == targetLength) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Performs the specified action on each element of the given array.
     *
     * @param arr      the array to iterate over
     * @param action   the action to be performed on each element
     * @param <T>      the type of elements in the array
     */
    public static <T> void myForEach(T[] arr, Consumer<? super T> action) {
        for (T element : arr) {
            action.accept(element);
        }
    }

    /**
     * Filters the elements of the given integer array based on the specified condition.
     *
     * @param arr        the array to be filtered
     * @param condition  the condition to test each element against
     * @return a new array containing the elements that satisfy the condition
     */
    public static int[] myFilter(int[] arr, IntPredicate condition) {
        int count = 0;
        for (var num : arr) {
            if (condition.test(num)) {
                ++count;
            }
        }
        int[] newArr = new int[count];
        if (count == 0)
            return newArr;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (condition.test(arr[i])) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }

    /**
     * Checks if every element in the given integer array satisfies the specified condition.
     *
     * @param arr        the array to be checked
     * @param condition  the condition to test each element against
     * @return true if every element satisfies the condition, false otherwise
     */
    public static boolean myEvery(int[] arr, IntPredicate condition) {
        for (int num : arr) {
            if (!condition.test(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Concatenates two arrays of the same type into a single array.
     *
     * @param arr1  the first array to be concatenated
     * @param arr2  the second array to be concatenated
     * @param <T>   the type of elements in the arrays
     * @return a new array containing the elements from both input arrays in the same order
     */
    public <T> T[] myConcat(T[] arr1, T[] arr2) {
        int size = arr1.length + arr2.length;
        T[] result = (T[]) Array.newInstance(arr1.getClass().getComponentType(), size);
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    /**
     * Joins the elements of the given integer array into a single string using the specified separator.
     *
     * @param arr  the array of integers to be joined
     * @param sep  the separator to be used between elements
     * @return a string that contains the joined elements with the separator
     */
    public static String myJoin(int[] arr, String sep) {
        String str = Integer.toString(arr[0]);
        for (int i = 1; i < arr.length; ++i)
            str = (i != arr.length - 1) ? str + arr[i] + sep : str + arr[i];
        return str;
    }

    /**
     * Creates a new integer array by replacing the element at the specified index with the given value.
     *
     * @param arr    the original array of integers
     * @param index  the index of the element to be replaced
     * @param value  the new value to be assigned at the specified index
     * @return a new array with the element at the specified index replaced by the new value
     */
    public static int[] myWith(int[] arr, int index, int value) {
        int[] new_arr = new int[arr.length];
        for (int i = 0; i < arr.length; ++i)
            new_arr[i] = (i == index) ? value : arr[i];
        return new_arr;
    }
}
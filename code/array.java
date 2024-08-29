import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class array {
    
    //Write a function oddEvenSort(int arr[]) in Java (or any language) to read a list of 10 integer 
    //numbers and arrange them in such a manner that all the even numbers start from the left and all 
    //the odd numbers start from the right.
     
    public static void oddToEven(int[] arr) {
      int i=0;
        for(int j=0 ; j<arr.length;j++){
            if (arr[j]%2!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }    
        //System.out.println(Arrays.toString(arr));
    }

    //Write a function named noDup(int 2darr[], int 1darr[]) that takes a 2D array of size 4x5 and 
    //a 1D array of size 20. It should then copy all the elements of 2D array into 1D array but should 
    //avoid duplication. 

    public static void noDup(int[][] arr2D, int[] arr1D) {
        
        int index = 0;
        
        for (int i = 0; i < arr2D.length; i++) {    // no of col in single row
            for (int j = 0; j < arr2D[i].length; j++) { 
                int element = arr2D[i][j];

                // Check if the element already exists in the 1D array
                boolean isDuplicate = false;
                for (int k = 0; k < index; k++) {
                    if (arr1D[k] == element) {
                        isDuplicate = true;
                        break;
                    }
                }
                // If the element is not a duplicate, add it to the 1D array
                if (!isDuplicate && index < arr1D.length) {
                    arr1D[index++] = element;
                }
            }
        }
        
      // Print the 1D array
      for (int i=0;i<=index;i++) 
        System.out.print(arr1D[i] + " ");
    }

    public static String[] tokenizeFile(String filePath) {
        String[] wordsArray = new String[1000];
        int index=0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into words based on spaces and ignore punctuation
                String[] words = line.split("[^a-zA-Z0-9]+");  //String[] words = line.split("\\s+");


                // Add tokens to the array until it reaches the size of 1000
                for (String word : words) {
                    if (index < wordsArray.length) {
                        wordsArray[index++] = word;
                    } else {
                        // If array is full, break out of the loop
                        break;
                    }
                }
                if (index >= wordsArray.length) {
                    break;
                }
        }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(index);
        return wordsArray;
    }

    public static String[] extractEmail(String fileName) {
        String[] emailArray = new String[100]; // Fixed-size array
        int emailCount = 0;
        Pattern emailPattern = Pattern.compile(
            "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}" );  //This regex pattern is designed to match most common email formats.
        

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = emailPattern.matcher(line);  //Used to find occurrences of the pattern in each line of the file.
                while (matcher.find() && emailCount < emailArray.length) {
                    emailArray[emailCount++] = matcher.group();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Truncate the array if necessary
        ///If fewer emails are found than the array size, the array is truncated to the exact number of emails found.
        if (emailCount < emailArray.length) {
            String[] truncatedArray = new String[emailCount];
            System.arraycopy(emailArray, 0, truncatedArray, 0, emailCount);
            return truncatedArray;
        }

        return emailArray;
    }

    public static void extractBoundaries(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        // We will use a single loop to cover all boundary elements.
        for (int i = 0; i < rows; i++) {
            // Print first row (i == 0)
            if (i == 0) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(arr[0][j] + " ");
                }
            }

            // Print last row (i == rows - 1)
            if (i == rows - 1 && rows > 1) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(arr[rows - 1][j] + " ");
                }
            }

            // Print first column (excluding first and last row)
            if (i > 0 && i < rows - 1) {
                System.out.print(arr[i][0] + " ");
            }

            // Print last column (excluding first and last row)
            if (i > 0 && i < rows - 1) {
                System.out.print(arr[i][cols - 1] + " ");
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        /*int[] numbers = {12, 17, 70, 15, 22, 65, 21, 90, 34, 45};
        
        System.out.println("Original Array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        oddToEven(numbers);

        System.out.println("\n\nArray after separating even and odd numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
            */

           /* int[][] arr2D = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 2}
            };
    
            int[] arr1D = new int[20];
            noDup(arr2D, arr1D);  */


        String filePath = "sample2_emails.txt"; 
        //String[] tokens = tokenizeFile(filePath);

        //for (String token : tokens) {
          //  System.out.println(token);

        String[] emails = extractEmail(filePath);

        // Print the extracted emails
        for (String email : emails) {
            System.out.println(email);
    }
}
}
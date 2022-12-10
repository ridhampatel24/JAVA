import java.util.*;
public class Quick_Sort {
    static int count = 0;
    static int partition(int arr[], int low, int high){


		int pivot = arr[high];
        count++;
	
		int i = (low-1); 
        count++;
		for (int j = low; j < high; j++){
            count++;
			if (arr[j] < pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
                count += 4;
			}
		}

		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
        count += 4;

		return i+1;
	}

	static void quick_sort(int arr[], int low, int high){
		if (low < high){
			int pi = partition(arr, low, high);
            count++;

			quick_sort(arr, low, pi-1);
			quick_sort(arr, pi+1, high);
            count+= 2;
		}
	}

	static void printArray(int arr[]){
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String args[]){
		int n = 10;
        Random random = new Random();
		int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

		quick_sort(arr, 0, n-1);
        System.out.println(count);

		//System.out.println("Sorted array");
		//printArray(arr);
	}
}

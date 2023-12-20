package k_largest;

import java.util.ArrayList;

public class Solution {
    public static void heapify(int arr[],int i,int length){
        int largest=i;
        int l=2*i + 1;
        int r=2*i + 2;

        if(l<length && arr[l]>arr[largest]){
            largest=l;
        }
        if(r<length && arr[r]>arr[largest]){
            largest=r;
        }

        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapify(arr,largest,length);
        }

    }

    public static void HeapSort(int arr[]){

        for(int i=(arr.length/2)-1;i>=0;--i){
            heapify(arr,i,arr.length);

        }

        int n=arr.length;

        for(int i=n-1;i>=0;--i){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr, 0,i);
        }
    }

    public static ArrayList<Integer> kLargest(int input[],int k){
        if(input.length==0){
            return null;
        }

        HeapSort(input);
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=input.length-k;i<input.length;++i){
            ans.add(input[i]);
        }

        return ans;
    }

    
}

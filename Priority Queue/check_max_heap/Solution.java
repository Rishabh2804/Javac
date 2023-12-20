package check_max_heap;

public class Solution {

    private static boolean checkMaxHeap(int arr[],int si,int ei){
        if(si==ei || si>ei){
            return true;
        }

        int l=2*si + 1;
        int r=2*si + 2;

        int leftChild=Integer.MIN_VALUE;
        int rightChild=Integer.MIN_VALUE;

        if(l<arr.length)
            leftChild=arr[l];
        if(r<arr.length)
            rightChild=arr[r];   

        if(arr[si]<leftChild || arr[si]<rightChild){
            return false;
        }

        return checkMaxHeap(arr,2*si + 1,ei) && checkMaxHeap(arr,2*si + 2,ei);
    }

    public static boolean checkMaxHeap(int arr[]){
        return checkMaxHeap(arr,0,arr.length-1);
    }
    
    
}

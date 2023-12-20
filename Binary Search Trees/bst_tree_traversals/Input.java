package bst_tree_traversals;

import java.util.Scanner;

public class Input {
    private static Scanner s=new Scanner(System.in);

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		if(n==0)
           return null;

         int mid=(n-1)/2;
         BinaryTreeNode<Integer> root=new BinaryTreeNode<>(arr[mid]);

         int[] left=new int[mid];
         int[] right=new int[n-mid-1];

         for(int i=0;i<n;++i){
             if(i<mid)
                left[i]=arr[i];
             else if(i>mid)
                right[i-mid-1]=arr[i];   
         }

         root.left=SortedArrayToBST(left, mid);
         root.right=SortedArrayToBST(right, n-mid-1);

         return root;
    }

    public static BinaryTreeNode<Integer> takeInput(){
        System.out.print("Enter no. of nodes: ");
        int n=s.nextInt();
        int[] arr=new int [n];

        System.out.print("Enter BST elements: ");
        for(int i=0;i<n;++i)
           arr[i]=s.nextInt();

        return SortedArrayToBST(arr, n);
    }
}

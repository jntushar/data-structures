/*

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12

*/


import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] rb = new int[n];
        Stack<Integer> st = new Stack<>();
        rb[n-1] = n;
        st.push(n-1);
        for(int i = n-2; i>=0; i--){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i] = arr.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }


        int[] lb = new int[n];
        st = new Stack<>();
        lb[0] = -1;
        st.push(0);
        for(int i=1; i<arr.length; i++){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i] = -1;
            }else{
                lb[i] = st.peek();
            }
            st.push(i);
        }
        

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        
        System.out.println(maxArea);
    }
}

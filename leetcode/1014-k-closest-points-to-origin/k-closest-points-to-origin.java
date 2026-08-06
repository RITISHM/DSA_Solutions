class Solution {

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    double distance(int index , int[][] points){
        int x = points[index][0];
        int y = points[index][1];
        return Math.sqrt((x * x) + (y * y));
    }

    public int quickSelect(int L, int R,int [] orignalIndex, int[][] points){

        int pivotIndex = L;
        int i = L + 1;
        int j = R;

        while(i <= j){
            while(i <= R && distance(orignalIndex[i], points) <= distance(orignalIndex[pivotIndex],points)) i++;
            while(j >= L - 1 && distance(orignalIndex[j], points) > distance(orignalIndex[pivotIndex],points)) j--;
            if(i < j){
                swap(orignalIndex, i , j);
                i++;
                j--;
            }

        }

        swap(orignalIndex, pivotIndex, j);
        return j;
    
    }


    public int[][] kClosest(int[][] points, int k) {
        if(k == points.length) return points;
        int[] orignalIndex = new int [points.length];
        for(int i = 0; i < points.length; i++) orignalIndex[i] = i;

        int L = 0;
        int R = points.length - 1;
        int pivotIndex = quickSelect(L, R, orignalIndex, points);
        while(pivotIndex != k){
            if(pivotIndex < k){
                L = pivotIndex + 1;
            }
            else{
                R = pivotIndex - 1;
            }
            pivotIndex = quickSelect(L, R, orignalIndex, points);
        }

        int [][] res = new int [k][2];
        for(int i = 0; i < k; i++){
            int index = orignalIndex[i];
            res[i] = points[index];
        }

        return res;
    }
}
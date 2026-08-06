class Solution {

    public void swap(double [][] arr, int i, int j){
        double [] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int quickSelect(int L, int R, double[][] arr){

        int randomIndex = L + (int)(Math.random() * (R - L + 1));
        swap(arr, L, randomIndex);
        int pivotIndex = L;
        int i = L + 1;
        int j = R;

        while(i <= j){
            while(i <= R && arr[i][0] <= arr[pivotIndex][0]) i++;
            while(j >= L - 1 && arr[j][0] > arr[pivotIndex][0]) j--;
            if(i < j){
                swap(arr, i , j);
                i++;
                j--;
            }

        }

        swap(arr, pivotIndex, j);
        return j;
    
    }


    public int[][] kClosest(int[][] points, int k) {
        if(k == points.length) return points;

        double [][] distanceArr = new double [points.length][2];

        for (int i = 0; i < distanceArr.length; i++){
            int [] point = points[i];
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt((x*x) + (y*y));
            distanceArr[i][0] = distance;
            distanceArr[i][1] = i;
        }
        int L = 0;
        int R = distanceArr.length - 1;
        int pivotIndex = quickSelect(L, R, distanceArr);;
        while(pivotIndex != k ){
            if(pivotIndex < k){
                L = pivotIndex + 1;
            }
            else{
                R = pivotIndex - 1;
            }
            pivotIndex = quickSelect(L, R, distanceArr);
        }

        int [][] res = new int [k][2];
        for(int i = 0; i < k; i++){
            int index = (int) distanceArr[i][1];
            res[i] = points[index];
        }

        return res;
    }
}
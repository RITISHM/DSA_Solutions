class Solution {


    int mergeSort(int arr [], int low, int high){

        if(low >= high) return 0;

        int mid = (high - low)/2 + low;

        int count = 0;
        
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        int lp = low, rp = mid + 1;

        while( lp <= mid && rp <= high){
            if ((long) arr[lp] > (long) 2 * arr[rp]){
                count += mid - lp + 1;
                rp++;
            }
            else{
                lp++;
            }
        }
        
        merge(arr, low, mid, high);
        return count;

    }

    void merge(int [] arr, int low, int mid, int high){
        int lp = low;
        int rp = mid + 1; 
        int [] sortedArray = new int [high - low + 1];
        int sp = 0;

        while (lp <= mid && rp <= high){
            if (arr[lp] > arr[rp]){
                sortedArray[ sp++ ] = arr[ rp++ ];
            }

            else{
                sortedArray[ sp++ ] = arr[ lp++ ];
            }
        }

        while(lp <= mid){
            sortedArray[ sp++ ] = arr[ lp++ ];
        }

        while(rp <= high){
            sortedArray[ sp++ ] = arr[ rp ++ ];
        }

        sp = 0;
        while ( low <= high){
            arr[low++] = sortedArray[sp++];
        }

    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}
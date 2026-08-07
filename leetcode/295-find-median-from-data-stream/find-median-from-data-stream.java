class MedianFinder {
    PriorityQueue <Integer> upperElements;
    PriorityQueue <Integer> lowerElements;
    int pivot;
    public MedianFinder() {
        upperElements = new PriorityQueue<>();
        lowerElements = new PriorityQueue<>((a , b) -> b - a);
        pivot = 0;
    }


    public void addNum(int num) {
        if(upperElements.isEmpty() && lowerElements.isEmpty()){
            pivot = num;
            lowerElements.offer(num);
            return;
        }

        if(num > pivot){
            upperElements.offer(num);
        }
        else{
            lowerElements.offer(num);
        }
        int size1 = upperElements.size();
        int size2 = lowerElements.size();

        if((size1 + size2) % 2 == 0){
            while(upperElements.size() != lowerElements.size()){
                if(upperElements.size() > lowerElements.size()){
                    lowerElements.offer (upperElements.poll());
                }
                else{
                    upperElements.offer(lowerElements.poll());
                }
            }
            pivot = lowerElements.peek();
        }

    }
    
    public double findMedian() {
        int size1 = upperElements.size();
        int size2 = lowerElements.size();
        double median = 0;
        if(size1 == size2){
            int a = upperElements.peek();
            int b = lowerElements.peek();

            median = ((double)a + (double)b) / 2;
        }

        else if (size1 > size2) median = upperElements.peek();
        else median = lowerElements.peek();

        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
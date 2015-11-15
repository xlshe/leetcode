/* Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array. */


int majorityElement(int num[], int n) {
    int vote = 0;
    int candidate;
    for (int i=0; i<n; i++) {
        if (vote == 0) {
            candidate = num[i];
            vote ++;
            continue;
        }
        if (num[i] == candidate) {
            vote ++;
            continue;
        }
        vote --;
    }
    return candidate;
}

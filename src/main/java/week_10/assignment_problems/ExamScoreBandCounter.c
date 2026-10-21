
#include <stdio.h>

int firstGreaterOrEqual(int scores[], int n, int target) {
    int left = 0;
    int right = n;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (scores[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}

int firstGreater(int scores[], int n, int target) {
    int left = 0;
    int right = n;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (scores[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
}

int countInBand(int scores[], int n, int low, int high) {
    int start = firstGreaterOrEqual(scores, n, low);
    int end = firstGreater(scores, n, high);

    return end - start;
}

int main() {
    int scores[] = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
    int n = sizeof(scores) / sizeof(scores[0]);

    printf("%d\n", countInBand(scores, n, 42, 58));

    return 0;
}

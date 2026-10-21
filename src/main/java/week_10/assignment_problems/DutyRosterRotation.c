#include <stdio.h>

int main() {
    char names[] = {'A', 'B', 'C', 'D', 'E'};
    char result[5];
    int n = 5;
    int k = 7;

    k = k % n;

    for (int i = 0; i < n; i++) {
        result[(i + k) % n] = names[i];
    }

    printf("[");
    for (int i = 0; i < n; i++) {
        printf("%c", result[i]);
        if (i < n - 1) {
            printf(", ");
        }
    }
    printf("]\n");

    return 0;
}

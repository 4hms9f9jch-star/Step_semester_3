
#include <stdio.h>

int main() {
    int buses[3][3] = {
        {2, 0, 1},
        {3, 3, 1},
        {1, 1, 1}
    };

    int rows = 3;
    int cols = 3;
    int busiestRow = 0;
    int maxTotal = 0;

    for (int i = 0; i < rows; i++) {
        int total = 0;

        for (int j = 0; j < cols; j++) {
            total += buses[i][j];
        }

        if (i == 0 || total > maxTotal) {
            maxTotal = total;
            busiestRow = i;
        }
    }

    printf("Row: %d\n", busiestRow);
    printf("Total: %d\n", maxTotal);

    return 0;
}

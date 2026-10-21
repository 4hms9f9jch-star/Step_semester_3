
#include <stdio.h>

void attendanceSummary(int days[], int n, int *present, int *longestStreak) {
    int currentStreak = 0;
    *present = 0;
    *longestStreak = 0;

    for (int i = 0; i < n; i++) {
        if (days[i] == 1) {
            (*present)++;
            currentStreak++;

            if (currentStreak > *longestStreak) {
                *longestStreak = currentStreak;
            }
        } else {
            currentStreak = 0;
        }
    }
}

int main() {
    int days[] = {1, 1, 0, 1, 1, 1, 0, 1};
    int n = sizeof(days) / sizeof(days[0]);
    int present, longestStreak;

    attendanceSummary(days, n, &present, &longestStreak);

    printf("Present: %d\n", present);
    printf("Longest streak: %d\n", longestStreak);

    return 0;
}

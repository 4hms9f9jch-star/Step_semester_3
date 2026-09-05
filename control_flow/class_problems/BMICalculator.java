public class BMICalculator {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } 
        else if (bmi < 25) {
            return "Normal";
        } 
        else if (bmi < 30) {
            return "Overweight";
        } 
        else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf(
                "Person %d | %.2f | %.2f | %.2f | %s%n",
                i + 1,
                heights[i],
                weights[i],
                bmi,
                getBmiStatus(bmi)
            );
        }
    }

    public static void main(String[] args) {

        double[] heights = {
            1.75, 1.60, 1.80, 1.65, 1.70
        };

        double[] weights = {
            70, 90, 80, 55, 95
        };

        printWellnessReport(heights, weights);
    }
}
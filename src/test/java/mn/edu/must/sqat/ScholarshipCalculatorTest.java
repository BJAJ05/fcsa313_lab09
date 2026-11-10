package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScholarshipCalculatorTest {
    private ScholarshipCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ScholarshipCalculator();
    }

    @Test
    void letterGrade_score95_returnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void gpa_scores95And85_returns3point5() {
        assertEquals(3.5, calculator.gpa(new double[] { 95, 85 }), 0.001);
    }

    @Test
    void scholarship_highGpaEnoughCredits_returns100() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_gpa3point5Credits13_returns70() {
        assertEquals(70, calculator.scholarship(3.5, 13, false));
    }

    @Test
    void scholarship_gpa3point1_returns50() {
        assertEquals(50, calculator.scholarship(3.1, 10, false));
    }
}

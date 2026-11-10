package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void letterGrade_negativeScore_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(-1));
    }

    @Test
    void letterGrade_scoreAbove100_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(101));
    }

    @Test
    void letterGrade_score85_returnsB() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void letterGrade_score75_returnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void letterGrade_score65_returnsD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void letterGrade_score30_returnsF() {
        assertEquals("F", calculator.letterGrade(30));
    }

    @Test
    void gpa_nullArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.gpa(null));
    }

    @Test
    void gpa_emptyArray_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.gpa(new double[] {}));
    }

    @Test
    void gpa_scoresInC_returns2() {
        assertEquals(2.0, calculator.gpa(new double[] { 75, 75 }), 0.001);
    }

    @Test
    void gpa_scoresInD_returns1() {
        assertEquals(1.0, calculator.gpa(new double[] { 65, 65 }), 0.001);
    }

    @Test
    void gpa_scoresInF_returns0() {
        assertEquals(0.0, calculator.gpa(new double[] { 30, 30 }), 0.001);
    }

    @Test
    void scholarship_negativeGpa_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.scholarship(-0.1, 10, false));
    }

    @Test
    void scholarship_gpaAbove4_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.scholarship(4.1, 10, false));
    }

    @Test
    void scholarship_negativeCredits_throws() {
        assertThrows(IllegalArgumentException.class, () -> calculator.scholarship(3.5, -1, false));
    }

    @Test
    void scholarship_withViolation_returns0() {
        assertEquals(0, calculator.scholarship(3.9, 16, true));
    }

    @Test
    void scholarship_highGpaLowCredits_returns70() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    @Test
    void scholarship_midGpaLowCredits_returns50() {
        assertEquals(50, calculator.scholarship(3.5, 10, false));
    }

    @Test
    void scholarship_lowGpa_returns0() {
        assertEquals(0, calculator.scholarship(2.5, 16, false));
    }

    @Test
    void gpaLoop_zeroIterations_emptyArray_throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[] {}));
        assertEquals("Дүнгүй голч бодох боломжгүй", ex.getMessage());
    }

    @Test
    void gpaLoop_zeroIterations_nullArray_throws() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
        assertEquals("Дүнгүй голч бодох боломжгүй", ex.getMessage());
    }

    @Test
    void gpaLoop_oneIteration_singleScore95_returns4() {
        assertEquals(4.0, calculator.gpa(new double[] { 95 }), 0.001);
    }

    @Test
    void gpaLoop_manyIterations_fourScores_returns2point5() {
        assertEquals(2.5, calculator.gpa(new double[] { 95, 85, 75, 65 }), 0.001);
    }

    @Test
    void letterGrade_score100_returnsA() {
        assertEquals("A", calculator.letterGrade(100));
    }

    @Test
    void letterGrade_score90_returnsA() {
        assertEquals("A", calculator.letterGrade(90));
    }

    @Test
    void letterGrade_score89point99_returnsB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void letterGrade_score69point99_returnsD() {
        assertEquals("D", calculator.letterGrade(69.99));
    }

    @Test
    void letterGrade_score60_returnsD() {
        assertEquals("D", calculator.letterGrade(60));
    }

    @Test
    void letterGrade_score59point99_returnsF() {
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    void letterGrade_score0_returnsF() {
        assertEquals("F", calculator.letterGrade(0));
    }
}

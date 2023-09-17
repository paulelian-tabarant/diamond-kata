package org.kata;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiamondTest {
    @Test
    void shouldMakeSpaceIntoLetterAccordingItsPositionInAlphabet() {
        // Given
        var diamond = new Diamond('D');

        var abcdTestCases = Map.of(
            'A', "A",
            'B', "B B",
            'C', "C   C",
            'D', "D     D"
        );

        // When Then
        abcdTestCases.forEach((inputLetter, expectedRow) -> assertThat(diamond.getRow(inputLetter)).isEqualTo(expectedRow));
    }

    @Test
    void shouldOffsetEachLetterRowAccordingToRequestedLetterPositionInAlphabet() {
        // Given
        var diamond = new Diamond('D');

        var abcdTestCases = Map.of(
            'A', "   ",
            'B', "  ",
            'C', " ",
            'D', ""
        );

        // When Then
        abcdTestCases.forEach(
            (rowLetter, expectedOffset) -> {
                var actualOffset = diamond.getRowOffset(rowLetter);
                assertThat(actualOffset).isEqualTo(expectedOffset);
            }
        );
    }

    @Test
    void shouldPrintOffsetOnBothSidesOfEachDiamondRow() {
        // Given
        var row = "C   C";
        var offset = " ";

        var expectedLine = " C   C ";

        // When
        var actualLine = Diamond.addOffset(row, offset);

        // Then
        assertThat(actualLine).isEqualTo(expectedLine);
    }
}
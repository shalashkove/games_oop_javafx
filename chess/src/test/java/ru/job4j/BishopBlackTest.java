package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void whenBlackBishopPositionCheck() {
        Figure bishopBlack = new BishopBlack(Cell.A3);
        Cell result = bishopBlack.position();
        assertThat(result, is(Cell.A3));
    }

    @Test
    public void whenBlackBishopCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure copyBlackBishop = bishopBlack.copy(Cell.A3);
        Cell result = copyBlackBishop.position();
        assertThat(result, is(Cell.A3));
    }

    @Test
    public void whenWayToRightUp() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.C1, Cell.G5);
        assertThat(result, is(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void whenWayToRightDown() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(bishopBlack.position(), Cell.G1);
        assertThat(result, is(new Cell[] {Cell.E3, Cell.F2, Cell.G1}));
    }

    @Test
    public void whenWayToLeftDown() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(bishopBlack.position(), Cell.A1);
        assertThat(result, is(new Cell[] {Cell.C3, Cell.B2, Cell.A1}));
    }

    @Test
    public void whenWayToLeftUp() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        Cell[] result = bishopBlack.way(bishopBlack.position(), Cell.C5);
        assertThat(result, is(new Cell[] {Cell.C5}));
    }

    @Test
    public void whenDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        boolean result = bishopBlack.isDiagonal(bishopBlack.position(), Cell.H8);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        boolean result = bishopBlack.isDiagonal(bishopBlack.position(), Cell.H4);
        assertThat(result, is(false));
    }

    @Test
    public void whenDiagonalSamePosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        boolean result = bishopBlack.isDiagonal(bishopBlack.position(), Cell.D4);
        assertThat(result, is(false));
    }
}

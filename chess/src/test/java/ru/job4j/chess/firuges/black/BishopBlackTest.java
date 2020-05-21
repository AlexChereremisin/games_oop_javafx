package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishop = new BishopBlack(Cell.D3);
        assertThat(
                bishop.position(),
                is(Cell.D3)
        );
    }

    @Test
    public void copy() {
        BishopBlack bishop = (BishopBlack) new BishopBlack(Cell.D3).copy(Cell.A6);
        assertThat(
                bishop.position(),
                is(Cell.A6)
        );
    }

    @Test
    public void whenWayDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.F8);
        Cell[] steps = bishop.way(bishop.position(), Cell.A3);
        assertThat(
                steps,
                is(new Cell[]{Cell.E7, Cell.D6, Cell.C5, Cell.B4, Cell.A3})
        );
    }

    @Test(expected = IllegalStateException.class)
    public void whenWayNotDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.C8);
        Cell[] steps = bishop.way(bishop.position(), Cell.D6);
    }
}
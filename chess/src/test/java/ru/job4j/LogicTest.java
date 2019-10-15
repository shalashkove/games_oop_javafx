package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LogicTest {

    @Test
    public void whenWrongWayLogic() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        boolean result = logic.move(Cell.C1, Cell.H6);
        assertThat(result, is(false));
    }

    @Test (expected = IllegalStateException.class)
    public void whenWrongWayNotDiagonal() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.C1, Cell.C3);
    }

    @Test
    public void whenRightWayLogic() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(true));
    }
}

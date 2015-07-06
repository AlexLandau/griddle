package net.alloyggp.griddle.indentation;

import net.alloyggp.griddle.TestGames;

import org.junit.Assert;
import org.junit.Test;

public class GameIndenterTest extends Assert {
    @Test
    public void testCase1() throws Exception {
        String before = TestGames.getGameString("formatter1Before");
        String after = TestGames.getGameString("formatter1After");
        String transformed = GameIndenter.reindentGameDescription(before);
        assertEquals(after, transformed);
    }
    //TODO: Add more test cases
}

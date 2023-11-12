package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TrelloValidatorTestSuite {

    TrelloValidator validator = new TrelloValidator();

    @Test
    void shouldFilterBoardsWithTestName() {
        // Given
        List<TrelloBoard> trelloBoards = List.of(
                new TrelloBoard("1", "board" , new ArrayList<>()),
                new TrelloBoard("2", "test" , new ArrayList<>())

        );
        // When
        List<TrelloBoard> result = validator.validateTrelloBoards(trelloBoards);
        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("board", result.get(0).getName());
    }
}

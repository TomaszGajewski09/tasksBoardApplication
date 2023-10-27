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

    // todo: Pytanie: Jak przetestować odpowiednio logi metody validateCard?
//    @Test
//    void shouldLogInfoWhenNameContainsTest() {
//        // Given
//        TrelloCard trelloCard = new TrelloCard("test_card", "test", "top", "1");
//        Logger logger = mock(Logger.class);
//
//        // When
//        validator.validateCard(trelloCard);
//
//        // Then
//        verify(logger).info("Someone is testing my application");
//    }

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

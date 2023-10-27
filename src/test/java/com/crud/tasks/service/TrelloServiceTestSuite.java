package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TrelloServiceTestSuite {

    @InjectMocks
    TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    void shouldFetchTrelloBoards() {
        // Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "test", new ArrayList<>());
        List<TrelloBoardDto> boards = List.of(trelloBoardDto);
        when(trelloClient.getTrelloBoards()).thenReturn(boards);
        // When
        List<TrelloBoardDto> result = trelloService.fetchTrelloBoards();
        // Then
        assertNotNull(result);
        result.forEach(board ->{
            assertEquals(trelloBoardDto.getId(), board.getId());
            assertEquals(trelloBoardDto.getName(), board.getName());
            assertEquals(trelloBoardDto.getLists().size(), board.getLists().size());
        });
    }

    @Test
    void shouldCreateTrelloCard() {
        // Given

        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "Test card", "top", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Test card", "http://test.com");
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        when(adminConfig.getAdminMail()).thenReturn("admin@test.com");
        // When
        CreatedTrelloCardDto result = trelloService.createTrelloCard(trelloCardDto);
        // Then
        assertEquals("1", result.getId());
        assertEquals("Test card", result.getName());
        assertEquals("http://test.com", result.getShortUrl());
        Mockito.verify(emailService, times(1)).send(any(Mail.class));
    }
}

package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TrelloMapperTestSuite {

    TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void mapToBoardsTest() {
        // Given
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("id1", "test1", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("id2", "test2", new ArrayList<>());
        List<TrelloBoardDto> boardDtoList = new ArrayList<>(Arrays.asList(
                trelloBoardDto1,
                trelloBoardDto2
        ));
        // When
        List<TrelloBoard> result = trelloMapper.mapToBoards(boardDtoList);
        // Then
        List<TrelloBoard> expectedResult = new ArrayList<>(Arrays.asList(
                new TrelloBoard("id1", "test1", new ArrayList<>()),
                new TrelloBoard("id2", "test2", new ArrayList<>())
        ));
        assertEquals(expectedResult, result);
    }

    @Test
    void mapToBoardsDtoTest() {
        // Given
        List<TrelloBoard> boards = new ArrayList<>(Arrays.asList(
                new TrelloBoard("id1", "test", new ArrayList<>()),
                new TrelloBoard("id2", "test", new ArrayList<>())
        ));
        // When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(boards);
        // Then
        List<TrelloBoardDto> expectedResult = new ArrayList<>(Arrays.asList(
                new TrelloBoardDto("id1", "test", new ArrayList<>()),
                new TrelloBoardDto("id2", "test", new ArrayList<>())
        ));
        assertEquals(expectedResult, result);
    }

    @Test
    void mapToCardTest() {
        // Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "desc1", "top", "idList1");
        // When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);
        // Then
        TrelloCard expectedResult = new TrelloCard("test", "desc1", "top", "idList1");
        assertEquals(expectedResult ,result);
    }

    @Test
    void mapToCardDtoTest() {
        // Given
        TrelloCard trelloCard = new TrelloCard("test", "desc1", "top", "idList1");
        // When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);
        // Then
        TrelloCardDto expectedResult = new TrelloCardDto("test", "desc1", "top", "idList1");
        assertEquals(expectedResult ,result);
    }

    @Test
    void mapToListTest() {
        // Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>(Arrays.asList(
                new TrelloListDto("id1", "test", false),
                new TrelloListDto("id2", "test", true)
        ));
        // When
        List<TrelloList> result = trelloMapper.mapToList(trelloListsDto);
        // Then
        List<TrelloList> expectedResult = new ArrayList<>(Arrays.asList(
                new TrelloList("id1", "test", false),
                new TrelloList("id2", "test", true)
        ));
        assertEquals(expectedResult, result);
    }

    @Test
    void mapToListDtoTest() {
        // Given
        List<TrelloList> trelloLists = new ArrayList<>(Arrays.asList(
                new TrelloList("id1", "test", false),
                new TrelloList("id2", "test", true)
        ));
        // When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);
        // Then
        List<TrelloListDto> expectedResult = new ArrayList<>(Arrays.asList(
                new TrelloListDto("id1", "test", false),
                new TrelloListDto("id2", "test", true)
        ));
        assertEquals(expectedResult, result);
    }
}

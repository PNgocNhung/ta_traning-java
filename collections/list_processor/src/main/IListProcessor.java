package com.epam.trainning.ngocnhung.collections.list_processor.src.main;

import java.util.List;

public interface IListProcessor {

	String getSecondStringByLength(List<String> list);

	List<String> getSortedListByLength(List<String> list);

	List<String> getSortedListByCountOfVowels(List<String> list);

	List<String> getSortedListByCountOfConsonants(List<String> list);

	List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list);

	List<String> reverseStringsOfList(List<String> list);
}

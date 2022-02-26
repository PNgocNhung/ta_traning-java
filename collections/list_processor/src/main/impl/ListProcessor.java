package com.epam.trainning.ngocnhung.collections.list_processor.src.main.impl;

import com.epam.trainning.ngocnhung.collections.list_processor.src.main.exception.ListProcessorException;
import com.epam.trainning.ngocnhung.collections.list_processor.src.main.IListProcessor;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;


/**
 * Function Description:
 * Complete the functions below. All methods must work with list of String.
 * <p>
 * In case of incorrect input values or inability to perform an action, the method should throw an appropriate
 * exception.
 */
public class ListProcessor implements IListProcessor {

    /**
     * Find the second by length string in a list.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaaaa", "aaaa", "aaa"}
     * will be return "aaaa"
     *
     * @param list - input data
     * @return second by length string in the input list
     */
    @Override
    public String getSecondStringByLength(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException("The list shouldn't be null or empty");
        }
        if (list.size() == 1) {
            throw new ListProcessorException("The list only have 1 value");
        }
            list.sort(Comparator.comparing(String::length).reversed());
            return list.get(1);
        }

    /**
     * Sort list by string length.
     * <p>
     * Ex.:
     * From list:
     * {"a", "aa", "aaA", "aAa", "aaa", "Aa"}
     * will be return
     * {"a", "Aa", "aa", "aAa", "aaA", "aaa"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByLength(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException("The list shouldn't be null or empty");
        }
        list.sort(Comparator.comparing(String::length));
        return list;
    }

    /**
     * Sort list or array by count of vowels in string.
     * If the number of vowels in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfVowels(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException("The list shouldn't be null or empty");
        }
        Function<String, Integer> getCount = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    char originCharacter = s.charAt(i);
                    char ch = Character.toLowerCase(originCharacter);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'u' || ch == 'o') count++;
                }
                if (count <= 0) {
                    throw new ListProcessorException("There is no vowel");
                } else return count;
            }
        };
        list.sort(Comparator.comparingInt(getCount::apply).thenComparing(Comparator.naturalOrder()).thenComparing(String::length));
        return list;
    }

    /**
     * Sort list or array by count of consonants in string.
     * If the number of consonants in several words is the same, the order is alphabetical.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Nike", "Puma", "Adidas", "Timberland"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> getSortedListByCountOfConsonants(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException("The list shouldn't be null or empty");
        }

        Function<String, Integer> getCount = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    char origin = s.charAt(i);
                    char ch = Character.toLowerCase(origin);
                    if ((ch != 'a' && ch != 'e' && ch != 'i' && ch != 'u' && ch != 'o') && (ch >= 'a' && ch <= 'z'))
                        count++;
                }
                if (count <= 0) {
                    throw new ListProcessorException("There is no consonant");
                } else return count;
            }
        };
        list.sort(Comparator.comparingInt(getCount::apply).thenComparing(String::compareTo));
        return list;

    }

    /**
     * Change by places first and last symbols in each second string of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"Puma", "eikN", "Timberland", "sdidaA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> changeByPlacesFirstAndLastSymbolsInEachSecondStringOfList(List<String> list) {

        if (list == null || list.isEmpty()) {
            throw new ListProcessorException("The list shouldn't be null or empty");
        }
        if (list.equals(" ")) {
            throw new ListProcessorException("There is space");
        }
        if (list.size() == 1) {
            throw new ListProcessorException("The list only have 1 value");
        }

        for (int i = 1; i < list.size(); i += 2) {
            char[] charArray = list.get(i).toCharArray();
            char temp = charArray[0];
            charArray[0] = charArray[charArray.length - 1];
            charArray[charArray.length - 1] = temp;
            list.set(i, String.valueOf(charArray));
        }

        return list;
    }

    /**
     * Revert strings of list.
     * <p>
     * Ex.:
     * From list:
     * {"Puma", "Nike", "Timberland", "Adidas"}
     * will be return
     * {"amuP", "ekiN", "dnalrebmiT", "sadidA"}
     *
     * @param list - input data
     * @return sort list by string length
     */
    @Override
    public List<String> reverseStringsOfList(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new ListProcessorException("The list shouldn't be null or empty");}
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder(list.get(i));
            sb.reverse();
            list.set(i, sb.toString());
        }
        return list;
    }
}

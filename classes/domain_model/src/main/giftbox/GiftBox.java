package com.epam.trainning.ngocnhung.classes.domain_model.src.main.giftbox;

import com.epam.trainning.ngocnhung.classes.domain_model.src.main.candies.Candy;
import com.epam.trainning.ngocnhung.classes.domain_model.src.main.util.Finding;
import com.epam.trainning.ngocnhung.classes.domain_model.src.main.util.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */
public class GiftBox implements Finding, Sorting {
    /**
     * No actions are required for class variable candiesList.
     */
    private final List<Candy> candiesList;
    /**
     * No actions are required for constructor GiftBox().
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }
    /**
     * No actions are required for method addCandy().
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByNameAsc() {
        if (candiesList == null || candiesList.isEmpty())
            throw new ArrayIndexOutOfBoundsException("The list is null or empty!");
        candiesList.sort(Comparator.comparing(Candy::getName));
        return candiesList;
    }
    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByWeightAsc() {
        if (candiesList == null || candiesList.isEmpty())
            throw new ArrayIndexOutOfBoundsException("The list is null or empty!");
        candiesList.sort(Comparator.comparing(Candy::getWeight));
        return candiesList;

    }
    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {

        List<Candy> matchTheLetterList = new ArrayList<>();

        try {
            for (Candy c : candiesList) {
                if (c.getName().charAt(0) == candyNameFirstLetter) {
                    matchTheLetterList.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter a proper input");
        }

        matchTheLetterList.sort(Comparator.comparing(Candy::getName));
        return matchTheLetterList;

    }


    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {

        List<Candy> inWeightRangeList = new ArrayList<>();

        try {
            for (Candy c : candiesList) {
                if ((c.getWeight() >= weightFrom) && (c.getWeight() <= weightTo)) {
                    inWeightRangeList.add(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter a proper input");
        }

        inWeightRangeList.sort(Comparator.comparing(Candy::getWeight));
        return inWeightRangeList;
    }
}

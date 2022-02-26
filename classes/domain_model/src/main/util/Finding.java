package com.epam.trainning.ngocnhung.classes.domain_model.src.main.util;

import com.epam.trainning.ngocnhung.classes.domain_model.src.main.candies.Candy;

import java.util.List;

public interface Finding {

    /**
     * No actions are required within the interface
     */
    List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter);

    List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo);
}

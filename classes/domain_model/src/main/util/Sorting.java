package com.epam.trainning.ngocnhung.classes.domain_model.src.main.util;

import com.epam.trainning.ngocnhung.classes.domain_model.src.main.candies.Candy;

import java.util.List;

public interface Sorting {

    /**
     * No actions are required within the interface
     */
    List<Candy> sortCandiesByNameAsc();

    List<Candy> sortCandiesByWeightAsc();
}

package com.epam.trainning.ngocnhung.collections.list_processor.src.test;

import com.epam.trainning.ngocnhung.collections.list_processor.src.main.IListProcessor;
import com.epam.trainning.ngocnhung.collections.list_processor.src.main.impl.ListProcessor;
import org.junit.jupiter.api.BeforeEach;

abstract class AbstractTest {

    IListProcessor testClass;

    @BeforeEach
    void setUp() {
        testClass = new ListProcessor();
    }
}

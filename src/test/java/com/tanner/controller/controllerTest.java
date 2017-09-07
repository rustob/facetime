package com.tanner.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class controllerTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void test() {
        System.out.println("hello");
    }

}
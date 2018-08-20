package com.example.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private int a;
    private int b;
    private Calculator calc;

    @Before
    public void initializeClass() {
        this.a = 22;
        this.b = 20;
        this.calc = new Calculator();
    }

    @Test
    public void add_two_numbers() {
        int expected = 42;
        int actual = calc.add(a, b);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void subtract_two_numbers() {
        int expected = 2;
        int actual = calc.sub(a, b);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void multiply_two_numbers() {
        int expected = 440;
        int actual = calc.mult(a, b);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void divide_two_numbers() {
        int expected = 1;
        int actual = calc.div(a, b);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void modulus_two_numbers() {
        int expected = 2;
        int actual = calc.mod(a, b);
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterEachTextCase() { calc = null; }
}

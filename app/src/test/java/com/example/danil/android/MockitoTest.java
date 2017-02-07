package com.example.danil.android;

import com.example.danil.android.forMockitoTest.Empty;
import com.example.danil.android.forMockitoTest.FileEncoder;
import com.example.danil.android.forMockitoTest.FileSaver;
import org.junit.*;
import org.mockito.Mockito;

import java.io.IOError;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by _dani on 07.02.2017.
 */
public class MockitoTest {
    /*
    @After
    public void afrer(){
        System.out.println("After");
    }
    @Before
    public void before(){
        System.out.println("Before");
    }
    */

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass");
    }

    //Test на выброшенный эксепшен(если ексепшен выброшен значит тест пройден)
    @Test(expected = IOException.class)
    public void error() throws IOException {
        throw new IOException();
    }

    @Test
    public void mocTest (){
        Empty empty = Mockito.mock(Empty.class);
        Mockito.when(empty.getB()).thenReturn(5);
        int res = empty.getB();
        assertEquals(5, res);
    }

    @Test
    public void saverMocTest(){
        FileEncoder fileEncoder = Mockito.mock(FileEncoder.class);
        Mockito.when(fileEncoder.encode(Mockito.anyString())).thenReturn("000");
        FileSaver fileSaver = new FileSaver(fileEncoder);

        fileSaver.save("one", "two", "three");
        Mockito.verify(fileEncoder, Mockito.times(3)).encode(Mockito.anyString());
        Mockito.verify(fileEncoder, Mockito.times(1)).encode("one");
    }
}

package com.jnu.student.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataDownloadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void download() {
        DataDownload httpDataLoader=new DataDownload();
        String fileContent=httpDataLoader.download("http://file.nidama.net/class/mobile_develop/data/bookstore.json");
        assertTrue(fileContent.contains("\"name\": \"暨大珠海\","));
        assertTrue(fileContent.contains("\"memo\": \"珠海二城广场\""));
    }

    @Test
    public void parseJsonObjects() {
    }

}
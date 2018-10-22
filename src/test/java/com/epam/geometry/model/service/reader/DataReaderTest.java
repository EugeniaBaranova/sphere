package com.epam.geometry.model.service.reader;

import com.epam.geometry.model.service.reader.exception.MissingDataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DataReaderTest {

    private DataReader dataReader = new DataReader();
    private static final String FILE_PATH = "D:\\JAVA_PROJECTS_IDEA\\sphere\\src\\test\\resources\\spheres.txt";

    @Test
    public void shouldReadFileAndReturnListOfStringsWhenDataIsFound() throws MissingDataException {
        //when
        List<String> lines = dataReader.getValidLines(FILE_PATH);
        //then
        Assert.assertEquals(3, lines.size());
    }

    @Test(expected = MissingDataException.class)
    public void shouldReadFileAndThrowMissingDataExceptionWhenDataNotFound() throws MissingDataException {
        //when

        final String unexistingPath = "D:\\sphasdasdasdasd";

        dataReader.getValidLines(unexistingPath);
    }
}
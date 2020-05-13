package org.daistudy.actioninjava8.chapter03;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcess {
    String process(BufferedReader bufferedReader) throws IOException;
}

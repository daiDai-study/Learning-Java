package org.daistudy.onjava.concurrent.communication.pc.pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipeDemo {
    private static class ReaderRun implements Runnable{
        private PipedReader pipedReader;

        public ReaderRun(PipedReader pipedReader) {
            this.pipedReader = pipedReader;
        }

        @Override
        public void run() {
            System.out.println("reader");
            int c = 0;
            try{
                while((c = pipedReader.read()) != -1){
                    System.out.print((char)c);
                }
                System.out.println();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class WriterRun implements Runnable{
        private PipedWriter pipedWriter;

        public WriterRun(PipedWriter pipedWriter) {
            this.pipedWriter = pipedWriter;
        }

        @Override
        public void run() {
            System.out.println("writer");
            try {
                Thread.sleep(3000);
                pipedWriter.write("test1");
                Thread.sleep(3000);
                pipedWriter.write("test2");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }finally {
                try {
                    pipedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        pipedWriter.connect(pipedReader);

        new Thread(new ReaderRun(pipedReader)).start();
        Thread.sleep(1000);
        new Thread(new WriterRun(pipedWriter)).start();
    }
}

package top.dj.demo;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author DengJia
 * @Date 2021/7/28
 * @Description
 */

public class PipeDemo {

    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("当前是【读】线程");
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable {

        private PipedWriter writer;

        public WriterThread(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("当前是【写】线程");
            try {
                writer.write("hello world!!");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);

        new Thread(new ReaderThread(reader)).start();
        new Thread(new WriterThread(writer)).start();
    }
}

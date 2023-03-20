package Task2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class FizzAndBuzz extends Thread implements ProcessorOfNumbers {
    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private ProcessorOfNumbers processor;
    public FizzAndBuzz(ProcessorOfNumbers processor){
        this.processor=processor;
    }
    public void process (int number) {
        this.number = number;
        processed.set(false);
    }
    public boolean isProcessed(){
        return processed.get();
    }
    @Override
    public void run() {
        while (true) {
            /*try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            if (processed.get()) {
                continue;
            }
            processor.process(number);
            processed.set(true);
        }
        }
    }


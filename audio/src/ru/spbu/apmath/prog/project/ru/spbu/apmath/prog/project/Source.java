package ru.spbu.apmath.prog.project.ru.spbu.apmath.prog.project;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Source {
    public static void main(String[] args) {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
        try {
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            final SourceDataLine sourceline = (SourceDataLine)AudioSystem.getLine(info);
            sourceline.open();
            info = new DataLine.Info(TargetDataLine.class, format);
            final TargetDataLine targetline = (TargetDataLine) AudioSystem.getLine(info);
            targetline.open();
            final ByteArrayOutputStream out = new ByteArrayOutputStream();

            Thread sourceThread = new Thread(){
                @Override public void run(){
                    sourceline.start();
                    while (true){
                        sourceline.write(out.toByteArray(), 0, out.toByteArray().length);
                    }
                }
            };
            Thread targetThread = new Thread(){
                @Override public void run(){
                    targetline.start();
                    byte[] data = new byte[targetline.getBufferSize()/5];
                    int readBytes;
                    while (true){
                        readBytes = targetline.read(data, 0, data.length);
                        String mark = "Low" ;
                        for(int i:data){
                            if ((i>50)||(i<-50)){
                                if ((i>100)||(i<-100)){
                                    mark = "Strong";
                                }
                                else {mark = "Medium";}
                            }

                        }
                        System.out.println(mark);
                        out.write(data, 0 , readBytes);
                    }
                }
            };
            targetThread.start();
            System.out.println("Starting REC...");
            Thread.sleep(15000);
            targetline.stop();
            targetline.close();
            System.out.println("...Ended REC");
            System.out.println("Starting PLAYBACK...");

            sourceThread.start();
            Thread.sleep(5000);
            sourceline.stop();
            sourceline.close();
            System.out.println("....Ended PLAYBACK");
        }
        catch (LineUnavailableException lue){lue.printStackTrace();}
        catch (InterruptedException ie){ie.printStackTrace();}

    }
}

package ru.spbu.apmath.prog.project.ru.spbu.apmath.prog.project;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Rec {
    public static void main(String[] args) {
        System.out.println("Start test");
        try {
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 441000, false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if(!AudioSystem.isLineSupported(info)){
                System.out.println("Not supported");}
            final TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(info);
            targetLine.open();
            System.out.println("Rec");
            targetLine.start();
            Thread thread = new Thread(){
                @Override public void run(){
                    AudioInputStream audioStream = new AudioInputStream(targetLine);
                    File audioFile = new File("rec.wav");
                    try {AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);}
                    catch (IOException ioe){ioe.printStackTrace();}
                    System.out.println("Stop Rec");
                }


            };
            thread.start();
            Thread.sleep(5000);
            targetLine.stop();
            targetLine.close();

        }
        catch (LineUnavailableException lue){lue.printStackTrace();}
        catch (InterruptedException ie){ie.printStackTrace();}

    }
}

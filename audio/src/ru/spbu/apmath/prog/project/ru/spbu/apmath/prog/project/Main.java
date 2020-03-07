package ru.spbu.apmath.prog.project.ru.spbu.apmath.prog.project;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class Main {
    public static Mixer mixer;
    public static Clip clip;

    public static void main(String[] args) {
        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
        for(Mixer.Info info : mixInfos){
            System.out.println(info.getName()+"_=_=_"+info.getDescription());
        }


        mixer = AudioSystem.getMixer(mixInfos[3]);
        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
        try{ clip = (Clip)mixer.getLine(dataInfo);}
        catch (LineUnavailableException lue){lue.printStackTrace();}

        try{
            URL soundURL = Main.class.getResource("/ru/spbu/apmath/prog/project/ru/spbu/apmath/prog/project/rec.wav");
            AudioInputStream audiostream = AudioSystem.getAudioInputStream(soundURL);
            clip.open(audiostream);
        }
        catch (LineUnavailableException lue){lue.printStackTrace();}
        catch (UnsupportedAudioFileException uafe) {uafe.printStackTrace();}
        catch (IOException ioe){ioe.printStackTrace();}

        clip.start();
        do
            {
                try {Thread.sleep(50);}
                catch (InterruptedException ie){ie.printStackTrace();}
            } while (clip.isActive());


    }
}

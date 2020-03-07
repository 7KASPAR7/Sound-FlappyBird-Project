package ru.spbu.apmath.prog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;


public class Bird {
    Texture img;
    Vector2 position;
    float vy;
    float gravity;
<<<<<<< HEAD


    public Bird(){
        img = new Texture("bird.png");
        position = new Vector2(100,380);
        vy = 0;
        gravity = - 0.7f;
    }

    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y);
    }

    public void update(){

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            vy = 10;
        }
        vy += gravity;
        position.y += vy;
=======


    public Bird(){
        img = new Texture("D:\\code\\dz\\prjct2\\core\\assets\\bird.png");
        position = new Vector2(100,380);
        vy = 0;
        gravity = - 0.7f;
    }
    private volatile String mark = "Low" ;
    public void render(SpriteBatch batch){
        batch.draw(img, position.x, position.y);
    }
    public void mark() {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            final TargetDataLine targetline = (TargetDataLine) AudioSystem.getLine(info);
            targetline.open();
            final ByteArrayOutputStream out = new ByteArrayOutputStream();

            Thread targetThread = new Thread(){
                @Override public void run(){
                    targetline.start();
                    byte[] data = new byte[targetline.getBufferSize()/44];
                    int readBytes;


                    for (int j = 0;j<2000;j++){
                        readBytes = targetline.read(data, 0, data.length);
                        //mark = "Low" ;

                        for(int i:data){
                            if ((i>50)||(i<-50)){
                                if ((i>100)||(i<-100)){
                                    mark = "Strong";
                                }
                                else {mark = "Medium";}
                            }//else{mark = "Low";}

                        }
                        //System.out.println(Arrays.toString(data));
                        //System.out.println(data.length);
                        //System.out.println(mark);
                        out.write(data, 0 , readBytes);

                    }
                }
            };
            targetThread.start();
           // System.out.println("Starting REC...");
            Thread.sleep(600);

            targetline.stop();
            targetline.close();

            //System.out.println("...Ended REC");

        }
        catch (LineUnavailableException lue){lue.printStackTrace();}
        catch (InterruptedException ie){ie.printStackTrace();}

    }
    protected String getMark(){
        mark();
        return mark;
    }
protected void setMark(){
        mark = "Low";
}
    public void update(boolean k ) {
      /*  AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
        try {
           // DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
           /* final SourceDataLine sourceline = (SourceDataLine) AudioSystem.getLine(info);
            sourceline.open();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            final TargetDataLine targetline = (TargetDataLine) AudioSystem.getLine(info);
            targetline.open();
            final ByteArrayOutputStream out = new ByteArrayOutputStream();

         /*   Thread sourceThread = new Thread(){
                @Override public void run(){
                    sourceline.start();
                    while (true){
                        sourceline.write(out.toByteArray(), 0, out.toByteArray().length);
                    }
                }
            };
          /*   Thread targetThread = new Thread(){
                @Override public void run(){
                    targetline.start();
            byte[] data = new byte[targetline.getBufferSize() / 5];
           // System.out.println(Arrays.toString(data));
            int readBytes;
            int num = 0;
            String mark = "Low";
      //      while (/*!(mark == "Low")  (num < 4)) {
                readBytes = targetline.read(data, 0, data.length);
            System.out.println(readBytes);
               // mark = "Low";
                for (int i : data) {
                    if ((i > 50) || (i < -50)) {
                        if ((i > 100) || (i < -100)) {
                            mark = "Strong";
                        } else {
                            mark = "Medium";
                        }
                    }

                }
                 System.out.println(mark);*/
      if(k){
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || (getMark() == "Medium")) {
                    vy = 10;
                    setMark();
                }}
      else {if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
          vy = 5;
      }}
             //   if (mark == "Strong") {
              //      vy = 10;
              //  }
                vy += gravity;
                position.y += vy;
                      //  out.write(data, 0 , readBytes);
       /*                 num++;

            }*/
             // targetline.close();
        /*    };
            targetThread.start();
            System.out.println("Starting REC...");
            Thread.sleep(1000);
            targetline.stop();
            targetline.close();
            System.out.println("...Ended REC");*/
   //     } catch (LineUnavailableException lue) {
    //        lue.printStackTrace();
    //    }
        // catch (InterruptedException ie){ie.printStackTrace();}

>>>>>>> 5c9f8ea31987a75e708b77e805010cb1a698daf3
    }

    public void recreate(){
        position = new Vector2(100,380);
        vy = 0;
    }
}
import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
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
//while(true){
                    for (int j = 0;j<2000;j++){
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
                       // System.out.println(Arrays.toString(data));
                        //System.out.println(data.length);
                        System.out.println(mark);
                        out.write(data, 0 , readBytes);
                        System.out.println(readBytes);
                    }
                }
            };
            targetThread.start();
            System.out.println("Starting REC...");
            Thread.sleep(400);
            targetline.stop();
            targetline.close();
            System.out.println("...Ended REC");

        }
        catch (LineUnavailableException lue){lue.printStackTrace();}
        catch (InterruptedException ie){ie.printStackTrace();}

    }}
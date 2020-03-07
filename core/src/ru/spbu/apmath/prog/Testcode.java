package ru.spbu.apmath.prog;

import javax.sound.sampled.AudioFormat;

public class Testcode {
    public static void main(String[] args) {
        int maxa=0;
    /*    int minSize = AudioRecord.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        AudioRecord ar = new AudioRecord(MediaRecorder.AudioSource.MIC, 8000,AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,minSize);
        short[] buffer = new short[minSize];
        ar.read(buffer, 0, minSize);
        for (short s : buffer)
        {
            if(Math.abs(s)>maxa)
                maxa=Math.abs(s);
        }
        ar.stop();
        return maxa;*/
    }
}

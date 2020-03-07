package ru.spbu.apmath.prog;

import com.badlogic.gdx.Gdx;

import java.util.Random;

public class Sound {
    final Random random = new Random();
    private com.badlogic.gdx.audio.Sound sound1 = Gdx.audio.newSound(Gdx.files.internal("data/sound1.mp3"));
    private com.badlogic.gdx.audio.Sound sound2 = Gdx.audio.newSound(Gdx.files.internal("data/sound2.mp3"));
    private com.badlogic.gdx.audio.Sound sound3 = Gdx.audio.newSound(Gdx.files.internal("data/sound3.mp3"));
    private com.badlogic.gdx.audio.Sound sound4 = Gdx.audio.newSound(Gdx.files.internal("data/sound4.mp3"));

    public Sound() {
        int i = random.nextInt(4);
        if (i == 0) {
            sound1.play();
        } else if (i == 1) {
            sound2.play();
        } else if (i == 2) {
            sound3.play();
        } else {
            sound4.play();
        }

    }

    public void recreate() {
        sound1.stop();
        sound2.stop();
        sound3.stop();
        sound4.stop();
        int i = random.nextInt(4);
        if (i == 0) {
            sound1.play();
        } else if (i == 1) {
            sound2.play();
        } else if (i == 2) {
            sound3.play();
        } else {
            sound4.play();
        }
    }
}


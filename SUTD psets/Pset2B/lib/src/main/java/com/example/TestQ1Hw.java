package com.example;

import com.example.midi.Midi;
import com.example.piano.PianoMachine;

import javax.sound.midi.MidiUnavailableException;
import music.Pitch;

class TestQ1Hw {


    private Midi midi;
    private PianoMachine pm;

    public static void main(String[] args) throws InterruptedException, MidiUnavailableException {
        TestQ1Hw test = new TestQ1Hw();
        test.test();
    }

    public void test() throws MidiUnavailableException, InterruptedException {
        midi = Midi.getInstance();
        midi.clearHistory();
        pm = new PianoMachine();

        pm.beginNote(new Pitch(0));
        Midi.rest(10);
        pm.endNote(new Pitch(0));

        pm.changeInstrument();
        Midi.rest(10);
        pm.changeInstrument();
        pm.beginNote(new Pitch(2));
        Midi.rest(10);
        pm.endNote(new Pitch(2));

        System.out.println(midi.history());
        midi.clearHistory();

        pm.shiftUp();
        pm.beginNote(new Pitch(2));
        Midi.rest(10);
        pm.endNote(new Pitch(2));
        pm.shiftDown();

        System.out.println(midi.history());
        midi.clearHistory();

        pm.toggleRecording();
        pm.beginNote(new Pitch(3));
        pm.beginNote(new Pitch(5));
        Midi.rest(10);
        pm.endNote(new Pitch(3));
        pm.endNote(new Pitch(5));
        pm.toggleRecording();

        System.out.println(midi.history());
        midi.clearHistory();
        Midi.rest(10);

        pm.playback();
        Midi.rest(10);

        System.out.println(midi.history());


    }
}


package cn.edu.lcu.cs.architecture.mvc.beat;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;
import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, MetaEventListener {
    private Sequencer sequencer; // 定序器，产生真实的节拍
    private List<BeatObserver> beatObservers = new ArrayList<>();
    private List<BPMObserver> bpmObservers = new ArrayList<>();
    private int bpm = 90; // 节拍频率，默认90

    @Override
    public void initialize() {
//        setUpMidi();
//        buildTrackAndStart();
    }

    @Override
    public void on() {
        sequencer.start();
        setBPM(90);
    }

    @Override
    public void off() {
        setBPM(0);
        sequencer.stop();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM()); // 定序器改变BPM
        notifyBPMObservers();
    }

    private void notifyBPMObservers() {
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    public void beatEvent() {
        notifyBeatObservers();
    }

    private void notifyBeatObservers() {
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        if (observer != null) {
            beatObservers.add(observer);
        }
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        if (observer != null) {
            beatObservers.remove(observer);
        }
    }

    @Override
    public void registerObserver(BPMObserver observer) {
        if (observer != null) {
            bpmObservers.add(observer);
        }
    }

    @Override
    public void removeObserver(BPMObserver observer) {
        if (observer != null) {
            bpmObservers.add(observer);
        }
    }

    @Override
    public void meta(MetaMessage meta) {

    }
}

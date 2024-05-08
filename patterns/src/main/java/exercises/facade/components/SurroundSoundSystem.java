package exercises.facade.components;

public class SurroundSoundSystem {
    public void on() {
        System.out.println("Surround sound on.");
    }

    public void off() {
        System.out.println("Surround sound off.");
    }

    public void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
}

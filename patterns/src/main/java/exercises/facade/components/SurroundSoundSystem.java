package exercises.facade.components;

class SurroundSoundSystem {
    void on() {
        System.out.println("Surround sound on.");
    }

    void off() {
        System.out.println("Surround sound off.");
    }

    void setVolume(int level) {
        System.out.println("Volume set to " + level);
    }
}

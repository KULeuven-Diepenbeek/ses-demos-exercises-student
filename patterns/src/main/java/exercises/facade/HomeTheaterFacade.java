package exercises.facade;

import exercises.facade.components.DVDPlayer;
import exercises.facade.components.Projector;
import exercises.facade.components.Screen;
import exercises.facade.components.SurroundSoundSystem;

public class HomeTheaterFacade {
    private final Projector projector;
    private final DVDPlayer dvd;
    private final SurroundSoundSystem sound;
    private final Screen screen;

    public HomeTheaterFacade() {
        this.projector = new Projector();
        this.dvd = new DVDPlayer();
        this.sound = new SurroundSoundSystem();
        this.screen = new Screen();
    }

    public HomeTheaterFacade(Projector projector, DVDPlayer dvdPlayer, SurroundSoundSystem surroundSoundSystem, Screen screen) {
        this.projector = projector;
        this.dvd = dvdPlayer;
        this.sound = surroundSoundSystem;
        this.screen = screen;
    }

    public void watchMovie(String title) {
        screen.down();
        projector.on();
        dvd.on();
        projector.setInputDVD();
        sound.on();
        sound.setVolume(10);
        dvd.play();
    }


    public void endMovie() {
        dvd.off();
        screen.up();
        sound.off();
        projector.off();
    }
}

package exercises.facade;

import exercises.facade.components.DVDPlayer;
import exercises.facade.components.Projector;
import exercises.facade.components.Screen;
import exercises.facade.components.SurroundSoundSystem;

public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}
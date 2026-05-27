package dz8.player;

import java.util.ArrayList;

public class Winamp {

    static void main() {
        ArrayList<String> songs = new ArrayList<>();
        Playlist playlist = new Playlist("Хиты 2000", songs);

        playlist.addSong("Happy New Year");
        playlist.addSong("Merry Cristmas");
        playlist.addSong("Fabrika Zvezd");

        playlist.deleteSongByIndex(1);

        playlist.updateSongByIndex(1);

        System.out.println(playlist.getSongByIndex(1));

        System.out.println(playlist);
    }
}

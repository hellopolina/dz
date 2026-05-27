package dz8.player;

import java.util.ArrayList;

public class Playlist {
    private String playlistName;
    ArrayList<String> songList;

    public Playlist() {}

    public Playlist(String playlistName, ArrayList<String> songList) {
        this.playlistName = playlistName;
        this.songList = songList;
    }

    public void addSong(String playlistName) {
        songList.add(playlistName);
        System.out.printf("Добавлена песня %s \n", playlistName);
    }

    public void deleteSongByIndex(int index) {
        songList.remove(index);
        System.out.printf("Удалена песня под номером %d \n", index);
    }

    public void updateSongByIndex(int index) {
        songList.set(index, "updated song");
        System.out.printf("Обновлена песня под номером %d \n", index);
    }

    public String getSongByIndex(int index) {
        return songList.get(index);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", songList=" + songList +
                '}';
    }
}

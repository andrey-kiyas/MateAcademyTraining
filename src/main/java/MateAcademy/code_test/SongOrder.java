package MateAcademy.code_test;

/**
 * Make possible initialization using static factory methods.
 * See requirements in task description.
 */
public class SongOrder {
    private String singer;
    private String songName;

    //implement this class
    public SongOrder(String singer, String songName) {
        this.singer = singer;
        this.songName = songName;
    }

    public static SongOrder of(String singer, String songName) {
        return new SongOrder(singer, songName);
    }

    public SongOrder(String singer) {
        this.singer = singer;
        this.songName = "";
    }

    public static SongOrder of(String singer) {
        return new SongOrder(singer);
    }

    public String getSinger() {
        return singer;
    }

    public SongOrder setSinger(String singer) {
        this.singer = singer;
        return this;
    }

    public String getSongName() {
        return songName;
    }

    public SongOrder setSongName(String songName) {
        this.songName = songName;
        return this;
    }

    @Override
    public String toString() {
        if (this.singer != null && this.songName == null){
            return "Play any Bon Jovi song";
        } else if (this.singer != null && this.songName != null){
            return "Play Bon Jovi song called \"It's my life\"";
        } else if (this.singer == null && this.songName == null){
            return "You haven't chosen a singer. Please make your choice)";
        }



        return "SongOrder{" +
                "singer='" + singer + '\'' +
                ", songName='" + songName + '\'' +
                '}';
    }
}

package videos;

public class Channel {
    private String channelName;
    private int numberOfMembers;
    private int numberOfVideos;

    public Channel(String channelName, int numberOfMembers, int numberOfVideos) {
        this.channelName = channelName;
        this.numberOfMembers = numberOfMembers;
        this.numberOfVideos = numberOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public int getNumberOfVideos() {
        return numberOfVideos;
    }
}

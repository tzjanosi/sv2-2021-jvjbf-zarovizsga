package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels=new ArrayList<>();

    private void addChannel(Channel channel){
        channels.add(channel);
    }

    public int calculateSumOfVideos(){
        return channels.stream()
                .mapToInt(channel->channel.getNumberOfVideos())
                .sum();
    }

    public void readDataFromFile(Path path){
        //Paths.get("src/test/resources/moviesintheaters.txt")
        List<String> lines;
        try {
            lines= Files.readAllLines(path);
        } catch (IOException ioe) {
//            throw new IllegalStateException("Can not read file: "+path, ioe);
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
        process(lines);
    }
    private void process(List<String> lines){
        for(int i=1;i< lines.size();i++){
            processLine(lines.get(i));
        }
    }
    private void processLine(String line) {
        String[] fieldsArray;
        String name;
        fieldsArray=line.split(";");
        name=fieldsArray[0];
        Channel channel=new Channel(name,Integer.parseInt(fieldsArray[1]),Integer.parseInt(fieldsArray[2]));
        channels.add(channel);
    }

    public List<Channel> getChannels() {
        return channels;
    }
}

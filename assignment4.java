import java.util.ArrayList;
import java.util.Scanner;

interface IMediaStandard{
    String getMediaInfo();
}
interface IAudioStandard extends IMediaStandard {
    String getAudioCodec();
}
interface IImageStandard extends IMediaStandard{
    String getImageCodec();
}
abstract class Media{
    private String fileName;
    private int id;
    private static int nextId = 1;
    public Media(){
        id = nextId++;
    }
    public Media(String fileName){
        id = nextId++;
        this.fileName = fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
class Image extends Media implements IImageStandard{

    private String imageCodec;
    public Image(String name, String imageCodec){
        super(name);
        this.imageCodec = imageCodec;
    }
    @Override
    public String getMediaInfo() {
        return "Image ID: " + getId() +
                "\nImage name: " + getFileName() +
                "\nImage codec: " + imageCodec;
    }

    @Override
    public String getImageCodec() {
        return "Image codec: " + imageCodec;
    }
}
class Music extends Media implements IAudioStandard{

    private String audioCodec;
    public Music(String name, String audioCodec){
        super(name);
        this.audioCodec = audioCodec;
    }
    @Override
    public String getMediaInfo() {
        return "Image ID: " + getId() +
                "\nImage name: " + getFileName() +
                "\nImage codec: " + audioCodec;
    }

    @Override
    public String getAudioCodec() {
        return "Audio codec: " + audioCodec;
    }
}
class Video extends Media implements IImageStandard, IAudioStandard{

    private String imageCodec;
    private String audioCodec;
    public Video (String name, String imageCodec, String audioCodec){
        super(name);
        this.imageCodec = imageCodec;
        this.audioCodec = audioCodec;
    }
    @Override
    public String getMediaInfo() {
        return "Video ID: " + getId() +
                "\nVideo name: " + getFileName() +
                "\nImage name: " + getImageCodec() +
                "\nAudio name: " + audioCodec;
    }

    @Override
    public String getAudioCodec() {
        return "Audio codec: " + audioCodec;
    }

    @Override
    public String getImageCodec() {
        return "Image codec: " + imageCodec;
    }
}
public class assignment4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList allMedia = new ArrayList<>();
        boolean quit = false;
        System.out.println("[Codec Manager]");
        do {
            System.out.println("1-Add Image" +
                    "\n2-Add Music" +
                    "\n3-Add Video" +
                    "\n4-Show images" +
                    "\n5-Show music" +
                    "\n6-Show videos" +
                    "\n7-Show images and videos" +
                    "\n8-Shows music and videos" +
                    "\n9-Exit" +
                    "\nEnter option: ");
            String response = sc.next();

            switch (response){
                case("1"):
                    System.out.print("Enter file name: ");
                    String nameOne = sc.next();
                    System.out.print("Enter image codec: ");
                    String imageCodecOne = sc.next();
                    Image image = new Image(nameOne, imageCodecOne);
                    allMedia.add(image);
                    break;
                case("2"):
                    System.out.print("Enter file name: ");
                    String nameTwo = sc.next();
                    System.out.print("Enter audio codec: ");
                    String audioCodecTwo = sc.next();
                    Music music = new Music(nameTwo, audioCodecTwo);
                    allMedia.add(music);
                    break;
                case("3"):
                    System.out.println("Enter file name: ");
                    String nameThree = sc.next();
                    System.out.print("Enter image codec: ");
                    String imageCodecThree = sc.next();
                    System.out.println("Enter audio codec: ");
                    String audioCodecThree = sc.next();
                    Video video = new Video(nameThree,imageCodecThree,audioCodecThree);
                    allMedia.add(video);
                    break;
                case("4"):
                    for (Object media : allMedia){
                        if (media instanceof Image){
                            System.out.println(((Image) media).getMediaInfo() + "\n");
                        }
                    }
                    break;
                case("5"):
                    for (Object media : allMedia) {
                        if (media instanceof Music) {
                            System.out.println(((Music) media).getMediaInfo() + "\n");
                        }
                    }
                    break;
                case("6"):
                    for (Object media : allMedia){
                        if (media instanceof Video){
                            System.out.println(((Video) media).getMediaInfo() + "\n");
                        }
                    }
                    break;
                case("7"):
                    for (Object media : allMedia){
                        if (media instanceof IImageStandard){
                            System.out.println(((IImageStandard) media).getMediaInfo() + "\n");
                        }
                    }
                    break;
                case("8"):
                    for (Object media : allMedia) {
                        if (media instanceof IAudioStandard) {
                            System.out.println(((IAudioStandard) media).getMediaInfo() + "\n");
                        }
                    }
                    break;
                case("9"):
                    System.out.println("Shutting off...");
                    quit=true;
                    break;

                default:System.out.println("Invalid response, try again.");
            }
        }while (!quit);
    }
}

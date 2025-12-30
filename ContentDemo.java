import java.util.ArrayList;

public class ContentDemo {

    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java Basics", 2024, 90, "HD"));
        items.add(new VideoLecture("OOP in Java", 2023, 120, "4K"));

        items.add(new PodcastEpisode("Tech Talk", 2024, 45, "Alice"));
        items.add(new PodcastEpisode("Java Stories", 2021, 60, "Bob"));

        int currentYear = java.time.Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(
                    item + " | licenseCost=" +
                            item.getLicenseCost(currentYear)
            );

            if (item instanceof Downloadable d) {
                d.download();
                System.out.println("Max downloads/day: " + d.getMaxDownloadsPerDay());
            }

            System.out.println("...");
        }
    }
}

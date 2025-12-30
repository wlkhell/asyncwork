public class VideoLecture extends ContentItem implements Downloadable {
    private String quality;

    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        setQuality(quality);
    }

    public String getQuality() { return quality; }
    public void setQuality(String quality) {
        if (quality == null || quality.isBlank()) {
            throw new IllegalArgumentException("Quality cannot be blank.");
        }
        this.quality = quality;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int age = getAge(currentYear);
        int ageFactor;

        if (age <= 2) {
            ageFactor = 5;
        } else {
            ageFactor = 2;
        }
        return 0.05 * getDurationMinutes() + ageFactor;
    }

    @Override
    public void download() {
        System.out.println("Downloading video in " + quality + "...");
    }
    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }
    @Override
    public String toString() {
        return "VideoLecture{" + super.toString() + ", quality='" + quality + '\'' + '}';
    }
}

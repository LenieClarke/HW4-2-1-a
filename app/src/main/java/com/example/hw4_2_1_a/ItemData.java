package com.example.hw4_2_1_a;

public class ItemData {
    private int imageId;
    private String title;
    private String subtitle;
    private boolean checked;

    public ItemData(int imageId, String title, String subtitle, boolean checked) {
        this.imageId = imageId;
        this.title = title;
        this.subtitle = subtitle;
        this.checked = checked;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}

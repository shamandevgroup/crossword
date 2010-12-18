package biz.shaman.android.crossword.model;

public class Crossword
{
    public final int     width;

    public final int     height;

    @SuppressWarnings("unused")
    private final Legend legend;

    private Crossword(int width, int height, Legend legend)
    {
        this.width = width;
        this.height = height;
        this.legend = legend;
    }

}

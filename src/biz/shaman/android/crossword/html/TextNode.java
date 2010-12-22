package biz.shaman.android.crossword.html;

public class TextNode extends Node
{
    private final String string;

    public TextNode(String string)
    {
        this.string = string;
    }

    @Override
    public String toString()
    {
        return this.string;
    }
}

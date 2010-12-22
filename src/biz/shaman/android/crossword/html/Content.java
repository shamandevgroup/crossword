package biz.shaman.android.crossword.html;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Content
{
    private final List<Node> nodes = new ArrayList<Node>();

    public void addTag(Tag tag)
    {
        this.nodes.add(tag);
    }

    public void addText(String text)
    {
        this.nodes.add(new TextNode(text));
    }

    @Override
    public String toString()
    {
        if (this.nodes.size() == 1)
        {
            return this.nodes.get(0).toString();
        }

        StringBuffer out = new StringBuffer();
        ListIterator<Node> iterator = this.nodes.listIterator();
        while (iterator.hasNext())
        {
            out.append("\n");
            out.append(iterator.next());
        }
        return out.toString();
    }
}

package biz.shaman.android.crossword.html;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class Attributes
{
    private List<Attribute> attributes = new ArrayList<Attribute>();

    public void add(Attribute attribute)
    {
        this.attributes.add(attribute);
    }

    public String toString()
    {
        StringBuffer out = new StringBuffer();
        ListIterator<Attribute> iterator = this.attributes.listIterator();
        while (iterator.hasNext())
        {
            out.append(' ');
            out.append(iterator.next());
        }
        return out.toString();
    }
}

package biz.shaman.android.crossword.html;

public class Tag extends Node
{
    private static final String HTML       = "html";
    private static final String HEAD       = "head";
    private static final String TITLE      = "title";
    private static final String BODY       = "body";
    private static final String TABLE      = "table";
    private static final String TABLE_BODY = "tbody";
    private static final String TR         = "tr";
    private static final String TD         = "td";
    private static final String BR         = "br";
    private static final String H1         = "h1";
    private static final String H7         = "h7";

    private final String        name;
    private final Attributes    attributes = new Attributes();
    private final Content       content    = new Content();
    private boolean             isClosed;

    public static Tag html()
    {
        return new Tag(HTML);
    }

    public static Tag head()
    {
        return new Tag(HEAD);
    }

    public static Tag title()
    {
        return new Tag(TITLE);
    }

    public static Tag body()
    {
        return new Tag(BODY);
    }

    public static Tag table()
    {
        return new Tag(TABLE);
    }

    public static Tag tbody()
    {
        return new Tag(TABLE_BODY);
    }

    public static Tag tr()
    {
        return new Tag(TR);
    }

    public static Tag td()
    {
        return new Tag(TD);
    }

    public static Tag br()
    {
        return new Tag(BR, false);
    }

    public static Tag h1()
    {
        return new Tag(H1);
    }

    public static Tag h7()
    {
        return new Tag(H7);
    }

    private Tag(String name)
    {
        this.name = name.toLowerCase();
        this.isClosed = true;
    }

    private Tag(String name, boolean isClosed)
    {
        this.name = name.toLowerCase();
        this.isClosed = isClosed;
    }

    public void addAttribute(Attribute attribute)
    {
        this.attributes.add(attribute);
    }

    public Tag addTag(Tag tag)
    {
        this.content.addTag(tag);
        return this;
    }

    public Tag addText(String text)
    {
        this.content.addText(text);
        return this;
    }

    public String toString()
    {
        StringBuffer out = new StringBuffer("<" + name);
        out.append(attributes.toString());
        out.append(">");
        if (content != null) out.append(content);
        if (isClosed) out.append("</" + name + ">");
        return out.toString();
    }
}

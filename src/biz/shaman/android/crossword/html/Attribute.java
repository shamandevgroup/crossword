package biz.shaman.android.crossword.html;

public class Attribute
{
    private final String       name;
    private final String       value;
    private final boolean      withValue;

    public static final String ID           = "id";
    public static final String CLASS        = "class";
    public static final String ON_CLICK     = "onClick";

    public static final String BORDER       = "border";
    public static final String CELL_PADDING = "cellpadding";
    public static final String CELL_SPACING = "cellspacing";

    public static final String ALIGN        = "align";

    public Attribute(String name)
    {
        if (name == null) throw new NullPointerException();
        this.name = name.toLowerCase();
        this.value = "";
        this.withValue = false;
    }

    public Attribute(String name, String value)
    {
        if (name == null) throw new NullPointerException();
        this.name = name.toLowerCase();
        this.value = value;
        this.withValue = true;
    }

    public String toString()
    {
        if (withValue)
        {
            return this.name + "=\"" + this.value + "\"";
        }
        else
        {
            return this.name;
        }
    }
}

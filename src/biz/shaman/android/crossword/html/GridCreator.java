package biz.shaman.android.crossword.html;

import biz.shaman.android.crossword.js.JSInterface;


public class GridCreator
{
    private static String JS_INTERFACE_NAME = JSInterface.class.getSimpleName();

    public static String getInstance()
    {
        Tag title = Tag.title();
        title.setText("HTML generator example");

        Tag head = Tag.head();
        head.addTag(title);

        Tag h1 = Tag.h7();
        h1.setText("HTML Generator demo");

        Tag tableBody = Tag.tbody();
        tableBody.addAttribute(new Attribute(Attribute.ALIGN, "center"));

        Tag row;
        Tag cell;
        String id;

        for (int i = 0; i < 5; ++i)
        {
            row = Tag.tr();

            for (int j = 0; j < 5; ++j)
            {
                id = "c_" + (i + 1) + "x" + (j + 1);
                cell = Tag.td();
                cell.setText(Integer.toString(i));
                cell.addAttribute(new Attribute(Attribute.ID, id));
                cell.addAttribute(new Attribute(Attribute.CLASS, "letter"));
                cell.addAttribute(new Attribute(Attribute.ON_CLICK, JS_INTERFACE_NAME + ".onClick(" + (i + 1) + ", " + (j + 1) + ", getCellContent('" + id + "'))"));
                row.addTag(cell);
            }

            tableBody.addTag(row);
        }

        Tag table = Tag.table();
        table.addAttribute(new Attribute(Attribute.BORDER, "1"));
        table.addAttribute(new Attribute(Attribute.CELL_PADDING, "0"));
        table.addAttribute(new Attribute(Attribute.CELL_SPACING, "0"));
        table.addTag(tableBody);

        Tag body = Tag.body();
        body.addTag(h1);
        body.addTag(table);
        body.addTag(Tag.br());
        body.setText("End of Example");

        Tag html = Tag.html();
        html.addTag(head);
        html.addTag(body);

        return html.toString();
    }
}

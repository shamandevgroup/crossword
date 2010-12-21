package biz.shaman.android.crossword.js;

import android.content.Context;
import android.widget.Toast;


public class JSInterface
{
    private final Context context;

    public JSInterface(Context context)
    {
        if (context == null) throw new NullPointerException();
        this.context = context;
    }

    public void onClick(int x, int y, String message)
    {
        Toast.makeText(this.context, "x = " + x + ", y = " + y + ", cell content: " + message, Toast.LENGTH_SHORT).show();
    }

    public void log(String message)
    {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
    }
}

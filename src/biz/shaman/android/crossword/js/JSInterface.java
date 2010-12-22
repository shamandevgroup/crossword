package biz.shaman.android.crossword.js;

import android.content.Context;
import android.webkit.WebView;
import android.widget.Toast;


public class JSInterface
{
    private final WebView webView;
    private final Context context;

    public JSInterface(Context context, WebView webView)
    {
        if (context == null) throw new NullPointerException();
        this.context = context;
        this.webView = webView;
    }

    public void onClick(int x, int y, String message)
    {
        webView.loadUrl("javascript:{ setCellContent(" + x + ", " + y + ", 'x'); };");
        Toast.makeText(this.context, "x = " + x + ", y = " + y + ", cell content: " + message, Toast.LENGTH_SHORT).show();
    }

    public void log(String message)
    {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show();
    }
}

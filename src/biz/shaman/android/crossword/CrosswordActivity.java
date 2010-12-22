package biz.shaman.android.crossword;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import biz.shaman.android.crossword.html.GridCreator;
import biz.shaman.android.crossword.js.JSInterface;


public class CrosswordActivity extends Activity
{
    private static final String LOG_TAG = CrosswordActivity.class.getSimpleName();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView webView = ((WebView) findViewById(R.id.crossword_webview));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.addJavascriptInterface(new JSInterface(this), JSInterface.class.getSimpleName());
        // webView.loadData(readRawResource(getResources(), R.raw.sample1_view), "text/html", "utf8");

        String tools = readRawResource(getResources(), R.raw.tools);
        String style = readRawResource(getResources(), R.raw.style);
        String html = GridCreator.getInstance();
        String all = style + tools + html;
        Log.d("TEST", all);
        webView.loadData(all, "text/html", "utf8");
    }

    private static String readRawResource(Resources resources, int id)
    {
        InputStream is = resources.openRawResource(id);

        try
        {
            if (is != null)
            {
                InputStreamReader reader = new InputStreamReader(is);
                char[] buffer = new char[1024];

                StringBuilder builder = new StringBuilder();
                int count;
                while ((count = reader.read(buffer)) != -1)
                {
                    builder.append(buffer, 0, count);
                }

                return builder.toString();
            }
        }
        catch (IOException ex)
        {
            Log.e(LOG_TAG, "Can not read the raw resource: " + resources.getResourceName(id), ex);
        }
        finally
        {
            if (is != null)
            {
                try
                {
                    is.close();
                }
                catch (IOException ex)
                {
                    Log.w(LOG_TAG, "Can not close stream from raw resource: " + resources.getResourceName(id), ex);
                }
            }
        }

        return "";
    }
}

package org.jvnet.hudson.test;

import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.DefaultJavaScriptErrorListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyJSListener extends DefaultJavaScriptErrorListener {

    private static final Log LOG = LogFactory.getLog(MyJSListener.class);

    @Override
    public void scriptException(final HtmlPage page, final ScriptException scriptException) {
        if (LOG.isErrorEnabled()) {
            LOG.error(page);
            LOG.error(scriptException.getScriptSourceCode());
            LOG.error(scriptException.getFailingColumnNumber());
            LOG.error(scriptException.getFailingLine());
            LOG.error(scriptException.getMessage());
            LOG.error("Error during JavaScript execution", scriptException);
        }
    }
}

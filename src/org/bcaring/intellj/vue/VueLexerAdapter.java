package org.bcaring.intellj.vue;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

import java.io.Reader;

/**
 * auth : bqxu
 * create_at:  16/6/5.
 * desc:
 * note:
 * 1.
 */
public class VueLexerAdapter extends FlexAdapter {

    public VueLexerAdapter() {
        super(new VueLexer((Reader) null));
    }
}

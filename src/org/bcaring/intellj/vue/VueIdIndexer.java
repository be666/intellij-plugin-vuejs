package org.bcaring.intellj.vue;

import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer;
import com.intellij.psi.impl.cache.impl.id.LexerBasedIdIndexer;

public class VueIdIndexer extends LexerBasedIdIndexer {

    public static Lexer createIndexingLexer(OccurrenceConsumer consumer) {
        return new VueFilterLexer(new VueLexerAdapter(), consumer);
    }

    @Override
    public Lexer createLexer(final OccurrenceConsumer consumer) {
        return createIndexingLexer(consumer);
    }
}

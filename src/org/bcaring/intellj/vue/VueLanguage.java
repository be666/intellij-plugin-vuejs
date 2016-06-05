package org.bcaring.intellj.vue;

import com.intellij.lang.Language;

/**
 * auth : bqxu
 * create_at:  16/6/5.
 * desc:
 * note:
 * 1.
 */
public class VueLanguage extends Language {

    public static final VueLanguage INSTANCE = new VueLanguage();


    protected VueLanguage() {
        super("Vue");
    }
}

package org.bcaring.intellj.vue;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

/**
 * auth : bqxu
 * create_at:  16/6/6.
 * desc:
 * note:
 * 1.
 */
public class VueCommenter implements Commenter {

    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return "#";
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return "";
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

}

package dev.ultreon.quentangle.api;

import dev.ultreon.quentangle.platform.Platform;
import dev.ultreon.quentangle.util.IVec;

public interface IBlockVec {
    static IBlockVec fromVec(IVec pos) {
        return Platform.PLATFORM.createBlockVec(pos);
    }

    int quent$x();
    int quent$y();
    int quent$z();
}

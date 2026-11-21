package dev.ultreon.quentangle.util;

import dev.ultreon.quentangle.api.IBlockVec;

public interface IBlockHit extends IHit {
    IBlockVec quent$blockVec();

    Direction quent$direction();
}

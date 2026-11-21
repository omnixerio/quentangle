package dev.ultreon.quentangle.api;

public interface IBlockSettings {
    IBlockSettings quent$hardness(float hardness);
    
    IBlockSettings quent$resistance(float resistance);
    
    IBlockSettings quent$strength(float strength);
    
    IBlockSettings quent$strength(float hardness, float resistance);

    IBlockSettings quent$replaceable();
}

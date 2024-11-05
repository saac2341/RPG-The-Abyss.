package rpg.enums;

import rpg.utils.cache.PictureCache;

import javax.swing.*;
import java.awt.image.BufferedImage;

public enum BarType {

    LIFE, MAGIC, EXPERIENCE;

    BufferedImage container;
    BufferedImage icon;
    BufferedImage bar;

    BarType(){
        switch (this){
            case LIFE -> {
                container = PictureCache.addImage("life_container", "InterfacePlugins/Pixel/EstadarteVP.png");
                icon = PictureCache.addImage("life_icon","InterfacePlugins/Pixel/LogoVP.png");
                bar = PictureCache.addImage("life_bar","InterfacePlugins/Pixel/BarraVP.png");
            }
            case MAGIC -> {

            }
            case EXPERIENCE -> {

            }
        }
    }

    public BufferedImage getContainer(){
        return container;
    }

    public BufferedImage getIcon(){
        return icon;
    }

    public BufferedImage getBar(){
        return bar;
    }

}

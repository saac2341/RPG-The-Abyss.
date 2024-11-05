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
                container = PictureCache.addImage("life_container", "InterfacePlugins/Normal/EstandarteV.png");
                icon = PictureCache.addImage("life_icon","InterfacePlugins/Normal/LogoV.png");
                bar = PictureCache.addImage("life_bar","InterfacePlugins/Normal/BarraV.png");
            }
            case MAGIC -> {
                container = PictureCache.addImage("magic_container", "InterfacePlugins/Magic/EstandarteM.png");
                icon = PictureCache.addImage("magic_icon","InterfacePlugins/Magic/LogoM.png");
                bar = PictureCache.addImage("magic_bar","InterfacePlugins/Magic/BarraM.png");
            }
            case EXPERIENCE -> {
                container = PictureCache.addImage("experience_container", "InterfacePlugins/Experience/EstandarteE.png");
                icon = PictureCache.addImage("experience_icon","InterfacePlugins/Experience/LogoE.png");
                bar = PictureCache.addImage("experience_bar","InterfacePlugins/Experience/BarraE.png");
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

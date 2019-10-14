package ogg;

import Plugin.IPlayerPlugin;

import java.io.File;

public class ogg implements IPlayerPlugin {
    private File filename;
    public ogg(File filename)
    {
        this.filename=filename;
    }

    public void service(){
        new gui(filename.getName()+"正在播放！！！");
    }

}

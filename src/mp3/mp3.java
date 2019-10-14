package mp3;

import Plugin.IPlayerPlugin;
import java.io.File;

public class mp3 implements IPlayerPlugin {
    private File filename;
    public mp3(File filename)
    {
        this.filename=filename;
    }
    public void service(){
       new gui(filename.getName()+"正在播放！！！");

    }

}

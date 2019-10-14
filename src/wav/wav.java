package wav;

import Plugin.IPlayerPlugin;

import java.io.File;

public class wav implements IPlayerPlugin {
    private File filename;
    public wav(File filename)
    {
        this.filename=filename;
    }
    public void service(){
        new gui (filename.getName()+"正在播放！！！");

    }

}

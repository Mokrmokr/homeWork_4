package utils;

public abstract class ChromeMode {
    public void chromeMode (String ...mode) {
        if (mode.length > 0) {
            for (int i = 0; i < mode.length; i++) {
                System.out.println("Драйвер поднят в режиме " + mode[i]);
            }
        } else {
            System.out.println("Драйвер поднят");
        }
    }
}

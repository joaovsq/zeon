package app.zeon.utils;

public enum LogModule {

    WITNESS("Witness"),
    RECEIVER("Receiver"),
    MAIN("Main");

    String value;

    LogModule(String value) {
        this.value = value;
    }

    public String get() {
        return this.value;
    }

}

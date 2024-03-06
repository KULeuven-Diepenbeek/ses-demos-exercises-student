module be.kuleuven.scorebord {
    requires com.google.gson;
    exports be.kuleuven;

    opens be.kuleuven to com.google.gson;
}
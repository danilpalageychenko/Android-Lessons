package com.example.danil.android.forMockitoTest;

/**
 * Created by _dani on 07.02.2017.
 */
public class FileSaver {
    private final FileEncoder encoder;

    public FileSaver(FileEncoder encoder) {
        this.encoder = encoder;
    }

    public void save(String... lines) {
        for(String line: lines){
            encoder.encode(line);
        }

    }
}

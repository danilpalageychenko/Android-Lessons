package com.example.danil.android;

import android.content.Context;
import android.content.SharedPreferences;

import android.support.test.InstrumentationRegistry;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by _dani on 07.02.2017.
 */
public class PreferencesSharedTest {
    @Test
    public void notExistedValueInSharedPreferences() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        SharedPreferences audio = context.getSharedPreferences("audio", Context.MODE_PRIVATE);
        int duration = audio.getInt("duration", -1);
        assertEquals(-1, duration);
    }

    @Test
    public void saveDurationInSharedPreferences ()
    {
        Context context = InstrumentationRegistry.getTargetContext();
        SharedPreferences audio = context.getSharedPreferences("audio", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = audio.edit();
        editor.putInt("duration",100);
        assertTrue(editor.commit());
        assertEquals(100, audio.getInt("duration", -1));
    }
}

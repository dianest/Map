package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    @Test
    void register() {
        FileOpenManager manager = new FileOpenManager();
        manager.register(".html", "Google Chrome");
        assertEquals("Google Chrome", manager.getApplicationByExtension(".html"));
    }

    @Test
    void getApplicationByExtension() {
        FileOpenManager manager = new FileOpenManager();
        manager.register(".html", "Google Chrome");
        assertEquals("Google Chrome", manager.getApplicationByExtension(".html"));
    }

    @Test
    void removeExtension() {
        FileOpenManager manager = new FileOpenManager();
        manager.register(".html", "Google Chrome");
        manager.removeExtension(".html");
        assertNull(manager.getApplicationByExtension(".html"));
    }

    @Test
    void getAllExtensions() {
        FileOpenManager manager = new FileOpenManager();
        manager.register(".html", "Google Chrome");
        manager.register(".docx", "Word");
        manager.register(".xls", "Excel");
        List<String> expected = Arrays.asList(".docx", ".html", ".xls");
        assertThat(manager.getAllExtensions(), is(expected));
    }

    @Test
    void getAllApplications() {
        FileOpenManager manager = new FileOpenManager();
        manager.register(".html", "Google Chrome");
        manager.register(".docx", "Word");
        manager.register(".xls", "Excel");
        manager.register(".txt", "Word");
        List<String> expected = Arrays.asList("Excel", "Google Chrome", "Word");
        assertThat(manager.getAllApplications(), is(expected));
    }
}
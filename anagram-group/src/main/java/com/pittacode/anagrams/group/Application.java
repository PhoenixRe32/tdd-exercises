package com.pittacode.anagrams.group;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.pittacode.anagrams.group.key.KeyGenerator.keyGenerator;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class Application {

    private final AnagramGrouper anagramGrouper;
    private final String anagramsFile;

    public static void main(String[] args) {
        var application = new Application();
        application.run();
    }

    public Application() {
        anagramGrouper = new AnagramGrouper(keyGenerator());
        anagramsFile = "anagrams.txt";
    }

    private void run() {
        var anagrams = readLinesFromResource(anagramsFile);
        var groups = anagramGrouper.group(anagrams);
        printAnagramGroups(groups);
    }

    private Collection<String> readLinesFromResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException(format("%s not found! ", fileName));
        }

        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(toList());
    }

    private void printAnagramGroups(Map<String, Collection<String>> groups) {
        for (var group : groups.entrySet()) {
            System.out.println();
            System.out.println(group.getKey());
            System.out.println("-".repeat(group.getKey().length()));
            for (var anagram : group.getValue()) {
                System.out.printf("\t\t%s%n", anagram);
            }
        }
    }
}

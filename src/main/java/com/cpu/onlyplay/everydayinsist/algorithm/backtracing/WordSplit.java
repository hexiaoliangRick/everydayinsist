package com.cpu.onlyplay.everydayinsist.algorithm.backtracing;

import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: everydayinsist
 * @description:
 * @author: cpuRick
 * @create: 2022-08-18 20:40
 **/
public class WordSplit {
    public static void main(String[] args) {
        List<String> result = wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        result.forEach(item -> {
            System.out.println(item);
        });
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> values = new LinkedHashSet<>(wordDict);
        List<String> result = new LinkedList<>();
        backtracing(s, 0, values, new HashSet<>(), result, new LinkedList<>());
        return result;
    }

    private static void backtracing(String value, int startIndex, Set<String> paths, Set<String> visited, List<String> result, Deque<String> current) {
        if (startIndex >= value.length()) {
            result.add(String.join(" ", current));
            return;
        }
        for (int j = startIndex + 1; j <= value.length(); j++) {
            String path = value.substring(startIndex, j);
            if (visited.contains(path)) {
                continue;
            }
            if (path.equals("cats") || path.equals("cat")) {
                System.out.println("cats");
            }
            if (paths.contains(path)) {
                current.addLast(path);
                backtracing(value, j, paths, visited, result, current);
                current.removeLast();
            } else {
                visited.add(path);
            }
        }
    }
}

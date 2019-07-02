package com.ongres.string_prep.core.parsers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ParserMappingTables {
    
    private ParserMappingTables() {
    }
    
    private static final Pattern LINE_PATTERN = Pattern.compile("([^;]*);([^;]*);[^;]*");
    private static final Pattern CODE_POINTS_PATTERN = Pattern.compile("\\s*([0-9A-F]+)");
    
    public static List<Integer> parseMapToNothing() throws IOException {
        return new ParserUtil().parseToListInteger("/b1", LINE_PATTERN);
    }
    
    public static Map<Integer, List<Integer>> parseMapUsedWithNFKC() throws IOException {
        return new ParserUtil().parseToMapListInteger("/b2", LINE_PATTERN, CODE_POINTS_PATTERN);
    }
    
    public static Map<Integer, List<Integer>> parseMapUsedWithNoNormalization() throws IOException {
        return new ParserUtil().parseToMapListInteger("/b3", LINE_PATTERN, CODE_POINTS_PATTERN);
    }
}

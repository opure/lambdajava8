package com.oneler.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by opure on 2017/6/13.
 */
public class ListFiles {
    public static void main(final String[] args) {
        File f = new File(".");
        String[] list;
        if (args.length == 0) {
            list = f.list();
        } else {
            list = f.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                @Override
                public boolean accept(final File dir, final String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list != null ? list : new String[0], String.CASE_INSENSITIVE_ORDER);
        Arrays.stream(list).forEach(x -> System.out.println(x));

    }
}

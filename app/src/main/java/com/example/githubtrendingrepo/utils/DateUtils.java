package com.example.githubtrendingrepo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final String GITHUB_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    /**
     * Convertit une date GitHub ISO 8601 en une chaîne lisible (ex: 22 Oct 2017).
     */
    public static String formatGitHubDate(String githubDate) {
        SimpleDateFormat parser = new SimpleDateFormat(GITHUB_DATE_FORMAT, Locale.US);
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
        try {
            Date date = parser.parse(githubDate);
            if (date != null) {
                return formatter.format(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return githubDate; // fallback to original if parse fails
    }
}

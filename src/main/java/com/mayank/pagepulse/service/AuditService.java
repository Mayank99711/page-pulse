package com.mayank.pagepulse.service;

import com.mayank.pagepulse.dto.AuditResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuditService {

    public AuditResponse analyze(String url) throws IOException {

        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("URL cannot be empty.");
        }

        url = url.trim();

        // Automatically prepend https://
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        long start = System.currentTimeMillis();

        Connection connection = Jsoup.connect(url)
                .userAgent("Mozilla/5.0")
                .timeout(10000)
                .ignoreHttpErrors(true);

        Connection.Response response = connection.execute();

        long end = System.currentTimeMillis();

        String contentType = response.contentType();

        if (contentType == null || !contentType.contains("text/html")) {
            throw new IllegalArgumentException("The URL is not an HTML page.");
        }

        Document doc = response.parse();

        int httpStatus = response.statusCode();

        long responseTime = end - start;

        String title = doc.title().isBlank()
                ? "Not Available"
                : doc.title();

        Element meta = doc.selectFirst("meta[name=description]");

        String metaDescription = meta != null
                ? meta.attr("content")
                : "Not Available";

        int h1Count = doc.select("h1").size();

        int missingAlt = 0;

        Elements images = doc.select("img");

        for (Element img : images) {

            if (!img.hasAttr("alt") ||
                    img.attr("alt").trim().isEmpty()) {

                missingAlt++;
            }
        }

        int wordCount = 0;

        if (doc.body() != null) {

            String text = doc.body().text().trim();

            if (!text.isEmpty()) {

                wordCount = text.split("\\s+").length;

            }

        }

        int seoScore = calculateSeoScore(
                title,
                metaDescription,
                h1Count,
                missingAlt,
                wordCount,
                httpStatus
        );

        return new AuditResponse(
                httpStatus,
                responseTime,
                title,
                metaDescription,
                h1Count,
                missingAlt,
                wordCount,
                seoScore
        );

    }

    private int calculateSeoScore(
            String title,
            String meta,
            int h1,
            int missingAlt,
            int wordCount,
            int status
    ) {

        int score = 100;

        if ("Not Available".equals(title))
            score -= 20;

        if ("Not Available".equals(meta))
            score -= 20;

        if (h1 == 0)
            score -= 15;

        if (missingAlt > 5)
            score -= 15;

        if (wordCount < 300)
            score -= 15;

        if (status >= 400)
            score -= 15;

        return Math.max(score, 0);
    }

}